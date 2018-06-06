public class Traffic extends Crime{
    //constructor
    public Traffic(int extrem) {
        super(extrem);
	
	if (extrem == 1) timer = 5000; //10 minutes (1 minute == .5 seconds)
	else if (extrem == 2) timer = 15000; //30 minutes
	else if (extrem == 3) timer = 30000; //1 hour
	else if (extrem == 4) timer = 60000; //2 hours
	else if (extrem == 5) timer = 120000; //4 hours

	needParamedics = true;
	needFireDept = true;
	needCoroner = true;

	name = "Traffic";
    }

}
