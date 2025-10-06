package com.ai.example.service;

import com.ai.example.service.data.ActorsFilms;
import org.springframework.ai.chat.model.Generation;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MovieService {
    private final OllamaChatModel ollamaChatModel;

    public MovieService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public ActorsFilms  getActors(String actorName){

        BeanOutputConverter<ActorsFilms> beanOutputConverter = new BeanOutputConverter<>(ActorsFilms.class);
        String format = beanOutputConverter.getFormat();

        String template = """
                Generate the filmography of 5 movies for {actor}.
                {format}
                """;
        Generation generation = ollamaChatModel.call(PromptTemplate.builder().template(template).variables(
                Map.of("actor",actorName,"format", format)).build().create()).getResult();
        System.out.println(generation.getOutput().getText());

        ActorsFilms actorsFilms = beanOutputConverter.convert(generation.getOutput().getText());
        return actorsFilms;

    }
}
