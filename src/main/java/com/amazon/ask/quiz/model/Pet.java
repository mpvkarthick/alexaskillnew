package com.amazon.ask.quiz.model;

public class Pet {

	String name;
	
	String[] sound =new String[5];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String[] getSound() {
		return sound;
	}

	public void setSound(String[] sound) {
		this.sound = sound;
	}

	public Pet(String name, String[] sound) {
		super();
		this.name = name;
		this.sound = sound;
	}
	
	public Pet() {}
}
