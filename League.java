import java.util.ArrayList;

//will keep track of user inputs to gather league settings
class League {
  int yourPick; //what's your pick number? Change every round (numTeams - yourPick)
  int numTeams; //number of teams in league
  int pickNum; //current pick that the draft is on
  int qbNum; //how many QBs start
  int rbNum; //how many RBs start
  int wrNum; //how many WRs start
  int teNum; //how many TEs start
  int flexNum; //how many flex start
  int kickNum; //how many kickers start
  int defNum; //how many defenses start
  int benchNum; //how many players on your bench
  int rosterNum; //size of roster: qbNum + rbNum + wrNum + teNum + flexNum + kickNum + defNum + benchNum
  double passPtsPerYd;
  double passTD;
  double passInt;
  double rushPtsPerYd;
  double rushTD;
  double pointsPerReception;
  double recPtsPerYD;
  double recTD;
  double fumble;
  double twoPtCon;
  double PATMade;
  double PATMissed;
  double FG039Made;
  double FG039Missed;
  double FG4049Made;
  double FG4049Missed;
  double FG50Made;
  double FG50Missed;
  double sack;
  double defInt;
  double defFumble;
  double safety;
  double defTD;
  double retTD;
  double ptAllowed0;
  double ptAllowed16;
  double ptAllowed713;
  double ptAllowed1420;
  double ptAllowed2127;
  double ptAllowed2834;
  double ptAllowed35;

  League(int yourPick, int numTeams, int pickNum, int qbNum, int rbNum, int wrNum,
      int teNum, int flexNum, int kickNum, int defNum,
      int benchNum, double passPtsPerYd, double passTD, double passInt, double rushPtsPerYd, double rushTD,
      double pointsPerReception, double recPtsPerYD, double recTD, double fumble, double twoPtCon,
      double PATMade, double PATMissed, double FG039Made, double FG039Missed, double FG4049Made,
      double FG4049Missed, double FG50Made, double FG50Missed, double sack, double defInt,
      double defFumble, double safety, double defTD, double retTD, double ptAllowed0,
      double ptAllowed713, double ptAllowed1420, double ptAllowed2127, double ptAllowed2834,
      double ptAllowed35) {
    this.yourPick = yourPick;
    this.numTeams = numTeams;
    this.pickNum = pickNum;
    this.qbNum = qbNum;
    this.rbNum = rbNum;
    this.wrNum = wrNum;
    this.teNum = teNum;
    this.flexNum = flexNum;
    this.kickNum = kickNum;
    this.defNum = defNum;
    this.benchNum = benchNum;
    this.rosterNum = this.qbNum + this.rbNum + this.wrNum + this.teNum + 
        this.flexNum + this.kickNum + this.defNum + this.benchNum;
    this.passPtsPerYd = passPtsPerYd;
    this.passTD = passTD;
    this.passInt = passInt;
    this.rushPtsPerYd = rushPtsPerYd;
    this.rushTD = rushTD;
    this.pointsPerReception = pointsPerReception;
    this.recPtsPerYD = recPtsPerYD;
    this.recTD = recTD;
    this.fumble = fumble;
    this.twoPtCon = twoPtCon;
    this.PATMade = PATMade;
    this.PATMissed = PATMissed;
    this.FG039Made = FG039Made;
    this.FG039Missed = FG039Missed;
    this.FG4049Made = FG4049Made;
    this.FG4049Missed = FG4049Missed;
    this.FG50Made = FG50Made;
    this.FG50Missed = FG50Missed;
    this.sack = sack;
    this.defInt = defInt;
    this.defFumble = defFumble;
    this.safety = safety;
    this.defTD = defTD;
    this.retTD = retTD;
    this.ptAllowed0 = ptAllowed0;
    this.ptAllowed713 = ptAllowed713;
    this.ptAllowed1420 = ptAllowed1420;
    this.ptAllowed2127 = ptAllowed2127;
    this.ptAllowed2834 = ptAllowed2834;
    this.ptAllowed35 = ptAllowed35;
  }

}
