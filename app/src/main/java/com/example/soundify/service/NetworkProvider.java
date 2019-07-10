package com.example.soundify.service;

import android.provider.ContactsContract;
import android.util.Log;

import com.example.soundify.dto.DataDTO;
import com.example.soundify.dto.MusicDTO;
import com.example.soundify.dto.TracksDTO;
import com.example.soundify.dto.mapper.MusicMapper;
import com.example.soundify.models.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkProvider {

    DeezerService deezerService;
    private static NetworkProvider instance;
    private static Retrofit retrofit = null;

    public static NetworkProvider getInstance() {
        if (instance == null) {
            instance = new NetworkProvider();
        }
        return instance;
    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://fast-castle-72868.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    private  NetworkProvider() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.deezer.com/playlist/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        deezerService = retrofit.create(DeezerService.class);
    }

    public void getMusics(Listener<List<Music>> listener){
        deezerService.getPlaylist().enqueue(new Callback<MusicDTO>() {
            @Override
            public String toString() {
                return "$classname{}";
            }

            @Override public void onResponse(Call<MusicDTO> call, Response<MusicDTO> response) {

                MusicDTO musicDTOList = response.body();
                TracksDTO tracksDTO = musicDTOList.getTracks();
                List<DataDTO> data = tracksDTO.getDataDTOArrayList();
                List<Music> musiclist = MusicMapper.map(data,musicDTOList);
                Log.d("suc",musiclist.get(0).toString());
                listener.onSuccess(musiclist);
            }

            @Override public void onFailure(Call<MusicDTO> call, Throwable t) {
                listener.onError(t);
                Log.d("toz",t.toString());
            }
        });
    }
    public interface Listener<T> {
        void onSuccess(T data);

        void onError(Throwable t);
    }


}
