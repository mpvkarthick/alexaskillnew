package com.amazon.ask.quiz.handlers;

import static com.amazon.ask.request.Predicates.intentName;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Constants;
import com.amazon.ask.quiz.util.QuestionUtils;

public class QuizAndStartOverIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("PetSoundsIntent"))
                || input.matches(intentName("AMAZON.StartOverIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
        
        String greeting = null;
		greeting = Constants.START_QUIZ_MESSAGE;
        sessionAttributes.put(Attributes.STATE_KEY, Attributes.QUIZ_STATE);
        sessionAttributes.put(Attributes.RESPONSE_KEY, "");
        sessionAttributes.put(Attributes.COUNTER_KEY, 0);
        sessionAttributes.put(Attributes.QUIZ_SCORE_KEY, 0);
        sessionAttributes.put(Attributes.GREETING_STR, greeting);
        return QuestionUtils.generateQuestion(input);
    }

}
