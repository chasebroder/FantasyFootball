import java.util.ArrayList;

class Draft {
  public static void Main(String[] args) {
    
  }
  int pickNum;
  ArrayList<Player> undrafted;
  ArrayList<Player> drafted;
  ArrayList<QB> QBUndrafted;
  ArrayList<RB> RBUndrafted;
  ArrayList<WR> WRUndrafted;
  ArrayList<TE> TEUndrafted;
  ArrayList<K> KUndrafted;
  ArrayList<DEF> DEFUndrafted;
  League league;
  Team myTeam;

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
      int retTDs, int ptsAllowed0, int ptsAllowed16, int ptsAllowed713, int ptsAllowed1420, 
      int ptsAllowed2127, int ptsAllowed2834, int ptsAllowed35) {
    this.undrafted.add(new DEF(name, this.league, sacks, interceptions, fumbles, safeties, defTDs,
        retTDs, ptsAllowed0, ptsAllowed16, ptsAllowed713, ptsAllowed1420, ptsAllowed2127, ptsAllowed2834,
        ptsAllowed35));
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
      if (this.undrafted.get(i).projectedPoints < this.undrafted.get(leftIdx).projectedPoints
          || (this.undrafted.get(i).projectedPoints < this.undrafted.get(rightIdx).projectedPoints)) {
        if (this.undrafted.get(leftIdx).projectedPoints > this.undrafted.get(rightIdx).projectedPoints) {
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
    if (rightIdx > maxIdx && leftIdx <= maxIdx && this.undrafted.get(i).projectedPoints < this.undrafted.get(leftIdx).projectedPoints) {
      Player parent = this.undrafted.get(i);
      Player child = this.undrafted.get(leftIdx);
      this.undrafted.set(i, child);
      this.undrafted.set(leftIdx, parent);
      downHeap(leftIdx, maxIdx);
    }
  }
  // Effect:Used when adding elements to the heap; bubbles up the element until a
  // heap is made
  void upHeapX(int i) {
    int parentIdx = ((i - 1) / 2);
    if (this.undrafted.get(i).xValue > this.undrafted.get(parentIdx).xValue) {
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
      if (this.undrafted.get(i).xValue < this.undrafted.get(leftIdx).xValue
          || (this.undrafted.get(i).xValue < this.undrafted.get(rightIdx).xValue)) {
        if (this.undrafted.get(leftIdx).xValue > this.undrafted.get(rightIdx).xValue) {
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
    if (rightIdx > maxIdx && leftIdx <= maxIdx && this.undrafted.get(i).xValue < this.undrafted.get(leftIdx).xValue) {
      Player parent = this.undrafted.get(i);
      Player child = this.undrafted.get(leftIdx);
      this.undrafted.set(i, child);
      this.undrafted.set(leftIdx, parent);
      downHeap(leftIdx, maxIdx);
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
  //Effect:Calculates the xValue of Players
  void calculateXValue(ArrayList<Player> players, int benchmark) {
    for(Player p: players) {
      p.xValue = p.projectedPoints - players.get(benchmark).projectedPoints;
    }
  }
  void needFactor() {
    for(Player p: this.undrafted) {
      if((p instanceof QB) && this.team.qbs >= 1) {
        p.xValue = p.xValue*(1 - this.team.qbs *0.2);
      }
      if((p instanceof Flex) && this.team.flex == 1 && this.myTeam.rbs >= 2) {
        p.xValue = (1 - this.team.rbs-1 *0.2);
      }
      if((p instanceof Flex) && this.team.flex == 1 && this.myTeam.wrs >= 2) {
        p.xValue = (1 - this.team.wrs-1 *0.2);
      }
      if((p instanceof Flex) && this.team.flex == 1 && this.myTeam.tes >= 1) {
        p.xValue = (1 - this.team.tes *0.2);
      }
      if((p instanceof K) && this.team.k >= 1) {
        p.xValue = p.xValue*(1 - this.team.k *0.2);
      }
      if((p instanceof DEF) && this.team.def >= 1) {
        p.xValue = p.xValue*(1 - this.team.def *0.2);
      }
    }
  }

}
