package com.ai.example.controller;

import com.ai.example.controller.data.StoryInput;
import com.ai.example.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stories")
public class StoryController {
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping("")
    public String getStories(@RequestBody StoryInput storyInput){
        return storyService.getStory(storyInput);
    }

}
