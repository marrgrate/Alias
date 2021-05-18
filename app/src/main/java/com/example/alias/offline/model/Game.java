package com.example.alias.offline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Game
        implements Serializable {
   public ArrayList<Team> teams = new ArrayList<>();
   private Dictionary dictionarySelected;
   private final String[] default_names = new String[]{"Хмарачосы", "Пацукі", "Парсюкі", "Валошкі", "Крумкачы"};
   private int maxTime = 60; //seconds
   private int maxWordsNumber = 60;    //max number of words to win
   public Team teamPlaying = new Team();

   public Game() {
      if(teams.size() == 0) {
         addTeam();
         addTeam();
         setTeamPlaying(teams.get(1));
      }
      setMaxTime(60);
      setMaxWordsNumber(60);
   }

   public void addTeam(){   //default name
      if(teams.size()<=8) {
         Random random = new Random();
         Team team = new Team(default_names[random.nextInt(default_names.length)]);
         teams.add(team);
      }
   }
   protected void setTeamPlaying(Team team){
      teamPlaying.setName(team);
   }

   public void deleteTeam(){
      if(teams.size()>2) {
         teams.remove(teams.size() - 1);
      }
   }

   public String[] getTeamsNames(){
      String[] teamNames = new String[teams.size()];
      for(int i = 0; i < teams.size(); i++) {
         teamNames[i] = this.teams.get(i).getName();
      }
      System.out.println(Arrays.toString(teamNames));
      return teamNames;
   }

   public void setMaxTime(int maxTime) {
      this.maxTime = maxTime;
   }

   public void setMaxWordsNumber(int maxWordsNumber) {
      this.maxWordsNumber = maxWordsNumber;
   }

   public void setDictionarySelected(String name){
      dictionarySelected.name = name;
      //todo проинициализировать все поля выбранным словарем из джейсона
   }

   public ArrayList<Team> getTeams() {
      return teams;
   }

   public String[] toStringList(ArrayList<Dictionary> list) {
      String[] stringList = new String[list.size()];
      for (int i = 0; i < teams.size(); i++) {
         stringList[i] = list.get(i).name;
      }
      return stringList;
   }

   public int getMaxWordsNumber() {
      return maxWordsNumber;
   }
}
