package dev.kemikals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Properties;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "heartbeat_interval",
        "_trace"
})

public class EventData {

    @JsonProperty("heartbeat_interval")
    private Integer heartbeatInterval;
    @JsonProperty("_trace")
    private List<String> trace = null;
    @JsonProperty("token")
    private String token;

    @JsonProperty("properties")
    private Properties properties;

    @JsonProperty("presence")
    private Properties presence;

    @JsonProperty("properties")
    public Properties getProperties() {
        return properties;
    }
    @JsonProperty("intents")
    private Integer intents;


    @JsonProperty("properties")
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @JsonProperty("presence")
    public void setPresence(Properties presence) {
        this.presence = presence;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("intents")
    public Integer getIntents() {
        return intents;
    }

    @JsonProperty("intents")
    public void setIntents(Integer intents) {
        this.intents = intents;
    }
    @JsonProperty("heartbeat_interval")
    public Integer getHeartbeatInterval() {
        return heartbeatInterval;
    }

    @JsonProperty("heartbeat_interval")
    public void setHeartbeatInterval(Integer heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    @JsonProperty("_trace")
    public List<String> getTrace() {
        return trace;
    }

    @JsonProperty("_trace")
    public void setTrace(List<String> trace) {
        this.trace = trace;
    }
}