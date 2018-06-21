
abstract class Player{
  String name; //name of player
  double xValue; //xValue of player
  double projectedPoints; //projected points of player
  League lg;

  Player(String name, League lg) {
    this.name = name;
    this.lg = lg;
  }
}

class QB extends Player{
  double passYds;
  int passTDs;
  double rushYds;
  int rushTDs;
  int interceptions;
  int fumbles;
  int twoPtCon;

  QB(String name, League lg, double passYds, int passTDs, double rushYds, int rushTDs, int interceptions, 
      int fumbles, int twoPtCon) {
    super(name, lg);
    this.passYds = passYds;
    this.passTDs = passTDs;
    this.rushYds = rushYds;
    this.rushTDs = rushTDs;
    this.interceptions = interceptions;
    this.fumbles = fumbles;
    this.twoPtCon = twoPtCon;
    this.projectPoints(lg);
  }

  //projects total points for the quarterback given league's settings
  void projectPoints(League lg) {
    this.projectedPoints = this.passYds * lg.passPtsPerYd + this.passTDs * lg.passTD
        + this.rushYds * lg.rushPtsPerYd + this.rushTDs * lg.rushTD + this.twoPtCon * lg.twoPtCon
        - this.interceptions * lg.passInt - this.fumbles * lg.fumble;
  }


}
class RB extends Player{

}
class WR extends Player{

}
class TE extends Player{

}
class K extends Player{

}
class DEF extends Player{

}
