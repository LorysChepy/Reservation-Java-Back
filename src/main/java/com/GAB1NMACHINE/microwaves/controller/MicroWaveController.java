package com.GAB1NMACHINE.microwaves.controller;

import com.GAB1NMACHINE.microwaves.entity.MicroWave;
import com.GAB1NMACHINE.microwaves.entity.User;
import com.GAB1NMACHINE.microwaves.service.MicroWaveService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/microwaves")
public class MicroWaveController {

    private final MicroWaveService microWaveService;

    public MicroWaveController(MicroWaveService microWaveService) {
        this.microWaveService = microWaveService;
    }

    // GET Method to retrieve all available microwaves
    @GetMapping
    public ResponseEntity<?> getAvailableMicroWaves() {
        return ResponseEntity.ok(microWaveService.getAvailableMicroWaves());
    }

    // POST Method to reserve a microwave
    @PostMapping("/reserve")
    public ResponseEntity<String> reserveMicroWave(@RequestBody ReservationRequest request) {
        User user = new User(); // You should set user attributes based on your user management logic
        user.setName(request.getUserName());
        String response = microWaveService.reserveMicroWave(user, request.getCookingTime(), request.getDesiredStartTime());
        return ResponseEntity.ok(response);
    }

    // PUT Method to modify a reservation (simplified version)
    @PutMapping("/{id}")
    public ResponseEntity<MicroWave> updateMicroWave(@PathVariable Long id, @RequestBody MicroWave microWaveDetails) {
        Optional<MicroWave> optionalMicroWave = microWaveService.getMicroWaveById(id);
        if (optionalMicroWave.isPresent()) {
            MicroWave microWave = optionalMicroWave.get();
            //microWave.setDateStart(microWaveDetails.getDateStart());
            MicroWave updatedMicroWave = microWaveService.saveMicroWave(microWave);
            return ResponseEntity.ok(updatedMicroWave);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMicroWave(@PathVariable Long id) {
        Optional<MicroWave> optionalMicroWave = microWaveService.getMicroWaveById(id);
        if (optionalMicroWave.isPresent()) {
            microWaveService.deleteMicroWave(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Helper class for reservation requests
    @Setter
    @Getter
    static class ReservationRequest {
        // Getters and setters
        private String userName;
        private LocalDateTime desiredStartTime;
        private int cookingTime;

    }
}
