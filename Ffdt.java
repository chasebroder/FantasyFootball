package ffdt;

import java.util.ArrayList;


public class Ffdt {

   
    public static void main(String[] args) {
        
        Team myTeam = new Team();
        
        League myLeague = new League();
        
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
        DEF myDEF = new DEF("Giants DEF",myLeague,50,30,10,5,25,10,16,0,0,0,0,0,0);
        DEF yourDEF = new DEF("Pats DEF",myLeague,20,20,30,30,20,30,15,1,0,0,0,0,0);
    }
    
}