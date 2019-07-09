package com.example.soundify.service;

import com.example.soundify.dto.LoginDTO;
import com.example.soundify.dto.SessionDTO;
import com.example.soundify.dto.SessionLoginDTO;
import com.example.soundify.dto.SignupDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("users/signin")
    Call<SessionLoginDTO> signup(@Body LoginDTO loginDTO);
}
