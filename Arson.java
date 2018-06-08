public class Arson extends Crime{

    //constructor
    public Arson(int extrem) {
        super(extrem);
	
	if (extrem == 1) timer = 10; //10 minutes
	else if (extrem == 2) timer = 30; //30 minutes
	else if (extrem == 3) timer = 60; //1 hour
	else if (extrem == 4) timer = 120; //2 hours
	else if (extrem == 5) timer = 240; //4 hours

	needParamedics = true;
	needFireDept = true;
	needCoroner = true;

	name = "Arson";
    }

    public Arson(int extrem, boolean isEm) {
        super(extrem, isEm);
	
	if (extrem == 1) timer = 10; //10 minutes
	else if (extrem == 2) timer = 30; //30 minutes
	else if (extrem == 3) timer = 60; //1 hour
	else if (extrem == 4) timer = 120; //2 hours
	else if (extrem == 5) timer = 240; //4 hours

	needParamedics = true;
	needFireDept = true;
	needCoroner = true;

	name = "Arson";
    }

}
