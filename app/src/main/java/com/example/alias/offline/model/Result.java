package com.example.alias.offline.model;

public class Result {
    private static final int SKIPPED = 0;
    private static final int GUESSED = 1;
    private static final int GUESSED_BY_OTHER_TEAM = 2;

    protected int result;
    String word;

    public Result(String word, int res){
        this.word = word;
        this.result = res;
    }

    public int getResult() {
        return result;
    }
    //todo написать механизм подсчета слов
}
