package com.amazon.ask.quiz.util;

import static com.amazon.ask.quiz.model.Constants.PETS;
import static com.amazon.ask.quiz.model.Constants.START_QUIZ_MESSAGE;
import static com.amazon.ask.quiz.model.Constants.START_QUIZ_MESSAGEWNAME;
import static com.amazon.ask.quiz.model.Constants.COUNTERMAP;
import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Pet;
import com.amazonaws.util.StringUtils;

public class QuestionUtils {


    public static Optional<Response> generateQuestion(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();

        int counter = (int)sessionAttributes.get(Attributes.COUNTER_KEY);
        
        IntentRequest intentRequest = (IntentRequest) input.getRequestEnvelope().getRequest();
        String babyName = getBabyName(intentRequest.getIntent().getSlots());
        	String greeting = null;
        if (counter == 0) {
        	if (null != babyName) {
        		greeting = StringUtils.replace(START_QUIZ_MESSAGEWNAME, "{babyname}", babyName);
        	} else {
        		greeting = START_QUIZ_MESSAGE;
        	}
        	    
            sessionAttributes.put(Attributes.RESPONSE_KEY,greeting + " ");
        }

        counter++;
        Pet pet = PETS.get(counter-1);

        sessionAttributes.put(Attributes.QUIZ_ITEM_KEY, pet);
        sessionAttributes.put(Attributes.QUIZ_PROPERTY_KEY, pet.getSound());
        sessionAttributes.put(Attributes.COUNTER_KEY, counter);

        String question = getQuestionText(counter, pet);
        String speech = sessionAttributes.get(Attributes.RESPONSE_KEY) + question;

        return input.getResponseBuilder()
                .withSpeech(speech)
                .withReprompt(question)
                .withShouldEndSession(false)
                .build();
    }

//    private static Pet getRandomPet(int counter) {
//        return PETS.get(counter);
//    } 
    
    public static String getQuestionText(int counter, Pet pet) {
        return "Here is your " + COUNTERMAP.get(counter) + " question.  What does the " + pet.getName() + " say ?";
    }

   
    
    private static String getBabyName(Map<String, Slot> slots) {
        for (Slot slot : slots.values()) {
        	System.out.println(slot.getName());
        	System.out.println(slot.getValue());
            if (slot.getValue() != null) {
                return slot.getValue();
            }
        }
        return null;
    }

}
