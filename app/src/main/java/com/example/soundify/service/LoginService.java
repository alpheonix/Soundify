package com.example.soundify.service;

import com.example.soundify.dto.LoginDTO;
import com.example.soundify.dto.SessionDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("users/signin")
    Call<SessionDTO> signup(@Body LoginDTO loginDTO);
}
