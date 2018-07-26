import java.util.ArrayList;
import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document; 
import org.jsoup.nodes.Element;

class Draft {
  public static void main(String[] args) throws IOException{
    //Examples
    Team myTeam = new Team(0, 0, 0, 0, 0, 0, 0);

    League myLeague = new League(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.04, 6.0, -2.0, 0.1, 6.0, 0.5, 0.1, 6.0, -2.0, 2.0, 1.0, -1.0,
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
    
    Document doc = Jsoup.connect("https://www.fantasypros.com/nfl/projections/qb.php?week=draft").get();  
    String title = doc.title();  
    System.out.println("title is: " + title);  
    int i = 0;
    int pass = 2;
    while(i<50) {
    	String name = doc.select("td.player-label").get(i).text();
    	String passYds = doc.select("td.center").get(pass).text();
    	int comma = passYds.indexOf(',');
    	if(comma >0) {
    		passYds = passYds.substring(0, comma) + passYds.substring(comma+1, passYds.length());
    	}
    	double passYdsd = Double.parseDouble(passYds);
    	double passTds = Double.parseDouble(doc.select("td.center").get(pass + 1).text());
    	double passInts = Double.parseDouble(doc.select("td.center").get(pass + 2).text());
    	double rushYds = Double.parseDouble(doc.select("td.center").get(pass + 4).text());
    	double rushTds = Double.parseDouble(doc.select("td.center").get(pass + 5).text());
    	double fumbles = Double.parseDouble(doc.select("td.center").get(pass + 6).text());
    	//System.out.println(name + " " + passYdsd + " " + passTds + " " + passInts + " " + rushYds + " " + rushTds + " " + fumbles);
    	undrafted.add(new QB(name, myLeague, passYdsd, passTds, rushYds, rushTds, passInts, fumbles, 0.0));
    	i++;
    	pass +=10;
    }
    Document docRB = Jsoup.connect("https://www.fantasypros.com/nfl/projections/rb.php?week=draft").get();
    int h = 0;
    int rush = 1;
    while(h<65) {
    	String name = docRB.select("td.player-label").get(h).text();
    	String rushYds = docRB.select("td.center").get(rush).text();
    	int comma = rushYds.indexOf(',');
    	if(comma >0) {
    		rushYds = rushYds.substring(0, comma) + rushYds.substring(comma+1, rushYds.length());
    	}
    	double rushYdsd = Double.parseDouble(rushYds);
    	double rushTds = Double.parseDouble(docRB.select("td.center").get(rush + 1).text());
    	double recs = Double.parseDouble(docRB.select("td.center").get(rush + 3).text());
    	double recYds = Double.parseDouble(docRB.select("td.center").get(rush + 4).text());
    	double recTds = Double.parseDouble(docRB.select("td.center").get(rush + 5).text());
    	double fumbles = Double.parseDouble(docRB.select("td.center").get(rush + 2).text());
    	//System.out.println(name + " " + rushYdsd + " " + rushTds + " " + recs + " " + recYds + " " + recTds + " " + fumbles);
    	undrafted.add(new RB(name, myLeague, rushYdsd, rushTds, recs, recYds, recTds, fumbles, 0 ));
    	h++;
    	rush +=8;
    }
    Document docWR = Jsoup.connect("https://www.fantasypros.com/nfl/projections/wr.php?week=draft").get();
    int x = 0;
    int receptions = 1;
    while(x<65) {
    	String name = docWR.select("td.player-label").get(x).text();
    	double rushYds = Double.parseDouble(docWR.select("td.center").get(receptions + 3).text()); 
    	double rushTds = Double.parseDouble(docWR.select("td.center").get(receptions + 4).text());
    	double recs = Double.parseDouble(docWR.select("td.center").get(receptions - 1).text());
    	String recYds = docWR.select("td.center").get(receptions).text();
    	int comma = recYds.indexOf(',');
    	if(comma >0) {
    		recYds = recYds.substring(0, comma) + recYds.substring(comma+1, recYds.length());
    	}
    	double recYdsd = Double.parseDouble(recYds);
    	double recTds = Double.parseDouble(docWR.select("td.center").get(receptions + 1).text());
    	double fumbles = Double.parseDouble(docWR.select("td.center").get(receptions + 5).text());
    	//System.out.println(name + " " + recs + " " + recYdsd + " " + recTds + " " + rushYds + " " + rushTds + " " + fumbles);
    	undrafted.add(new WR(name, myLeague, rushYds, rushTds, recs, recYdsd, recTds, fumbles, 0 ));
    	x++;
    	receptions +=8;
    }
    Document docTE = Jsoup.connect("https://www.fantasypros.com/nfl/projections/te.php?week=draft").get();
    int t = 0;
    int receptionsT = 0;
    while(t<50) {
    	String name = docTE.select("td.player-label").get(t).text();
    	double rushYds = 0;
    	double rushTds = 0;
    	double recs = Double.parseDouble(docTE.select("td.center").get(receptionsT).text());
    	String recYds = docTE.select("td.center").get(receptionsT + 1).text();
    	int comma = recYds.indexOf(',');
    	if(comma >0) {
    		recYds = recYds.substring(0, comma) + recYds.substring(comma+1, recYds.length());
    	}
    	double recYdsd = Double.parseDouble(recYds);
    	double recTds = Double.parseDouble(docTE.select("td.center").get(receptionsT + 2).text());
    	double fumbles = Double.parseDouble(docTE.select("td.center").get(receptionsT + 3).text());
    	//System.out.println(name + " " + rushYds + " " + rushTds + " " + recs + " " + recYdsd + " " + recTds + " " + fumbles);
    	undrafted.add(new TE(name, myLeague, rushYds, rushTds, recs, recYdsd, recTds, fumbles, 0 ));
    	t++;
    	receptionsT +=5;
    }
    Document docDEF = Jsoup.connect("http://www.fftoday.com/rankings/playerproj.php?PosID=99&LeagueID=1").get();
	int r = 0;
	int defIdx = 1;
	while (r < 20) {
		String name = docDEF.select("td.sort1").get(defIdx).text();
		double sack = Double.parseDouble(docDEF.select("td.sort1").get(defIdx + 2).text());
		double fumRec = Double.parseDouble(docDEF.select("td.sort1").get(defIdx+ 3).text());
		double ints = Double.parseDouble(docDEF.select("td.sort1").get(defIdx + 4).text());
		double defTD = Double.parseDouble(docDEF.select("td.sort1").get(defIdx + 5).text());
		double ptsAllowed = Double.parseDouble(docDEF.select("td.sort1").get(defIdx + 6).text());
		double safety = Double.parseDouble(docDEF.select("td.sort1").get(defIdx + 9).text());
		double retTD = Double.parseDouble(docDEF.select("td.sort1").get(defIdx + 10).text());
		//System.out.println(name + " " + sack + " " + fumRec + " " + ints + " " + defTD + " " + ptsAllowed + " " + safety + " " + kickretTD);
		defIdx += 13;
		r++;
		undrafted.add(new DEF(name, myLeague, sack, ints, fumRec, safety, defTD, retTD, ptsAllowed));
	}
    
//    undrafted.add(myQB);
//    undrafted.add(yourQB);
//    undrafted.add(myRB);
//    undrafted.add(yourRB);
//    undrafted.add(myWR);
//    undrafted.add(yourWR);
//    undrafted.add(myTE);
//    undrafted.add(yourTE);
//    undrafted.add(myK);
//    undrafted.add(yourK);
//    undrafted.add(myDEF);
//    undrafted.add(yourDEF);
    
    Draft d1 = new Draft(undrafted, myLeague, myTeam);
    
    //tests
//    System.out.println(myQB.name + myQB.projectedPoints);
//    System.out.println(yourQB.name + yourQB.projectedPoints);
//    System.out.println(myRB.name + myRB.projectedPoints);
//    System.out.println(yourRB.name + yourRB.projectedPoints);
//    System.out.println(myWR.name + myWR.projectedPoints);
//    System.out.println(yourWR.name + yourWR.projectedPoints);
//    System.out.println(myTE.name + myTE.projectedPoints);
//    System.out.println(yourTE.name + yourTE.projectedPoints);
//    System.out.println(myK.name + myK.projectedPoints);
//    System.out.println(yourK.name + yourK.projectedPoints);
//    System.out.println(myDEF.name + myDEF.projectedPoints);
//    System.out.println(yourDEF.name + yourDEF.projectedPoints);
     for(int q = 0; q<d1.undrafted.size(); q++) {
       System.out.println(d1.undrafted.get(q).name + d1.undrafted.get(q).xValue);
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
    //Should be 9
    this.calculateXValue(this.QBUndrafted, 9);
    //should be 40
    this.calculateXValue(this.RBUndrafted, 40);
    //should be 37
    this.calculateXValue(this.WRUndrafted, 37);
    // should by 9
    this.calculateXValue(this.TEUndrafted, 9);
    this.calculateXValue(this.KUndrafted, 1);
    //should be 2
    this.calculateXValue(this.DEFUndrafted, 1);
    this.heapBuildX();
    this.heapSortX();
    //this.needFactor();
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
    if (this.undrafted.get(i).projectedPoints < this.undrafted.get(parentIdx).projectedPoints) {
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
  // Effect:Used when adding elements to the heap; bubbles up the element until a
  // heap is made
  void upHeapX(int i) {
    int parentIdx = ((i - 1) / 2);
    if (this.undrafted.get(i).xValue < this.undrafted.get(parentIdx).xValue) {
      Player parent = this.undrafted.get(parentIdx);
      Player child = this.undrafted.get(i);
      this.undrafted.set(parentIdx, child);
      this.undrafted.set(i, parent);
      upHeapX(parentIdx);
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
        if (this.undrafted.get(leftIdx).xValue < this.undrafted.get(rightIdx).xValue) {
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
      //System.out.println("swapo" + undrafted.get(i).xValue + " " + undrafted.get(leftIdx).xValue);
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
        //System.out.print(undrafted.get(q).xValue + " ");
        q++;
      }
      //System.out.println("");
      Player max = this.undrafted.get(0);
      Player last = this.undrafted.get(end);
      this.undrafted.set(0, last);
      this.undrafted.set(end, max);
      end--;
      i++;
      
      downHeapX(0, end);
      
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

}
