/* GoodNeighbor 
   Crime class
*/

public class Crime{
    //instance variables
    protected int extremity;
    protected int priority;
    protected int timer;
    protected String name;

    protected boolean needParamedics;  //for Arson, Murder, CarCrash, Drugs, SexualAssault, Kidnapping
    protected boolean needCoroner;   //same as above
    protected boolean needFireDept;
    protected boolean needFBI;
    protected boolean needIRS;
    protected boolean needTow;   //For CarCrash and ParkingVio
    protected boolean needBackUp;  //For more police cars if needed
    

    public Crime(int extrem){     //constructor
	extremity = extrem;
        priority = 0;
    }

    public int getPriority() {
	return priority;
    }

    public int getTimer() {
	return timer;
    }
    
    public int setPriority(int prior) {
	int temp = priority;
	priority = prior;
	return temp;
    }

    public int changeTimer(double factor) { //benefit/punishment. Factor == 2 or 0.5
	int temp = timer;
	timer *= factor;
	return temp;
    }

    public String toString() {
	return name + " -- Extremity = " + extremity;
    }

    public static void main(String[] args){

    }

}
