public class SexualAssault extends Crime{
    //constructor
    public SexualAssault(int extrem) {
	super(extrem);

	if (extrem == 3) timer = 30000; //1 hour
	else if (extrem == 4) timer = 60000; //2 hours
	else if (extrem == 5) timer = 120000; //4 hours

	needParamedics = true;
	needBackUp = true;

	name = "SexualAssault";
    }

    public static void main(String[] args){

    }

}

}
