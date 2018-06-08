public class Kidnapping extends Crime{
    //constructor
    public Kidnapping(int extrem) {
        super(extrem);

	if (extrem == 3) timer = 60; //1 hour
	else if (extrem == 4) timer = 120; //2 hours
	else if (extrem == 5) timer = 240; //4 hours

	needParamedics = true;
	needCoroner = true;
	needFBI = true;

	name = "Kidnapping";
    }

    public Kidnapping(int extrem, boolean isEm) {
        super(extrem, isEm);

	if (extrem == 3) timer = 60; //1 hour
	else if (extrem == 4) timer = 120; //2 hours
	else if (extrem == 5) timer = 240; //4 hours

	needParamedics = true;
	needCoroner = true;
	needFBI = true;

	name = "Kidnapping";
    }

}
