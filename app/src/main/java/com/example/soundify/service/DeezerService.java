package com.example.soundify.service;

import com.example.soundify.dto.MusicDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DeezerService {

    @GET("4818186184")
    Call<MusicDTO> getPlaylist();
}
