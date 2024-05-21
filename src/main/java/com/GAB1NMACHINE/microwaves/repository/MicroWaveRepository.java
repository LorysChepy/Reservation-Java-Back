package com.GAB1NMACHINE.microwaves.repository;

import com.GAB1NMACHINE.microwaves.entity.MicroWave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroWaveRepository extends JpaRepository<MicroWave, Long> {
    // Custom database queries can be added here
}
