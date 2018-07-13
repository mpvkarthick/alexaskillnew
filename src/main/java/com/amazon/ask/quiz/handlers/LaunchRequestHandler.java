package com.amazon.ask.quiz.handlers;

import static com.amazon.ask.request.Predicates.requestType;

import java.util.Map;
import java.util.Optional;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.quiz.model.Attributes;
import com.amazon.ask.quiz.model.Constants;

public class LaunchRequestHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(requestType(LaunchRequest.class));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		String greeting = null;
		greeting = Constants.WELCOME_MESSAGE;
		sessionAttributes.put(Attributes.STATE_KEY, Attributes.START_STATE);
		return input.getResponseBuilder().withSpeech(greeting).withReprompt(Constants.HELP_MESSAGE)
				.withShouldEndSession(false).build();
	}

}
