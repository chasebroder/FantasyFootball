import java.util.ArrayList;

class Draft {
  public static void main(String[] args) {
    //Examples
    Team myTeam = new Team(0, 0, 0, 0, 0, 0, 0);

    League myLeague = new League(7, 12, 1, 1, 2, 2, 1, 1, 1, 1, 7,
        0.04, 6.0, -2.0, 0.1, 6.0, 0.5, 0.1, 6.0, -2.0, 2.0, 1.0, -1.0,
        3.0, 0.0, 4.0, 0.0, 5.0, 0.0, 1.0, 2.0, 2.0, 2.0, 6.0, 6.0, 10.0,
        8.0, 6.0, 2.0, 1.0, 0.0);

    QB myQB = new QB("Tom Brady",myLeague,5000,35,1000,20,5,2,9);
    QB yourQB = new QB("Aaron Rodgers",myLeague,4000,40,1500,25,7,3,8);
    RB myRB = new RB("Adrian Peterson",myLeague,2100,30,50,1500,29,1,5);
    RB yourRB = new RB("Emmit Smith",myLeague,2000,35,45,2000,25,1,2);
    WR myWR = new WR("Calvin Johnson",myLeague,1000,20,3000,40,1,2,3);
    WR yourWR = new WR("Juju",myLeague,1500,25,2500,30,1,2,3);
    TE myTE = new TE("Jimmy Graham",myLeague,500,5,2500,39,1,1,2);
    TE yourTE = new TE("Gronk",myLeague,250,10,2000,30,1,1,1);
    K myK = new K("Lionel Messi",myLeague,20,0,20,0,20,0,20,0);
    K yourK = new K("Ronaldo",myLeague,20,1,20,1,20,1,20,1);
    DEF myDEF = new DEF("Giants DEF",myLeague,50,30,10,5,25,10,16);
    DEF yourDEF = new DEF("Pats DEF",myLeague,20,20,30,30,20,30,15);

    ArrayList<Player> undrafted = new ArrayList<Player>();
    undrafted.add(myQB);
    undrafted.add(yourQB);
    undrafted.add(myRB);
    undrafted.add(yourRB);
    undrafted.add(myWR);
    undrafted.add(yourWR);
    undrafted.add(myTE);
    undrafted.add(yourTE);
    undrafted.add(myK);
    undrafted.add(yourK);
    undrafted.add(myDEF);
    undrafted.add(yourDEF);

    Draft d1 = new Draft(undrafted, myLeague, myTeam);

    //tests
    System.out.println(myQB.name + myQB.projectedPoints);
    System.out.println(yourQB.name + yourQB.projectedPoints);
    System.out.println(myRB.name + myRB.projectedPoints);
    System.out.println(yourRB.name + yourRB.projectedPoints);
    System.out.println(myWR.name + myWR.projectedPoints);
    System.out.println(yourWR.name + yourWR.projectedPoints);
    System.out.println(myTE.name + myTE.projectedPoints);
    System.out.println(yourTE.name + yourTE.projectedPoints);
    System.out.println(myK.name + myK.projectedPoints);
    System.out.println(yourK.name + yourK.projectedPoints);
    System.out.println(myDEF.name + myDEF.projectedPoints);
    System.out.println(yourDEF.name + yourDEF.projectedPoints);
    for(int i = 0; i<d1.undrafted.size(); i++) {
      System.out.println(d1.undrafted.get(i).name + d1.undrafted.get(i).xValue);
    }
  }

