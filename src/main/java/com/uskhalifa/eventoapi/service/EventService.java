package com.uskhalifa.eventoapi.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.internal.BucketNameUtils;
import com.uskhalifa.eventoapi.domain.event.Event;
import com.uskhalifa.eventoapi.domain.event.EventRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class EventService {

    @Value("${aws.bucket}")
    private String bucketName;
    @Autowired
    private AmazonS3 s3Client;
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

        String imgName = UUID.randomUUID()+""+file.getOriginalFilename();

        try {
            File imgFile = this.convertMultipartToFile(file);
            s3Client.putObject(bucketName, imgName, imgFile);
            imgFile.delete();
            return s3Client.getUrl(bucketName, imgName).toString();
        } catch (Exception e) {
            System.out.println("Error while uploading file");
            return null;
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {

        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;

    }

}
