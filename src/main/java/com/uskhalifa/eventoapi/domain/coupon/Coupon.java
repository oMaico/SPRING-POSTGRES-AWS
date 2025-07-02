package com.uskhalifa.eventoapi.domain.coupon;

import com.uskhalifa.eventoapi.domain.event.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "event_coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue
    private UUID id;

    private String code;
    private Integer discount;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


}
