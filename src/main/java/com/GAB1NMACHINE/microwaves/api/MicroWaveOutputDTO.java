package com.GAB1NMACHINE.microwaves.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class MicroWaveOutputDTO {
    private long microWaveId;
    private LocalTime startDate;
    private LocalTime endDate;
}
