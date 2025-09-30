package com.ai.example.controller;

import com.ai.example.controller.data.MappingData;
import com.ai.example.service.MappingDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("structure-output")
@RequiredArgsConstructor
public class StructureOutController {
    private final MappingDataService mappingDataService;

    @PostMapping("/auto-mapping")
    public String getAutoMapping(@RequestBody MappingData mappingData) throws JsonProcessingException {
        return mappingDataService.getMappingData(mappingData);
    }
}