  int pickNum;
  ArrayList<Player> undrafted;
  ArrayList<Player> drafted;
  ArrayList<Player> QBUndrafted;
  ArrayList<Player> RBUndrafted;
  ArrayList<Player> WRUndrafted;
  ArrayList<Player> TEUndrafted;
  ArrayList<Player> KUndrafted;
  ArrayList<Player> DEFUndrafted;
  League league;
  Team myTeam;
  Draft(ArrayList<Player> undrafted, League league, Team myTeam){
    this.undrafted = undrafted;
    this.league = league;
    this.myTeam = myTeam;
    this.heapBuild();
    this.heapSort();
    this.QBUndrafted = new ArrayList<Player>();
    this.RBUndrafted = new ArrayList<Player>();
    this.WRUndrafted = new ArrayList<Player>();
    this.TEUndrafted = new ArrayList<Player>();
    this.KUndrafted = new ArrayList<Player>();
    this.DEFUndrafted = new ArrayList<Player>();
    this.createUndraftedPlayersList();
    //Should be 15
    this.calculateXValue(this.QBUndrafted, 1);
    //should be 36
    this.calculateXValue(this.RBUndrafted, 1);
    //should be 38
    this.calculateXValue(this.WRUndrafted, 1);
    // should by 8
    this.calculateXValue(this.TEUndrafted, 1);
    this.calculateXValue(this.KUndrafted, 1);
    //should be 2
    this.calculateXValue(this.DEFUndrafted, 1);
    this.heapBuildX();
    this.heapSortX();
    this.needFactor();
  }

  //EFFECT: creates a new quarterback and adds it to list of undrafted players
  void addQB(String name,  int passYds, int passTDs, int rushYds, int rushTDs, int interceptions, 
      int fumbles, int twoPtCon) {
    this.undrafted.add(new QB(name, this.league, passYds, passTDs, rushYds, rushTDs, interceptions, fumbles, twoPtCon));
  }

  //EFFECT: creates a new running back and adds it to list of undrafted players
  void addRB(String name, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    this.undrafted.add(new RB(name, this.league, rushYds, rushTDs, receptions, receivingYds, receivingTDs,
        fumbles, twoPtCons));
  }

  //EFFECT: creates a new wide receiver and adds it to list of undrafted players
  void addWR(String name, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    this.undrafted.add(new WR(name, this.league, rushYds, rushTDs, receptions, receivingYds, receivingTDs,
        fumbles, twoPtCons));
  }

  //EFFECT: creates a new tight end and adds it to list of undrafted players
  void addTE(String name, int rushYds, int rushTDs, int receptions, int receivingYds, int receivingTDs,
      int fumbles, int twoPtCons) {
    this.undrafted.add(new TE(name, this.league, rushYds, rushTDs, receptions, receivingYds, receivingTDs,
        fumbles, twoPtCons));
  }

  //EFFECT: creates a new kicker and adds it to list of undrafted players
  void addK(String name, int PATsMade, int PATsMissed, int FG039Made, int FG039Missed,
      int FG4049Made, int FG4049Missed, int FG50Made, int FG50Missed) {
    this.undrafted.add(new K(name, this.league, PATsMade, PATsMissed, FG039Made, FG039Missed,
        FG4049Made, FG4049Missed, FG50Made, FG50Missed));
  }

  //EFFECT: creates a new defense and adds it to list of undrafted players
  void addDEF(String name, int sacks, int interceptions, int fumbles, int safeties, int defTDs,
      int retTDs, int ptsAllowed) {
    this.undrafted.add(new DEF(name, this.league, sacks, interceptions, fumbles, safeties, defTDs,
        retTDs, ptsAllowed));
  }

  //Effect: Adds all the Players to a list of undrafted players
  void createUndraftedList() {

  }

  //Effect: Adds all the Players to a list of their positions
  void createUndraftedPlayersList() {
    for(Player p: this.undrafted) {
      if(p instanceof QB) {
        QBUndrafted.add((QB)p);
      }
      if(p instanceof RB) {
        RBUndrafted.add((RB)p);
      }
      if(p instanceof WR) {
        WRUndrafted.add((WR)p);
      }
      if(p instanceof TE) {
        TEUndrafted.add((TE)p);
      }
      if(p instanceof K) {
        KUndrafted.add((K)p);
      }
      if(p instanceof DEF) {
        DEFUndrafted.add((DEF)p);
      }
    }
  }
  // Effect: builds a heap
  void heapBuild() {
    for (int i = 1; i < this.undrafted.size(); i++) {
      upHeap(i);
    }
  }

