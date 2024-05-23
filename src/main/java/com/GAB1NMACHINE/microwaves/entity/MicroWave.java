package com.GAB1NMACHINE.microwaves.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
public class MicroWave {
    @Id
    private Long id;
    private LocalTime nextAvailable;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "microWave")
    private List<Reservation> reservations = new ArrayList<>();

    public MicroWave() {
    }
}
