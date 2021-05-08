package dev.kemikals;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocketListener;

public class App
{
    public static void main( String[] args ) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("wss://gateway.discord.gg/?v=8&encoding=json").build();
        WebSocketListener listener = new GatewaySocketListener();
        client.newWebSocket(request, listener);
    }
}
