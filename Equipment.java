public class Equipment{
    //instance vars
    protected int value;
    protected String name;

    protected boolean helpMurder;
    protected boolean helpTraffic;
    protected boolean helpDrugs;
    protected boolean helpSA;
    protected boolean helpAll;

    public Equipment(){}

    public int getValue() {
	return value;
    }

    public int setValue(int newVal) {
	int temp = value;
	value = newVal;
	return temp;
    }

    public String toString() {
	return name;
    }

    public boolean doTheyMatch(Crime input) {
	if (helpAll) return true;
	if (input instanceof Murder && helpMurder) return true;
	if (input instanceof Drugs && helpDrugs) return true;
	if (input instanceof SexualAssault && helpSA) return true;
	if (input instanceof Traffic && helpTraffic) return true;
	return false;
    }

}
