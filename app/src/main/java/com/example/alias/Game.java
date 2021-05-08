package com.example.alias;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
   private final ArrayList<Team> teams = new ArrayList<Team>();
   private final String[] default_names = new String[]{"Хмарачосы", "Пацукі", "Парсюкі", "Валошкі"};
   private int time; //seconds
   private int maxWordsNumber;    //max number of words to win

   public void addDefaultTeam(){   //default name
      if(teams.size()<=5) {
         Team team = new Team(default_names[(int) (Math.random() * default_names.length)]);
         teams.add(team);
      }
   }
   public void addTeam(String team_name){
      if(teams.size()<=5) {
         Team team = new Team(team_name);
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

   public int getTime() {
      return time;
   }

   public void setDefaultTime() {
      this.time = 60;
   }

   public void setTime(int time) {
      this.time = time;
   }


//   public String[] getTeamsNames(){
//      String[] names = new String[teams.size()];
//      for(int i = 0; i < teams.size(); i++) {
//         names[i] = (teams.get(i)).toString();  //какая-то херня, надо исправить!!!
//      }
//      return names;
//   }
}