  void heapBuildX() {
    for (int i = 1; i < this.undrafted.size(); i++) {
      upHeapX(i);
    }
  }

  // Effect:Used when adding elements to the heap; bubbles up the element until a
  // heap is made
  void upHeap(int i) {
    int parentIdx = ((i - 1) / 2);
    if (this.undrafted.get(i).projectedPoints > this.undrafted.get(parentIdx).projectedPoints) {
      Player parent = this.undrafted.get(parentIdx);
      Player child = this.undrafted.get(i);
      this.undrafted.set(parentIdx, child);
      this.undrafted.set(i, parent);
      upHeap(parentIdx);
    }
  }
  // Effect:used when sorting heap; Swaps first and last items then bubbles down
  // until a heap is made
  void downHeap(int i, int maxIdx) {
    int leftIdx = 2 * i + 1;
    int rightIdx = 2 * i + 2;
    int biggestIdx;
    if (rightIdx <= maxIdx && leftIdx <= maxIdx) {
      if (this.undrafted.get(i).projectedPoints > this.undrafted.get(leftIdx).projectedPoints
          || (this.undrafted.get(i).projectedPoints > this.undrafted.get(rightIdx).projectedPoints)) {
        if (this.undrafted.get(leftIdx).projectedPoints < this.undrafted.get(rightIdx).projectedPoints) {
          biggestIdx = leftIdx;
        }
        else {
          biggestIdx = rightIdx;
        }
        Player parent = this.undrafted.get(i);
        Player child = this.undrafted.get(biggestIdx);
        this.undrafted.set(i, child);
        this.undrafted.set(biggestIdx, parent);
        downHeap(biggestIdx, maxIdx);
      }
    }
    if (rightIdx > maxIdx && leftIdx <= maxIdx && this.undrafted.get(i).projectedPoints > this.undrafted.get(leftIdx).projectedPoints) {
      Player parent = this.undrafted.get(i);
      Player child = this.undrafted.get(leftIdx);
      this.undrafted.set(i, child);
      this.undrafted.set(leftIdx, parent);
      downHeap(leftIdx, maxIdx);
    }
  }

  //Effect:Used when adding elements to the heap; bubbles up the element until a
  // heap is made
  void upHeapX(int i) {
    int parentIdx = ((i - 1) / 2);
    if (this.undrafted.get(i).xValue < this.undrafted.get(parentIdx).xValue) {
      Player parent = this.undrafted.get(parentIdx);
      Player child = this.undrafted.get(i);
      this.undrafted.set(parentIdx, child);
      this.undrafted.set(i, parent);
      upHeap(parentIdx);
    }
  }
  // Effect:used when sorting heap; Swaps first and last items then bubbles down
  // until a heap is made
  void downHeapX(int i, int maxIdx) {
    int leftIdx = 2 * i + 1;
    int rightIdx = 2 * i + 2;
    int biggestIdx;
    if (rightIdx <= maxIdx && leftIdx <= maxIdx) {
      if (this.undrafted.get(i).xValue > this.undrafted.get(leftIdx).xValue
          || (this.undrafted.get(i).xValue > this.undrafted.get(rightIdx).xValue)) {
        if (this.undrafted.get(leftIdx).xValue <= this.undrafted.get(rightIdx).xValue) {
          biggestIdx = leftIdx;
        }
        else {
          biggestIdx = rightIdx;
        }
        Player parent = this.undrafted.get(i);
        Player child = this.undrafted.get(biggestIdx);
        this.undrafted.set(i, child);
        this.undrafted.set(biggestIdx, parent);
        downHeapX(biggestIdx, maxIdx);
      }
    }
    if (rightIdx > maxIdx && leftIdx <= maxIdx && this.undrafted.get(i).xValue > this.undrafted.get(leftIdx).xValue) {
      System.out.println("swapo" + undrafted.get(i).xValue + " " + undrafted.get(leftIdx).xValue);
      Player parent = this.undrafted.get(i);
      Player child = this.undrafted.get(leftIdx);
      this.undrafted.set(i, child);
      this.undrafted.set(leftIdx, parent);
      downHeapX(leftIdx, maxIdx);
    }
  }

