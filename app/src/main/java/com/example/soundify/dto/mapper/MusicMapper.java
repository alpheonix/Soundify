package com.example.soundify.dto.mapper;

import com.example.soundify.dto.DataDTO;
import com.example.soundify.dto.MusicDTO;
import com.example.soundify.models.Music;

import java.util.ArrayList;
import java.util.List;

public class MusicMapper {

    public static List<Music> map(List<DataDTO> dataDTOList, MusicDTO musicDTO) {
        List<Music> eventList = new ArrayList<>();
        for (DataDTO dataDTO : dataDTOList) {
            eventList.add(map(dataDTO,musicDTO));
        }
        return eventList;
    }

    private static Music map(DataDTO dataDTO,MusicDTO musicDTO) {
        Music music = new Music();
        music.setDuration(dataDTO.getDuration());
        music.setPreview(dataDTO.getPreview());
        music.setRank(dataDTO.getRank());
        music.setTitle(dataDTO.getTitle());
        music.setMediumPic(musicDTO.getMediumPic());
        music.setBigPic(musicDTO.getBigPic());
        return music;
    }
}
