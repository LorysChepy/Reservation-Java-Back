package com.GAB1NMACHINE.MicoWave.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Reservation {
    // Sets the user who reserved the microwave
    // Gets the user who reserved the microwave
    private User reservedBy;  // Field declaration moved up

    public static void main(String[] args) {
        // Your main method content
        // Typically used for launching a Java application
    }

    // Checks if the microwave is reserved
    public boolean isReserved() {
        return false;           // This could be modified to check a condition
    }

}
