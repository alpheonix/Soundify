package com.example.soundify.dto;

import com.google.gson.annotations.SerializedName;

public class MusicDTO {



    @SerializedName( "picture_big")
    private String bigPic;
    @SerializedName( "picture_medium")
    private String mediumPic;

    private TracksDTO tracks;

    public MusicDTO(String smallPic, String mediumPic, TracksDTO tracks) {
        this.bigPic = smallPic;
        this.mediumPic = mediumPic;
        this.tracks = tracks;
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

    public TracksDTO getTracks() {
        return tracks;
    }

    public void setTracks(TracksDTO tracks) {
        this.tracks = tracks;
    }
}
