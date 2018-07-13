package com.amazon.ask.quiz.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    
	public static String[] dogSounds = {"bow","bow bow"};
	public static String[] catSounds = {"meow","meum","meam"};
	public static String[] lambSounds = {"baa","baaa"};
	public static String[] cowSounds = {"maa","maaa"};
	public static String[] snakeSounds = {"hiss","hisss"};
    public static final List<Pet> PETS = Arrays.asList(new Pet("Dog",dogSounds),new Pet("Cat",catSounds), new Pet("Lamb",lambSounds), new Pet("Cow",cowSounds),new Pet("Snake",snakeSounds));

    public static boolean USE_CARDS_FLAG = true;

    public static String WELCOME_MESSAGE = "Hey there. Welcome to Pet Sounds Game. I will ask you the sound that an animal makes and you can reply with a sound. You can start by Saying Play quiz or PLay Quiz with BabyName";
    
    public static String START_QUIZ_MESSAGE = "OK.  Let us start with few pet sounds";
    
    public static String START_QUIZ_MESSAGEWNAME = "OK {babyname}.  Let us start with few pet sounds";

    // This is the message a user will hear when they try to cancel or stop the
    // skill, or when they finish a quiz.
    public static String EXIT_SKILL_MESSAGE = "Thank you for playing the Pet Sounds Game!  Let's play again soon!";

    // This is the message a user will hear when they ask Alexa for help in your
    // skill.
    public static String HELP_MESSAGE = "As of today, I can ask you sounds of dog, cat, cow, lamb and snake. I am still learning myself on other animal sounds.";

    public static List<String> CORRECT_RESPONSES = Arrays.asList("Booya", "All righty", "Bam", "Bazinga", "Bingo", "Boom", "Bravo", "Cha Ching", "Cheers", "Dynomite",
            "Hip hip hooray", "Hurrah", "Hurray", "Huzzah", "Oh dear.  Just kidding.  Hurray", "Kaboom", "Kaching", "Oh snap", "Phew",
            "Righto", "Way to go", "Well done", "Whee", "Woo hoo", "Yay", "Wowza", "Yowsa");

    public static List<String> INCORRECT_RESPONSES = Arrays.asList("Oh dear, I am afraid, that is not the right answer");
    
    public static Map<Integer, String> COUNTERMAP = new HashMap<Integer,String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{
        put(1,"First");
        put(2, "Second");
        put(3, "Third");
        put(4, "Fourth");
        put(5, "Last");
        
   }};

}
