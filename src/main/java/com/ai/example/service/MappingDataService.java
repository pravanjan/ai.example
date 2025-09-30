package com.ai.example.service;

import com.ai.example.controller.data.MappingData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class MappingDataService {
    private final OllamaChatModel ollamaChatModel;
    private final ObjectMapper mapper;



    public String getMappingData(MappingData mappingData) throws JsonProcessingException {

        String message = "Match input field names to output field names and return as JSON.\n" +
                "\n" +
                "Matching Rules:\n" +
                "- Exact match first: firstname → firstname " +
                "- Semantic match if the value is available  in output field" +
                "- Handle variations: underscore/camelCase, abbreviations, synonyms\n" +

                "\n" +
                "Output: Strictly follow input fields   as keys, matched output fields as values if not present in output filed  \n" +
                "do not include that in result"+
                 "input fields list "+mapper.writeValueAsString(mappingData.inputDataList())+" output field "+
                      mapper.writeValueAsString(mappingData.outPutDataList())  ;

        System.out.println(message);

        Prompt prompt = new Prompt(message, OllamaOptions.builder().format(new HashMap<>()).build());
        return   ollamaChatModel.call(prompt).getResult().getOutput().getText();

    }

}
