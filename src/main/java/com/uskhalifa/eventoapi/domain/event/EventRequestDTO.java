package com.uskhalifa.eventoapi.domain.event;

import org.springframework.web.multipart.MultipartFile;


public record EventRequestDTO(String title, String description, Long date, String city, String State, Boolean remote, String eventUrl, MultipartFile img) {
}
