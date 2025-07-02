package com.uskhalifa.eventoapi.domain.event;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record EventRequestDTO(String title, String description, Date date, String city, String State, Boolean remote, String eventUrl, MultipartFile img) {
}
