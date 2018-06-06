public class Kidnapping extends Crime{
    //constructor
    public Kidnapping(int extrem) {
        super(extrem);

	if (extrem == 3) timer = 30000; //1 hour
	else if (extrem == 4) timer = 60000; //2 hours
	else if (extrem == 5) timer = 120000; //4 hours

	needParamedics = true;
	needCoroner = true;
	needFBI = true;
	needBackUp = true;

	name = "Kidnapping";
    }

}
