
abstract class Player{
  String name; //name of player
  double xValue; //xValue of player: will have to figure out when to calculate this
  double projectedPoints; //projected points of player
  League lg; //league settings

  //initializes player name and fantasy league
  Player(String name, League lg) {
    this.name = name;
    this.lg = lg;
  }

  //projects points for player given estimated statistics
  abstract void projectPoints(League lg);
}

//RBs, WRs, TEs will extend this
abstract class Flex extends Player {
  int rushYds;
  int rushTDs;
  int receptions;
  int receivingYds;
  int receivingTDs;
  int fumbles;
  int twoPtCons;

  Flex(String name, League lg, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    super(name, lg);
    this.rushYds = rushYds;
    this.rushTDs = rushTDs;
    this.receptions = receptions;
    this.receivingYds = receivingYds;
    this.receivingTDs = receivingTDs;
    this.fumbles = fumbles;
    this.twoPtCons = twoPtCons;
  }

  //projects total points for flex given league's settings
  void projectPoints(League lg) {
    this.projectedPoints = this.rushYds * lg.rushPtsPerYd + this.rushTDs * lg.rushTD
        + this.receptions * lg.pointsPerReception + this.receivingYds * lg.recPtsPerYD
        + this.receivingTDs * lg.recTD + this.fumbles * lg.fumble + this.twoPtCons * lg.twoPtCon;
  }  
}

//Quarterback
class QB extends Player{
  int passYds;
  int passTDs;
  int rushYds;
  int rushTDs;
  int interceptions;
  int fumbles;
  int twoPtCons;

  QB(String name, League lg, int passYds, int passTDs, int rushYds, int rushTDs, int interceptions, 
      int fumbles, int twoPtCons) {
    super(name, lg);
    this.passYds = passYds;
    this.passTDs = passTDs;
    this.rushYds = rushYds;
    this.rushTDs = rushTDs;
    this.interceptions = interceptions;
    this.fumbles = fumbles;
    this.twoPtCons = twoPtCons;
    this.projectPoints(lg);
  }

  //projects total points for the quarterback given league's settings
  void projectPoints(League lg) {
    this.projectedPoints = this.passYds * lg.passPtsPerYd + this.passTDs * lg.passTD
        + this.rushYds * lg.rushPtsPerYd + this.rushTDs * lg.rushTD + this.twoPtCons * lg.twoPtCon
        + this.interceptions * lg.passInt + this.fumbles * lg.fumble;
    //interceptions and fumbles should be negative in League class, so added to avoid double negative
  }

}

//Running Back
class RB extends Flex {
  RB(String name, League lg, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    super(name, lg, rushYds, rushTDs, receptions, receivingYds, receivingTDs, fumbles, twoPtCons);
  }
}

//Wide Receiver
class WR extends Flex {
  WR(String name, League lg, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    super(name, lg, rushYds, rushTDs, receptions, receivingYds, receivingTDs, fumbles, twoPtCons);
  }
}

//Tight End
class TE extends Flex{
  TE(String name, League lg, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    super(name, lg, rushYds, rushTDs, receptions, receivingYds, receivingTDs, fumbles, twoPtCons);
  }
}

class K extends Player{
  int PATsMade; 
  int PATsMissed;
  int FG039Made; //field goals made between 0-39 yds
  int FG039Missed; //field goals missed between 0-39 yds
  int FG4049Made; //field goals made between 40-49 yds
  int FG4049Missed; //field goals missed between 40-49 yds
  int FG50Made; //field goals made 50+ yds
  int FG50Missed;  //fields goals missed 50+ yards

  K(String name, League lg, int PATsMade, int PATsMissed, int FG039Made, int FG039Missed,
      int FG4049Made, int FG4049Missed, int FG50Made, int FG50Missed) {
    super(name, lg);
    this.PATsMade = PATsMade;
    this.PATsMissed = PATsMissed;
    this.FG039Made = FG039Made;
    this.FG039Missed = FG039Missed;
    this.FG4049Made = FG4049Made;
    this.FG4049Missed = FG4049Missed;
    this.FG50Made = FG50Made;
    this.FG50Missed = FG50Missed;
  }

  //projects total points for kicker given league's settings
  void projectPoints(League lg) {
    this.projectedPoints = this.PATsMade * lg.PATMade + this.PATsMissed * lg.PATMissed
        + this.FG039Made * lg.FG039Made + this.FG039Missed * lg.FG039Missed
        + this.FG4049Made * lg.FG4049Made + this.FG4049Missed * lg.FG4049Missed
        + this.FG50Made * lg.FG50Made + this.FG50Missed * lg.FG50Missed;
  }
}

class DEF extends Player{
  int sacks; //amount of sacks
  int interceptions; //amount of interceptions
  int fumbles; //amount of funble recoveries
  int safeties; //amount of safeties
  int defTDs; //amount of defensive touchdowns
  int retTDs; //amount of return touchdowns
  int ptsAllowed0; //amount of games allowing 0 points
  int ptsAllowed16; //amount of games allowing 1-6 points
  int ptsAllowed713; //amount of games allowing 7-13 points
  int ptsAllowed1420; //amount of games allowing 14-20 points
  int ptsAllowed2127; //amount of games allowing 21-27 points
  int ptsAllowed2834; //amount of games allowing 28-34 points
  int ptsAllowed35; //amount of games allowing 35+ points

  DEF(String name, League lg, int sacks, int interceptions, int fumbles, int safeties, int defTDs,
      int retTDs, int ptsAllowed0, int ptsAllowed16, int ptsAllowed713, int ptsAllowed1420, 
      int ptsAllowed2127, int ptsAllowed2834, int ptsAllowed35) {
    super(name, lg);
    this.sacks = sacks;
    this.interceptions = interceptions;
    this.fumbles = fumbles;
    this.safeties = safeties;
    this.defTDs = defTDs;
    this.retTDs = retTDs;
    this.ptsAllowed0 = ptsAllowed0;
    this.ptsAllowed16 = ptsAllowed16;
    this.ptsAllowed713 = ptsAllowed713;
    this.ptsAllowed1420 = ptsAllowed1420;
    this.ptsAllowed2127 = ptsAllowed2127;
    this.ptsAllowed2834 = ptsAllowed2834;
    this.ptsAllowed35 = ptsAllowed35;
  }

  //projects total points for defense given league's settings
  void projectPoints(League lg) {
    this.projectedPoints = this.sacks * lg.sack + this.interceptions * lg.defInt
        + this.fumbles * lg.defFumble + this.safeties * lg.safety + this.defTDs * lg.defTD
        + this.retTDs * lg.retTD + this.ptsAllowed0 * lg.ptAllowed0 + this.ptsAllowed16 * lg.ptAllowed16
        + this.ptsAllowed713 * lg.ptAllowed713 + this.ptsAllowed1420 * lg.ptAllowed1420
        + this.ptsAllowed2127 * lg.ptAllowed2127 + this.ptsAllowed2834 * lg.ptAllowed2834
        + this.ptsAllowed35 * this.ptsAllowed35;
  }
}
