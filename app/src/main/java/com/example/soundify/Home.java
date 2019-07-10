package com.example.soundify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.soundify.adapter.MusicAdapter;
import com.example.soundify.models.Music;
import com.example.soundify.service.NetworkProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home extends AppCompatActivity {

    private MusicAdapter musicAdapter;
    @BindView(R.id.home_activity_rcv)
    RecyclerView musicRcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initRcv();
        loadData();

    }


    private void initRcv(){
        Log.d("init","init");
        musicRcv.setLayoutManager( new LinearLayoutManager(this));
        musicAdapter = new MusicAdapter();
        musicRcv.setAdapter(musicAdapter);
        musicAdapter.setItemClickListener(new MusicAdapter.ItemClickListener() {
            @Override
            public void onclick(Music music) {
                Intent intent = new Intent(Home.this, Detail.class);
                intent.putExtra("musicTitle",music.getTitle());
                intent.putExtra("musicDuration",music.getDuration());
                intent.putExtra("musicRank",music.getRank());
                intent.putExtra("musicPreview",music.getPreview());
                intent.putExtra("musicImage",music.getBigPic());
                startActivity(intent);
            }


        });
    }

    private void loadData() {
        NetworkProvider.getInstance().getMusics(new NetworkProvider.Listener<List<Music>>() {
            @Override
            public void onSuccess(List<Music> data) {
                musicAdapter.setMusicList(data);
            }

            @Override
            public void onError(Throwable t) {

            }
        });
    }
    }

