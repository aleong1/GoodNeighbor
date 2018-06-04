public class Murder extends Crime{

    //constructor
    public Murder(int extrem) {
        super(extrem);
	if (extrem == 4) timer = 120000; //4 hours
	else if (extrem == 5) timer = 180000; //6 hours

	needParamedics = true;
	needFBI = true;
	needCoroner = true;
    }

    public static void main(String[] args){

    } 
}
