package com.iapps.animesearch.model.trace;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Anilist {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("idMal")
    @Expose
    private Integer idMal;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("synonyms")
    @Expose
    private List<String> synonyms = null;
    @SerializedName("isAdult")
    @Expose
    private Boolean isAdult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdMal() {
        return idMal;
    }

    public void setIdMal(Integer idMal) {
        this.idMal = idMal;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Boolean getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(Boolean isAdult) {
        this.isAdult = isAdult;
    }

}
