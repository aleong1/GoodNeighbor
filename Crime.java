/* GoodNeighbor 
   Crime class
*/

public class Crime{
    //instance variables
    private int extremity;
    private int priority;
    private int timer;

    private boolean needParamedics;  //for Arson, Murder, CarCrash, Drugs, SexualAssault, Kidnapping
    private boolean needCoroner;   //same as above
    private boolean needFireDept;
    private boolean needFBI;
    private boolean needIRS;
    private boolean needTow;   //For CarCrash and ParkingVio
    private boolean needBackUp;  //For more police cars if needed
    

    public Crime(int extrem, int prior){     //constructor
	extremity = extrem;
	priority = prior;
    }

    public static void main(String[] args){

    }

}
