package com.example.soundify.dto;

import com.google.gson.annotations.SerializedName;

public class DataDTO {


    @SerializedName( "title")
    private String title;
    @SerializedName( "duration")
    private String duration;
    @SerializedName( "preview")
    private String preview;
    @SerializedName( "rank")
    private String rank;

    public DataDTO(String title, String duration, String preview, String rank) {
        this.title = title;
        this.duration = duration;
        this.preview = preview;
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "DataDTO{" +
                "title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                ", duration='" + duration + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
