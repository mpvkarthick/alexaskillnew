package com.amazon.ask.quiz.handlers;

import static com.amazon.ask.quiz.util.QuestionUtils.getQuestionText;
import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Pet;

public class RepeatIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("AMAZON.RepeatIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
         
    	
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        int counter = (int) sessionAttributes.get(Attributes.COUNTER_KEY);
        Pet pet = (Pet)sessionAttributes.get(Attributes.QUIZ_ITEM_KEY);
        String question = getQuestionText(counter, pet);
        return input.getResponseBuilder()
                .withSpeech(question)
                .withReprompt(question)
                .withShouldEndSession(false)
                .build();
    }

}
