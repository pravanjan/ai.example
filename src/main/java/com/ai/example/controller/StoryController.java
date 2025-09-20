package com.ai.example.controller;

import com.ai.example.controller.data.StoryInput;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/stories")
public class StoryController {
    @PostMapping("")
    public String getStories(@RequestBody StoryInput storyInput){

        return null;
    }

}
