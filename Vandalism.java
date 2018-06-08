public class Vandalism extends Crime{
    //constructor
    public Vandalism(int extrem) {
        super(extrem);
	
	if (extrem == 1) timer = 10; //10 minutes (1 minute == .5 seconds)
	else if (extrem == 2) timer = 30; //30 minutes

	name = "Vandalism";

	needNone = true;
	
    }

    public Vandalism(int extrem, boolean isEm) {
        super(extrem, isEm);
	
	if (extrem == 1) timer = 10; //10 minutes (1 minute == .5 seconds)
	else if (extrem == 2) timer = 30; //30 minutes

	name = "Vandalism";

	needNone = true;
	
    }
}
