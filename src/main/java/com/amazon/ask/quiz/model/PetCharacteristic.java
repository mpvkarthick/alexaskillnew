package com.amazon.ask.quiz.model;

public enum PetCharacteristic {

	NAME("name"),
    Sound("sound");

    private String value;

    public String getValue() {
        return value;
    }
    
    private PetCharacteristic(String value) {
		this.value = value;
	}
    
}
