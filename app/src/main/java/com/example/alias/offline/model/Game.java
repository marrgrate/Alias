package com.example.alias.offline.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Game
        implements Serializable {
   private static final int DEFAULT_MAX_TIME = 120;
   private static final int DEFAULT_MAX_WORDS = 30;

   public ArrayList<Team> teams = new ArrayList<>();
   private Dictionary dictionarySelected;
   private int maxTime = 60; //seconds
   private int maxWordsNumber = 60;    //max number of words to win
   private Team teamPlaying = null;

   public Game() {
      if(teams.size() == 0) {
         teams.add(new Team());
         Team team = new Team();
         while(team.getName().equals(teams.get(0).getName())) {
               team.setRandomName();
            }
         teams.add(team);
         setTeamPlaying();
      }
      setMaxTime(DEFAULT_MAX_TIME);
      setMaxWordsNumber(DEFAULT_MAX_WORDS);
   }

   public void setDictionarySelected(Dictionary dictionarySelected) {
      this.dictionarySelected = dictionarySelected;
   }

   public Dictionary getDictionarySelected() {
      return dictionarySelected;
   }

   public ArrayList<Team> getTeams() {
      return teams;
   }

   public void setTeamPlaying(){
      if(teamPlaying == null) {
         teamPlaying = teams.get(0);
         return;
      }
      if(teams.indexOf(teamPlaying) < teams.size() - 1)
         teamPlaying.setTeam(teams.get(teams.indexOf(teamPlaying) + 1));
      else
         teamPlaying = teams.get(teams.size() - 1);
   }

   public Team getTeamPlaying() {
      return teamPlaying;
   }

   public void setMaxTime(int maxTime) {
      this.maxTime = maxTime;
   }

   public int getMaxTime() {
      return maxTime;
   }

   public void setMaxWordsNumber(int maxWordsNumber) {
      this.maxWordsNumber = maxWordsNumber;
   }

   public void setDictionarySelected(String name){
      //todo проинициализировать все поля выбранным словарем из джейсона
   }

   public int getMaxWordsNumber() {
      return maxWordsNumber;
   }
}
