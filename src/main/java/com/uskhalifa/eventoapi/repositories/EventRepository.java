package com.uskhalifa.eventoapi.repositories;

import com.uskhalifa.eventoapi.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepository extends JpaRepository <Event, UUID> {
}
