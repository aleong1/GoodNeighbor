public class Vandalism extends Crime{
    //constructor
    public Vandalism(int extrem) {
        super(extrem);
	
	if (extrem == 1) timer = 5000; //10 minutes (1 minute == .5 seconds)
	else if (extrem == 2) timer = 15000; //30 minutes

	name = "Vandalism";
	
    }
}
