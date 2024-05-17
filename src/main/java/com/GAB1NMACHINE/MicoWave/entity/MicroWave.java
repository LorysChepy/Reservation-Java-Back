package com.GAB1NMACHINE.MicoWave.entity;

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

    private boolean reserved;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id") // Spécifie la clé étrangère dans la table MicroWave
    private User reservedBy;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "micro_wave_id") // Spécifie la clé étrangère dans la table Reservation
    private List<Reservation> reservations = new ArrayList<>();

    // Constructeur par défaut
    public MicroWave() {
    }


    public boolean isReservedAt(LocalDateTime startTime, int cookingTime) {
        LocalDateTime endTime = startTime.plusMinutes(cookingTime);
        for (Reservation reservation : reservations) {
            if (startTime.isBefore(reservation.getEndTime().plusSeconds(30)) && endTime.isAfter(reservation.getStartTime().minusSeconds(30))) {
                return true;
            }
        }
        return false;
    }

    public void reserve(User user, LocalDateTime startTime, int cookingTime) {
        LocalDateTime endTime = startTime.plusMinutes(cookingTime);
        reservations.add(new Reservation(user, startTime, endTime));
    }

    public LocalDateTime getNextAvailableStartTime() {
        if (reservations.isEmpty()) {
            return LocalDateTime.now();
        } else {
            Reservation lastReservation = reservations.get(reservations.size() - 1);
            return lastReservation.getEndTime().plusSeconds(30);
        }
    }

    @Entity
    public static class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private LocalDateTime startTime;
        private LocalDateTime endTime;

        public Reservation() {
            // Constructeur par défaut requis par JPA
        }

        public Reservation(User user, LocalDateTime startTime, LocalDateTime endTime) {
            this.user = user;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public LocalDateTime getStartTime() {
            return startTime;
        }

        public LocalDateTime getEndTime() {
            return endTime;
        }
    }

    public boolean isReserved() {
        return reserved;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }
}
