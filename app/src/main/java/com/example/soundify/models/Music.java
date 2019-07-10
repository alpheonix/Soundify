package com.example.soundify.models;

public class Music {


    private String title;

    private String preview;

    private String duration;

    private String rank;

    private String bigPic;

    private String mediumPic;


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

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getMediumPic() {
        return mediumPic;
    }

    public void setMediumPic(String mediumPic) {
        this.mediumPic = mediumPic;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                ", duration='" + duration + '\'' +
                ", rank='" + rank + '\'' +
                ", bigPic='" + bigPic + '\'' +
                ", mediumPic='" + mediumPic + '\'' +
                '}';
    }
}
