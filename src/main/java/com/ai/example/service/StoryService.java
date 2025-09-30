package com.ai.example.service;

import com.ai.example.controller.data.StoryInput;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@Service
public class StoryService {
    private final OllamaChatModel ollamaChatModel;

    public StoryService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public String getStory(StoryInput storyInput){

        String message = "Generate a story where given title"+storyInput.title()+" story description is "+storyInput.description();
        return   ollamaChatModel.call(message);

    }
}
