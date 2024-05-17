package com.GAB1NMACHINE.MicoWave.controller;

import com.GAB1NMACHINE.MicoWave.entity.MicroWave;
import com.GAB1NMACHINE.MicoWave.Service.MicroWaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/microwaves")
public class MicroWaveController {

    @Autowired
    private MicroWaveService microWaveService;

    @GetMapping
    public List<MicroWave> getAllMicroWaves() {
        return microWaveService.getAllMicroWaves();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MicroWave> getMicroWaveById(@PathVariable Long id) {
        Optional<MicroWave> microWave = microWaveService.getMicroWaveById(id);
        return microWave.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MicroWave createMicroWave(@RequestBody MicroWave microWave) {
        return microWaveService.saveMicroWave(microWave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MicroWave> updateMicroWave(@PathVariable Long id, @RequestBody MicroWave microWaveDetails) {
        Optional<MicroWave> optionalMicroWave = microWaveService.getMicroWaveById(id);
        if (optionalMicroWave.isPresent()) {
            MicroWave microWave = optionalMicroWave.get();
            microWave.setName(microWaveDetails.getName());
            microWave.setAssociedUserId(microWaveDetails.getAssociedUserId());
            microWave.setDateStart(microWaveDetails.getDateStart());
            microWave.setDateEnd(microWaveDetails.getDateEnd());
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
}
