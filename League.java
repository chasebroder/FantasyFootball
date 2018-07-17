import java.util.ArrayList;

class League {
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
  double ptAllowed713;
  double ptAllowed1420;
  double ptAllowed2127;
  double ptAllowed2834;
  double ptAllowed35;
  int yourPick;
  int numTeams;

  League(double passPtsPerYd, double passTD, double passInt, double rushPtsPerYd, double rushTD,
      double pointsPerReception, double recPtsPerYD, double recTD, double fumble, double twoPtCon,
      double PATMade, double PATMissed, double FG039Made, double FG039Missed, double FG4049Made,
      double FG4049Missed, double FG50Made, double FG50Missed, double sack, double defInt,
      double defFumble, double safety, double defTD, double retTD, double ptAllowed0,
      double ptAllowed713, double ptAllowed1420, double ptAllowed2127, double ptAllowed2834,
      double ptAllowed35, int yourPick, int numTeams) {
    this.passPtsPerYd = passPtsPerYd;
    this.passTD = passTD;
    this.passInt = passInt;
    this.rushPtsPerYd = rushPtsPerYd;
    this.rushTD = rushTD;
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
    this.yourPick = yourPick;
    this.numTeams = numTeams;

  }

}
