public class Traffic extends Crime{
    //constructor
    public Traffic(int extrem) {
        super(extrem);
	
	if (extrem == 1) timer = 10; //10 minutes (1 minute == .5 seconds)
	else if (extrem == 2) timer = 30; //30 minutes
	else if (extrem == 3) timer = 60; //1 hour
	else if (extrem == 4) timer = 120; //2 hours
	else if (extrem == 5) timer = 240; //4 hours

	needParamedics = true;
	needCoroner = true;
	needTow = true;

	name = "Traffic";
    }

}
