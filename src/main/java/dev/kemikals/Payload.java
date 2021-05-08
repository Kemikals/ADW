package dev.kemikals;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "t",
        "s",
        "op",
        "EventData"
})

public class Payload {

    @JsonProperty("t")
    private Object t;
    @JsonProperty("s")
    private Object s;
    @JsonProperty("op")
    private Integer op;
    @JsonProperty("d")
    private EventData EventData;

    @JsonProperty("t")
    public Object getT() {
        return t;
    }

    @JsonProperty("t")
    public void setT(Object t) {
        this.t = t;
    }

    @JsonProperty("s")
    public Object getS() {
        return s;
    }

    @JsonProperty("s")
    public void setS(Object s) {
        this.s = s;
    }

    @JsonProperty("op")
    public Integer getOp() {
        return op;
    }

    @JsonProperty("op")
    public void setOp(Integer op) {
        this.op = op;
    }

    @JsonProperty("d")
    public EventData getEventData() {
        return EventData;
    }

    @JsonProperty("d")
    public void setEventData(EventData EventData) {
        this.EventData = EventData;
    }

}