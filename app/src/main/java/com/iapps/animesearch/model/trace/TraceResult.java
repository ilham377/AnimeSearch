package com.iapps.animesearch.model.trace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TraceResult implements Serializable {

    @SerializedName("anilist")
    @Expose
    private Integer anilist;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("episode")
    @Expose
    private Integer episode;
    @SerializedName("from")
    @Expose
    private Double from;
    @SerializedName("to")
    @Expose
    private Double to;
    @SerializedName("similarity")
    @Expose
    private Double similarity;
    @SerializedName("video")
    @Expose
    private String video;
    @SerializedName("image")
    @Expose
    private String image;

    public Integer getAnilist() {
        return anilist;
    }

    public void setAnilist(Integer anilist) {
        this.anilist = anilist;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Double getFrom() {
        return from;
    }

    public void setFrom(Double from) {
        this.from = from;
    }

    public Double getTo() {
        return to;
    }

    public void setTo(Double to) {
        this.to = to;
    }

    public Double getSimilarity() {
        return similarity;
    }

    public void setSimilarity(Double similarity) {
        this.similarity = similarity;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
