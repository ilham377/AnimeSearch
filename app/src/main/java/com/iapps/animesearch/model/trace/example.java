package com.iapps.animesearch.model.trace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class example implements Serializable {

    @SerializedName("frameCount")
    @Expose
    private Integer frameCount;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("result")
    @Expose
    private List<TraceResult> result = null;

    public Integer getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(Integer frameCount) {
        this.frameCount = frameCount;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TraceResult> getResult() {
        return result;
    }

    public void setResult(List<TraceResult> result) {
        this.result = result;
    }
}
