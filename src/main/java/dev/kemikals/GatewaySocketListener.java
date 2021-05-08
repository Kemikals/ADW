package dev.kemikals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;

import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public final class GatewaySocketListener extends WebSocketListener {
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private ObjectMapper mapper = new ObjectMapper();
    private static final int HELLO = 10;

    private volatile Integer lastValue;


    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        System.out.println(text);
        try {
            MiniPayload payload = mapper.readValue(text, MiniPayload.class);
            if(payload.getS() != null) {
                lastValue = payload.getS();
            }

            System.out.println(payload);
            if(payload.getOp() == HELLO) {
                Payload payload1 = mapper.readValue(text, Payload.class);
                handleHello(payload1, webSocket);
                sendAuth(webSocket);
            }
        } catch (JsonProcessingException  e) {
            e.printStackTrace();
        }
    }

    private void handleHello(Payload payload, WebSocket webSocket){
        executorService.scheduleWithFixedDelay(() -> {
            try {
                System.out.println("Sending heartbeat");
                HeartBeatAck heartBeat = new HeartBeatAck();
                heartBeat.s = lastValue;
                System.out.println(heartBeat);
                webSocket.send(mapper.writeValueAsString(heartBeat));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }, payload.getEventData().getHeartbeatInterval(), payload.getEventData().getHeartbeatInterval(), TimeUnit.MILLISECONDS);
    }

    private void sendAuth(WebSocket socket) throws JsonProcessingException {
        Payload payload = new Payload();
        payload.setOp(2);
        EventData data = new EventData();
        payload.setEventData(data);
        data.setToken("get your own");
        data.setIntents(513);
        Properties properties = new Properties();
        properties.put("$os", "windows");
        properties.put("$browser", "Another Discord Wrapper (ADW)");
        properties.put("$device", "Another Discord Wrapper (ADW)");
        data.setProperties(properties);
        Properties presence = new Properties();
        presence.put("status", "online");
        data.setPresence(presence);
        System.out.println(mapper.writeValueAsString(payload));
        socket.send(mapper.writeValueAsString(payload));
    }

    @Override
    public void onFailure(@NotNull WebSocket socket, @NotNull Throwable t, Response response){
        // TODO enable reconnect
        System.out.println(response);
    }

    @Override
    public void onClosing(@NotNull WebSocket socket, int code, @NotNull String reason){
        System.out.println("Closing socket");
        //TODO enable reconnect
        System.out.println(reason);
    }
}