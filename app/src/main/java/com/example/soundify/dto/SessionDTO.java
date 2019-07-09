package com.example.soundify.dto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SessionDTO {
    @SerializedName("token")
    private ArrayList<TokenDTO> token;
}
