package com.example.soundify.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.soundify.R;
import com.example.soundify.models.Music;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

    private List<Music> musicList;
    private ItemClickListener itemClickListener;

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
        notifyDataSetChanged();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_music, viewGroup, false);
        return new MusicViewHolder(view);
    }

    @Override public void onBindViewHolder(@NonNull MusicViewHolder musicViewHolder, int i) {

        Music music = musicList.get(i);
        Log.d("bind",music.getTitle());
        musicViewHolder.titleTv.setText(music.getTitle());
        musicViewHolder.rankTv.setText(music.getRank());
        musicViewHolder.durationRcv.setText(music.getDuration()+"secondes");

        Glide.with(musicViewHolder.itemView).load(music.getMediumPic()).into(musicViewHolder.pictureImv);

        if (itemClickListener!= null){
            musicViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onclick(music);
                }
            });
        }
    }

    @Override public int getItemCount() {
        return musicList != null ? musicList.size() : 0;
    }

    class MusicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcv_imageView)
        ImageView pictureImv;
        @BindView(R.id.rcv_title)
        TextView titleTv;
        @BindView(R.id.rcv_duration) TextView durationRcv;
        @BindView(R.id.rcv_rank) TextView rankTv;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
    public interface ItemClickListener{
        void onclick(Music music);
    }
}
