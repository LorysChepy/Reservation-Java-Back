package com.GAB1NMACHINE.microwaves.service;

import com.GAB1NMACHINE.microwaves.entity.*;
import com.GAB1NMACHINE.microwaves.repository.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MicroWaveService {

    private final List<MicroWave> availableMicroWaves;
    private final MicroWaveRepository microWaveRepository;

    @Autowired
    //private MicroWaveRepository microWaveRepository;

    // Constructor
    public MicroWaveService(List<MicroWave> availableMicroWaves) {
        this.availableMicroWaves = availableMicroWaves;
    }

    public Optional<MicroWave> getMicroWaveById(Long id) {
        return microWaveRepository.findById(id);  // Implement this method in your repository
    }

    public MicroWave saveMicroWave(MicroWave microWave) {
        return microWaveRepository.save(microWave);  // Implement this method in your repository
    }

    public void deleteMicroWave(Long id) {
        microWaveRepository.deleteById(id);  // Implement this method in your repository
    }
    public String reserveMicroWave(User user, int cookingTime, LocalDateTime desiredStartTime) {
        for (MicroWave microWave : availableMicroWaves) {
            if (!microWave.isReservedAt(desiredStartTime, cookingTime)) {
                // Réserver le micro-ondes pour l'utilisateur
                microWave.reserve(user, desiredStartTime, cookingTime);

                // Calculer l'heure de fin de la réservation
                LocalDateTime endTime = desiredStartTime.plusMinutes(cookingTime);

                // Retourner les informations de réservation
                return user.getName() + " a réservé le micro-ondes de " + desiredStartTime.toString() + " à " + endTime.toString();
            }
        }

        // Si aucun micro-ondes n'est disponible à l'heure souhaitée, proposer la prochaine heure disponible
        for (MicroWave microWave : availableMicroWaves) {
            LocalDateTime nextAvailableStartTime = microWave.getNextAvailableStartTime();
            if (nextAvailableStartTime != null) {
                if (!microWave.isReservedAt(nextAvailableStartTime, cookingTime)) {
                    microWave.reserve(user, nextAvailableStartTime, cookingTime);
                    LocalDateTime endTime = nextAvailableStartTime.plusMinutes(cookingTime);
                    return "L'heure souhaitée n'est pas disponible. " + user.getName() + " a réservé le micro-ondes de " + nextAvailableStartTime.toString() + " à " + endTime.toString();
                }
            }
        }

        return "Aucun micro-ondes disponible pour l'heure demandée.";
    }
}
