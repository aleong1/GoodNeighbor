public class Robbery extends Crime{
    //constructor
    public Robbery(int extrem) {
	super(extrem);

	if (extrem == 1) timer = 10; //10 minutes (1 minute == .5 seconds)
	else if (extrem == 2) timer = 30; //30 minutes
	else if (extrem == 3) timer = 120; //2 hours

	needBackUp = true;

	name = "Robbery";
    }
}
