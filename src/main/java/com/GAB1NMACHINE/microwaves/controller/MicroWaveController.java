package com.GAB1NMACHINE.microwaves.controller;

import com.GAB1NMACHINE.microwaves.api.MicroWaveInputDTO;
import com.GAB1NMACHINE.microwaves.api.MicroWaveOutputDTO;
import com.GAB1NMACHINE.microwaves.service.MicroWaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/microwaves")
public class MicroWaveController {

    private final MicroWaveService microWaveService;
    @PostMapping("/reserve")
    List<MicroWaveOutputDTO> newMicroWave(@RequestBody MicroWaveInputDTO newMicroWave){
        return microWaveService.showMicroWaves(newMicroWave);
    }


}
