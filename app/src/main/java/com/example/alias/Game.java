package com.example.alias;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
   private ArrayList<Team> teams = new ArrayList<Team>();
   private final String[] default_names = new String[]{"Хмарачосы", "Пацукі", "Парсюкі", "Валошкі"};
   private int time; //seconds
   private int maxWordsNumber;    //max number of words to win

   public Game(){
      addTeam();
      addTeam();
      setTime(60);
      setMaxWordsNumber(60);
   }

   public void addTeam(){   //default name
      if(teams.size()<=5) {
         Team team = new Team(default_names[(int) (Math.random() * default_names.length)]);
         teams.add(team);
      }
   }

   public void deleteTeam(){
      if(teams.size()>2) {
         teams.remove(teams.size() - 1);
      }
   }

   public String[] getTeamsNames(){
      String[] teamNames = new String[teams.size()];
      for(int i = 0; i < teams.size(); i++) {
         teamNames[i] = this.teams.get(i).getTeamName();
      }
      System.out.println(Arrays.toString(teamNames));
      return teamNames;
   }

   public void setTime(int time) {
      this.time = time;
   }

   public int getTime() {
      return time;
   }

   public void setMaxWordsNumber(int maxWordsNumber) {
      this.maxWordsNumber = maxWordsNumber;
   }

   public int getMaxWordsNumber() {
      return maxWordsNumber;
   }


//   public String[] getTeamsNames(){
//      String[] names = new String[teams.size()];
//      for(int i = 0; i < teams.size(); i++) {
//         names[i] = (teams.get(i)).toString();  //какая-то херня, надо исправить!!!
//      }
//      return names;
//   }
}
