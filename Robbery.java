public class Robbery extends Crime{
  //constructor
  public Robbery(int extrem) {
      super(extrem);

if (extrem == 1) timer = 5000; //10 minutes (1 minute == .5 seconds)
else if (extrem == 2) timer = 15000; //30 minutes
else if (extrem == 3) timer = 60000; //2 hours

needBackUp = true;
  }

  public static void main(String[] args){

  }

}

}