  // Effect:sorts the heap from lowest element value to highest
  void heapSort() {
    int i = 0;
    int end = this.undrafted.size() - 1;
    while (i < this.undrafted.size()) {
      Player max = this.undrafted.get(0);
      Player last = this.undrafted.get(end);
      this.undrafted.set(0, last);
      this.undrafted.set(end, max);
      end--;
      i++;
      downHeap(0, end);
    }
  }

  // Effect:sorts the heap from lowest element value to highest
  void heapSortX() {
    int i = 0;
    int end = this.undrafted.size() - 1;
    while (i < this.undrafted.size()) {
      int q =0;
      while(q<undrafted.size()) {
        System.out.print(undrafted.get(q).xValue + " ");
        q++;
      }
      System.out.println("");
      Player max = this.undrafted.get(0);
      Player last = this.undrafted.get(end);
      this.undrafted.set(0, last);
      this.undrafted.set(end, max);
      end--;
      i++;

      downHeapX(0, end);

    }
  }

  //calculates X value for every player in the list
  //will call for each individual position
  void calculateXValue(ArrayList<Player> players, int benchmark) {
    for(Player p: players) {
      p.xValue = p.projectedPoints - players.get(benchmark).projectedPoints;
    }
  }

  //recalculates 
  void needFactor() {
    for(Player p: this.undrafted) {
      if((p instanceof QB) && this.myTeam.qbs >= 1) {
        p.xValue = p.xValue*(1 - this.myTeam.qbs *0.2);
      }
      if((p instanceof Flex) && this.myTeam.flex == 1 && this.myTeam.rbs >= 2) {
        p.xValue = (1 - this.myTeam.rbs-1 *0.2);
      }
      if((p instanceof Flex) && this.myTeam.flex == 1 && this.myTeam.wrs >= 2) {
        p.xValue = (1 - this.myTeam.wrs-1 *0.2);
      }
      if((p instanceof Flex) && this.myTeam.flex == 1 && this.myTeam.tes >= 1) {
        p.xValue = (1 - this.myTeam.tes *0.2);
      }
      if((p instanceof K) && this.myTeam.k >= 1) {
        p.xValue = p.xValue*(1 - this.myTeam.k *0.2);
      }
      if((p instanceof DEF) && this.myTeam.def >= 1) {
        p.xValue = p.xValue*(1 - this.myTeam.def *0.2);
      }
    }
  }

  //drafts a player
  //EFFECT: removes player from undrafted and position undrafted arraylists
  //If drafted to your team, calls other method on team
  void draft(Player p) {
    //is it your pick?
    if (this.league.yourPick == this.league.pickNum) {
      //need to make sure there's room on the bench: not too positive what to do otherwise
      if (this.myTeam.bench.size() < this.league.benchNum) {
        this.myTeam.draftPlayer(p, this.league);
      }
    }
    this.undrafted.remove(p);
    if (p instanceof QB) {
      this.QBUndrafted.remove(p);
    } else if (p instanceof RB) {
      this.RBUndrafted.remove(p);
    } else if (p instanceof WR) {
      this.WRUndrafted.remove(p);
    } else if (p instanceof TE) {
      this.TEUndrafted.remove(p);
    } else if (p instanceof K) {
      this.KUndrafted.remove(p);
    } else {
      this.DEFUndrafted.remove(p);
    }
    //increments pick number by one
    this.league.pickNum += 1;
  }
}

