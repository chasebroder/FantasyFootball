import java.util.ArrayList;

interface Player{
  
}
class League{
  int numTeams;
  int numPicks;
  ArrayList<Player> undrafted;
  ArrayList<Player> drafted;
  
}
class QB implements Player{
  String name;
  double xValue;
  double projectedPoints;
}
class RB implements Player{
  String name;
  double xValue;
  double projectedPoints;
}
class WR implements Player{
  String name;
  double xValue;
  double projectedPoints;
}
class TE implements Player{
  String name;
  double xValue;
  double projectedPoints;
}
class K implements Player{
  String name;
  double xValue;
  double projectedPoints;
}
class DEF implements Player{
  String name;
  double xValue;
  double projectedPoints;
}
class Team{
  ArrayList<Player> myTeam;
}