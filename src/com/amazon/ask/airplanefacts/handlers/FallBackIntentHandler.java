package com.amazon.ask.airplanefacts.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class FallBackIntentHandler implements RequestHandler{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.FallbackIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Sorry, I don't know that. Would you like a world cup fact?";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("World Cup Trivia", speechText)
                .withReprompt(speechText)
                .build();
    }

}
