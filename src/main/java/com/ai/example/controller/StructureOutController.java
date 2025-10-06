package com.ai.example.controller;

import com.ai.example.controller.data.MappingData;
import com.ai.example.service.MappingDataService;
import com.ai.example.service.MovieService;
import com.ai.example.service.data.ActorsFilms;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/structure-output")
@RequiredArgsConstructor
public class StructureOutController {
    private final MappingDataService mappingDataService;
    private final MovieService movieService;

    @PostMapping("/auto-mapping")
    public String getAutoMapping(@RequestBody MappingData mappingData) throws JsonProcessingException {
        return mappingDataService.getMappingData(mappingData);
    }

    @GetMapping("/actors")
    public ActorsFilms getActors(@RequestParam  String actorName)  {
        return movieService.getActors(actorName);
    }
}
