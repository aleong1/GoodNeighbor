/* GoodNeighbor 
   Busters class
*/

public class Busters{
    //instance variables
    protected String name;

    protected boolean isChosen;
    
    protected boolean solveArson;
    protected boolean solveMurder;
    protected boolean solveTraffic;
    protected boolean solveDrugs;
    protected boolean solveSexualAssault;
    protected boolean solveKidnapping;
    protected boolean solveTaxFraud;
    
    public Busters(){     //constructor
	isChosen = true;
    }

    public void changeIsChosen() {
	isChosen = (! isChosen);
    }
    
    public String toString() {
	return name;
    }
}
