package com.ai.example.controller;

import com.ai.example.controller.data.StoryInput;
import com.ai.example.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/stories")
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;

    @PostMapping("")
    public String getStories(@RequestBody StoryInput storyInput){
        return storyService.getStory(storyInput);
    }



}
