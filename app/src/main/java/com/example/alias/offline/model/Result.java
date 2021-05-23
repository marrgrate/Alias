package com.example.alias.offline.model;

import java.io.Serializable;

public class Result implements Serializable {
    private static final int SKIPPED = 0;
    private static final int GUESSED = 1;
    private static final int GUESSED_BY_OTHER_TEAM = 2;

    protected int result;
    private int roundResult;
    private int guessed;
    private int skipped;

    public Result() {
        result = 0;
        roundResult = 0;
        guessed = 0;
        skipped = 0;
    }

    public int getResult() {
        return result;
    }

    public void addPoint(){
        roundResult++;
        guessed++;
    }

    public void subtractPoint(){
        if(roundResult>=1) {
            roundResult--;
            skipped++;
        }
    }

    public void recountResult(){
        result += roundResult;
    }

    public void resetRoundResult(){
        roundResult = 0;
        skipped = 0;
        guessed = 0;
    }

    public int getSkipped() {
        return skipped;
    }

    public int getGuessed() {
        return guessed;
    }
}
