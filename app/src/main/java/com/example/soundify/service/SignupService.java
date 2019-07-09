package com.example.soundify.service;

import com.example.soundify.dto.SessionDTO;
import com.example.soundify.dto.SignupDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignupService {

    @POST("users/signup")
    Call<SessionDTO> signup(@Body SignupDTO signupDTO);
}
