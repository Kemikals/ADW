package dev.kemikals;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniPayload {
    @JsonProperty("t")
    private Object t;
    @JsonProperty("s")
    private Integer s;
    @JsonProperty("op")
    private Integer op;

    public Object getT() {
        return t;
    }

    public void setT(Object t) {
        this.t = t;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getOp() {
        return op;
    }

    public void setOp(Integer op) {
        this.op = op;
    }

    @Override
    public String toString() {
        return "MiniPayload{" +
                "t=" + t +
                ", s=" + s +
                ", op=" + op +
                '}';
    }
}
