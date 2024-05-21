package com.GAB1NMACHINE.microwaves.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public  class Reservation {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation() {
        // Constructeur par défaut requis par JPA
    }

    public Reservation(User user, LocalDateTime startTime, LocalDateTime endTime) {
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}


    