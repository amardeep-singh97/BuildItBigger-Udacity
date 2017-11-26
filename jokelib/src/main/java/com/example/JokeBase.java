package com.example;

/**
 * Created by Amardeep on 10/19/2017.
 */

public class JokeBase {
    private String jokes;
    public JokeBase(){
        jokes = "Teacher: Which one is closer, Sun or Africa?\n" +
                "Johnny: Sun\n" +
                "Teacher: Why?\n" +
                "Johnny: We can see the sun all the time, but cannot see Africa.";
    }
    public String getjoke(){
        return jokes;
    }
}
