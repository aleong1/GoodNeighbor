public class Murder extends Crime{

    //constructor
    public Murder(int extrem) {
        super(extrem);
	if (extrem == 4) timer = 240; //4 hours
	else if (extrem == 5) timer = 360; //6 hours

	needParamedics = true;
	needFBI = true;
	needCoroner = true;

	name = "Murder";
    }
}
