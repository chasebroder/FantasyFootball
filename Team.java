import java.util.ArrayList;

class Team {
  ArrayList<Player> roster; // list of players on your team
  ArrayList<Player> starters; // list of starters on your team
  ArrayList<Player> bench; // list of players on your bench
  int qbs; // number of quarterbacks on your team
  int rbs; // number of running backs on your team
  int wrs; // number of wide receivers on your team
  int tes; // number of tight ends on your team
  int flex; // number of flexes on your team
  int k; // number of kickers on your team
  int def; // number of defenses on your team
  
 // for testing
  Team(int qbs, int rbs, int wrs, int tes, int flex, int k, int def) {
    this.qbs = qbs;
    this.rbs = rbs;
    this.wrs = wrs;
    this.tes = tes;
    this.flex = flex;
    this.k = k;
    this.def = def;
  }

  // drafts player onto your team
  void draftPlayer(Player p, League l) {
    this.roster.add(p);
    // double dispatch to determine if player starter or bench
    p.determineRole(this, l);
    l.yourPick += (l.numTeams - l.yourPick % l.numTeams) * 2 + 1;
  }
}
