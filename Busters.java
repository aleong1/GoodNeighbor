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
	isChosen = false;
    }

    public boolean getIsChosen() {
	return isChosen;
    }

    public void changeIsChosen() {
	isChosen = (! isChosen);
    }
    
    public String toString() {
	return name;
    }

    public boolean doTheyMatch(Crime input) {
	if (input instanceof Arson && solveArson) return true;
	if (input instanceof Murder && solveMurder) return true;
	if (input instanceof Traffic && solveTraffic) return true;
	if (input instanceof Drugs && solveDrugs) return true;
	if (input instanceof SexualAssault && solveSexualAssault) return true;
	if (input instanceof Kidnapping && solveKidnapping) return true;
	if (input instanceof TaxFraud && solveTaxFraud) return true;
	return false;
    }
}
