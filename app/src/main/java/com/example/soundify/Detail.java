package com.example.soundify;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Detail extends AppCompatActivity {


    @BindView(R.id.detail_activity_duration)
    TextView durationTv;
    @BindView(R.id.detail_activity_title)
    TextView titleTv;
    @BindView(R.id.detail_activity_rank)
    TextView rankTv;
    @BindView(R.id.detail_activity_play_button)
    Button playBtn;
    @BindView(R.id.detail_activity_imageView)
    ImageView imageView;
    MediaPlayer mediaPlayer = new MediaPlayer();
    boolean condition = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        String title = extras.getString("");
        String duration = extras.getString("musicDuration");
        String preview = extras.getString("musicPreview");
        String image = extras.getString("musicImage");
        String rank = extras.getString("musicRank");
        Uri myUri = Uri.parse(preview);

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Glide.with(Detail.this).load(image).into(imageView);
        durationTv.setText("Durée: "+duration+" secondes");
        titleTv.setText(title);
        rankTv.setText("Musique au rang : "+rank);

        Button play = findViewById(R.id.detail_activity_play_button);
        play.setOnClickListener(v -> {


            if(condition){

                    condition = false;
                    mediaPlayer.start();
            }else{
                mediaPlayer.pause();
                condition = true;
            }





        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaPlayer.stop();
    }
}



