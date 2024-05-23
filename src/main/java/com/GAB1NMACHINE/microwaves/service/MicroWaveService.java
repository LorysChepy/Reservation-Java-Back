package com.GAB1NMACHINE.microwaves.service;

import com.GAB1NMACHINE.microwaves.api.MicroWaveInputDTO;
import com.GAB1NMACHINE.microwaves.api.MicroWaveOutputDTO;
import com.GAB1NMACHINE.microwaves.entity.*;
import com.GAB1NMACHINE.microwaves.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MicroWaveService {

    private final MicroWaveRepository microWaveRepository;


    public Optional<MicroWave> getMicroWaveById(Long id) {
        return microWaveRepository.findById(id);  // Implement this method in your repository
    }

    public MicroWave saveMicroWave(MicroWave microWave) {
        return microWaveRepository.save(microWave);  // Implement this method in your repository
    }

    public void deleteMicroWave(Long id) {
        microWaveRepository.deleteById(id);  // Implement this method in your repository
    }
    public int cookingTime(int minutes, int seconds){
        return minutes * 60 + seconds;
    }

    public List<MicroWaveOutputDTO> showMicroWaves(MicroWaveInputDTO microWaveInputDTO) {
        List<MicroWaveOutputDTO> result = new ArrayList<>();
        for(MicroWave microWave : this.microWaveRepository.findAll()) {
            MicroWaveOutputDTO reservation = new MicroWaveOutputDTO();
            reservation.setMicroWaveId(microWave.getId());
            reservation.setStartDate(microWave.getNextAvailable());
            reservation.setEndDate(microWave.getNextAvailable().plusSeconds(microWaveInputDTO.getSeconds()).plusMinutes(microWaveInputDTO.getMinutes()));
            result.add(reservation);
        }
        return result;
    }
}
