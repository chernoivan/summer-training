package com.chernoivan;

public class Model {
    private String firstWord;
    private String secondWord;

    public String getSentence() {
        return firstWord + " " + secondWord + "!";
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public void setSecondWord(String secondWord) {
        this.secondWord = secondWord;
    }
}
