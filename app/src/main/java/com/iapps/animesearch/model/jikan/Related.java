package com.iapps.animesearch.model.jikan;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Related implements Serializable {

    @SerializedName("Adaptation")
    @Expose
    private List<Adaptation> adaptation = null;
    @SerializedName("Alternative version")
    @Expose
    private List<AlternativeVersion> alternativeVersion = null;
    @SerializedName("Side story")
    @Expose
    private List<SideStory> sideStory = null;

    public List<Adaptation> getAdaptation() {
        return adaptation;
    }

    public void setAdaptation(List<Adaptation> adaptation) {
        this.adaptation = adaptation;
    }

    public List<AlternativeVersion> getAlternativeVersion() {
        return alternativeVersion;
    }

    public void setAlternativeVersion(List<AlternativeVersion> alternativeVersion) {
        this.alternativeVersion = alternativeVersion;
    }

    public List<SideStory> getSideStory() {
        return sideStory;
    }

    public void setSideStory(List<SideStory> sideStory) {
        this.sideStory = sideStory;
    }

}