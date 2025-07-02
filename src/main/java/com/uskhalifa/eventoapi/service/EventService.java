package com.uskhalifa.eventoapi.service;

import com.uskhalifa.eventoapi.domain.event.Event;
import com.uskhalifa.eventoapi.domain.event.EventRequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class EventService {

    public Event createEvent(EventRequestDTO data){
        String imgUrl= null;

        if (data.img() != null){
             imgUrl = this.uploadImg(data.img());
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setDate(new Date(data.date()));
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setRemote(data.remote());
        newEvent.setImgUrl(imgUrl);
        return newEvent;
    }

    private String uploadImg(MultipartFile file) {

        return "";

    }

}
