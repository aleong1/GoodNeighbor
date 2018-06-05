/* GoodNeighbor 
   Crime class
*/

public class Crime{
    //instance variables
    protected int extremity;
    protected int priority;
    protected int timer;

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

    public Crime setPriority(int prior) {
	int temp = priority;
	priority = prior;
	return temp;
    }

    public static void main(String[] args){

    }

}
