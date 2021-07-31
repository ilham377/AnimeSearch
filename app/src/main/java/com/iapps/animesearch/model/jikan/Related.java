package com.iapps.animesearch.model.jikan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Related implements Serializable {

    @SerializedName("Adaptation")
    @Expose
    private List<Adaptation> adaptation = null;
    @SerializedName("Side story")
    @Expose
    private List<SideStory> sideStory = null;
    @SerializedName("Summary")
    @Expose
    private List<Summary> summary = null;

    public List<Adaptation> getAdaptation() {
        return adaptation;
    }

    public void setAdaptation(List<Adaptation> adaptation) {
        this.adaptation = adaptation;
    }

    public List<SideStory> getSideStory() {
        return sideStory;
    }

    public void setSideStory(List<SideStory> sideStory) {
        this.sideStory = sideStory;
    }

    public List<Summary> getSummary() {
        return summary;
    }

    public void setSummary(List<Summary> summary) {
        this.summary = summary;
    }

}