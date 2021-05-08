package dev.kemikals;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeartBeatAck {
    @JsonProperty("op")
    int op = 1;

    @JsonProperty("d")
    int s;

    @Override
    public String toString() {
        return "HeartBeatAck{" +
                "op=" + op +
                ", s=" + s +
                '}';
    }
}
