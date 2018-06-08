/* GoodNeighbor 
   Crime class
*/

public class Crime{
    //instance variables
    protected int extremity;
    protected int timer;
    protected String name;

    protected boolean emergency;
    protected boolean needParamedics;  //for Arson, Murder, CarCrash, Drugs, SexualAssault, Kidnapping
    protected boolean needCoroner;   //same as above
    protected boolean needFireDept;
    protected boolean needFBI;
    protected boolean needIRS;
    protected boolean needTow;   //For CarCrash and ParkingVio
    protected boolean needNone; 
    

    public Crime(int extrem){     //constructor
	extremity = extrem;
    }

    public Crime(int extrem, boolean isEmergency) {
	this(extrem);
	emergency = isEmergency;
    }

    public boolean getEmergency() {
	return emergency;
    }

    public int getTimer() {
	return timer;
    }

    public int changeTimer(int difference) {
	int temp = timer;
	timer -= difference;
	return temp;
    }

    public int changeTimer(double factor) { //benefit/punishment. Factor == 2 or 0.5
	int temp = timer;
	timer *= factor;
	return temp;
    }

    public boolean getNeedNone() {
	return needNone;
    }

    public String toString() {
	return name + " -- Extremity = " + extremity + " -- Time to Solve = " + timer + " minutes";
    }

    public static void main(String[] args){

    }

}
