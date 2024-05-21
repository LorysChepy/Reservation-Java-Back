package com.GAB1NMACHINE.microwaves.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
public class MicroWave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long micro_wave_id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;


    @ManyToOne
    @JoinColumn(name = "user_id") // Spécifie la clé étrangère dans la table MicroWave
    private User reservedBy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "micro_wave_id") // Spécifie la clé étrangère dans la table Reservation
    private List<Reservation> reservations = new ArrayList<>();


    // Constructeur par défaut
    public MicroWave() {
    }


    public LocalDateTime getNextAvailableStartTime() {
        return LocalDateTime.now();
    }
}
