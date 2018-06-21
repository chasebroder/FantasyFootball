import java.util.ArrayList;

class Draft {
  int numTeams;
  int numPicks;
  ArrayList<Player> undrafted;
  ArrayList<Player> drafted;
  ArrayList<QB> QBUndrafted;
  ArrayList<RB> RBUndrafted;
  ArrayList<WR> WRUndrafted;
  ArrayList<TE> TEUndrafted;
  ArrayList<K> KUndrafted;
  ArrayList<DEF> DEFUndrafted;
  League league;

  void addQB(String name,  double passYds, int passTDs, double rushYds, int rushTDs, int interceptions, 
      int fumbles, int twoPtCon) {
    this.undrafted.add(new QB(name, this.league, passYds, passTDs, rushYds, rushTDs, interceptions, fumbles, twoPtCon));
  }

  void addRB() {
  }

  void addWR() {

  }

  void addTE() {

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
  void calculateXVal(ArrayList<Player> players) {
    for(Player p: players) {
      
    }
  }
}