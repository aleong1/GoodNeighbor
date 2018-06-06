public class TaxFraud extends Crime{
    //constructor
    public TaxFraud(int extrem) {
	super(extrem);
	if (extrem == 2) timer = 15000; //30 minutes

	needIRS = true;
	
	name = "TaxFraud";
    }

}
