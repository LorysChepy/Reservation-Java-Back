package com.GAB1NMACHINE.microwaves.repository;

import com.GAB1NMACHINE.microwaves.entity.MicroWave;
import com.GAB1NMACHINE.microwaves.service.MicroWaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@RequiredArgsConstructor
@Component
public class MicroWavesInitialization implements ApplicationRunner {
    private final MicroWaveRepository microWaveRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        MicroWave micro1 = new MicroWave();
        micro1.setId(1L);
        micro1.setNextAvailable(LocalTime.of(12, 0));
        this.microWaveRepository.save(micro1);

        MicroWave micro2 = new MicroWave();
        micro2.setId(2L);
        micro2.setNextAvailable(LocalTime.of(12, 0));
        this.microWaveRepository.save(micro2);

        MicroWave micro3 = new MicroWave();
        micro3.setId(3L);
        micro3.setNextAvailable(LocalTime.of(12, 0));
        this.microWaveRepository.save(micro3);
    }
}
