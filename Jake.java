/**********************
 Jake class - represents player
*********************/

import java.util.Stack;
import cs1.Keyboard;
import java.util.Scanner;

public class Jake {

    public static int score;
    private static String[] interactions;
    private static String[][] aftermath = new String[3][9];
    private static boolean[][] answerBank = new boolean[3][9];

    //constructor
    public Jake() {
	score = 0;
	interactions = new String[9];

	//day 1
	interactions[0] = "Chief Flo: Welcome to the Progressive Police Station, Jake! \nChief Flo: Based off the application you submitted it seems like you’re a very promising cadet.\nChief Flo: I hope you’re not after my job (ha ha)! \nChief Flo: This is your first day, but you'd better not slack off. \nChief Flo: The rumors about how harsh I can be with my officers are all true. \nChief Flo: And before you start, please change your outfit.  \n\n(Select a response. Try to look good.)\n\n\t1. What’s wrong with these khakis? They’re made of a versatile, thin, and FLO-y material, am I right? ;)\n\t2. Of course, Chief Flo! I’ll go straight to work after I stop by We Are Donuts. Do you want me to get you some?\n\t3. Slacker? Me? HAA! I’ve never slacked on anything before in my life. I’m always there 24/7, whenever you call. I’ll be where you need me before you can put down the pager. I basically teleport.";
	interactions[1] = "Chief Flo: Hey, Jake, just checking in on you on your first day. \nChief Flo: How are your cases going?\n\n(Select a response. Try to look good.)\n\n\t1. Yeah, umm...everything’s fine (haha). I mean I caught all the criminals and everything. I even got lunch. So I think I'm good...\n\t2. Sorry sir, I can’t talk to you right now. I’m busy solving crimes and doing the work you’re not doing right now. Good day and goodbye.\n\t3. Thanks for checking up sir! I’m doing ok. I’ve already solved a few crimes, and now I’m working on another.";
	interactions[2] = "Chief Flo: The end of a long day, huh. How was your first day?\nChief Flo: Ready to leave the station and go home? I know I am. \n\n(Select a response. Try to look good.)\n\n\t1. I’ve been waiting for this moment since I stepped into the station. Thanks for being so considerate, bro.\n\t2. I still have some paperwork. But after that,I’m heading home. Thanks for asking, Chief Flo.\n\t3. Yeah, bye! *runs out*";

	//day 2
	interactions[3] = "Chief Flo: Day 2 on the job, Jake. \nChief Flo: I saw how you were doing yesterday, and I think I'll let you go home a little earlier today. \nChief Flo: You'll still have to finish the same amount of work, though. \nChief Flo: Don’t worry Jake, all cadets go through this. \nChief Flo: Just be grateful that you don’t have to go on the station donut and coffee run, or clean the cells, or get paper cuts from filing all the paperwork.\n\n(Select a response. Try to look good.)\n\n\t1. That’s alright. I’m ready for the challenges you throw at me. And if you need to I can totally do all the things you listed, I mean, it’s only part of being a cadet. \n\t2. Aight man, but don’t be upset when, I mean if, I screw up. I’m gonna be totally fine. \n\t3. Test me? C’mon, Chief Flo, do you know how bad I am at tests?! I can’t do anything under pressure! *drops to knees* I can’t handle it!!!";
	interactions[4] = "Chief Flo: So how are the cases coming along? Are you handling them well? Do you think you’re able to keep working 'til the sun goes down?\n\n(Select a response. Try to look good.)\n\n\t1. Sure! I can handle it. I mean, it’s not like I had three panic attacks already but hey, I’m still here and alive (somewhat), so don’t worry! Everything’s gonna be fine and A-OK! \n\t2. A little pressure never hurt anyone, right? I’m doing just fine. I even ordered donuts for the whole station, all on me. \n\t3. Are you sure the sun isn’t already down? From my perspective everything’s very very dark, so, uh, am I ok?";
	interactions[5] = "Chief Flo: Day 2 done, Jake. How was it? \nChief Flo: Here in the Progressive Police Department, we do the best work that the law enforcement has ever seen. \nChief Flo: So here, you have to be at your best. Always.\n\n(Select a response. Try to look good.)\n\n\t1. Today has been great Chief Flo, I got everyone donuts, I cleaned the whole station top to bottom and wow, it’s already time to go home. Time sure flies! \n\t2. Sure, I mean it’s not like I was more stressed out than I've ever been in my whole life, but I guess it was ok. Can I go home now? \n\t3. If you’re gonna up the ante again tomorrow, tell me now because I need to prepare my mind, body, and soul.";

	//day 3
	interactions[6] = "Chief Flo: Day 2 on the job, Jake. \nChief Flo: I saw how you were doing yesterday, and I think I'll let you go home a little earlier today. \nChief Flo: You'll still have to finish the same amount of work, though. \nChief Flo: Don’t worry Jake, all cadets go through this. \nChief Flo: Just be grateful that you don’t have to go on the station donut and coffee run, or clean the cells, or get paper cuts from filing all the paperwork.\n\n(Select a response. Try to look good.)\n\n\t1. That’s alright. I’m ready for the challenges you throw at me. And if you need to I can totally do all the things you listed, I mean, it’s only part of being a cadet. \n\t2. Aight man, but don’t be upset when, I mean if, I screw up. I’m gonna be totally fine. \n\t3. Test me? C’mon, Chief Flo, do you know how bad I am at tests?! I can’t do anything under pressure! *drops to knees* I can’t handle it!!!";
	interactions[7] = "Chief Flo: So how are the cases coming along? Are you handling them well? Do you think you’re able to keep working 'til the sun goes down?\n\n(Select a response. Try to look good.)\n\n\t1. Sure! I can handle it. I mean, it’s not like I had three panic attacks already but hey, I’m still here and alive (somewhat), so don’t worry! Everything’s gonna be fine and A-OK! \n\t2. A little pressure never hurt anyone, right? I’m doing just fine. I even ordered donuts for the whole station, all on me. \n\t3. Are you sure the sun isn’t already down? From my perspective everything’s very very dark, so, uh, am I ok?";
	interactions[8] = "Chief Flo: These past three days have been tough on you Jake, but at least you made it through them. \nChief Flo: How do you think you did, Jake?\n\n(Select a response. Try to look good.)\n\n\t1. I think I did ok, Chief Flo. I’m just happy to work in your department, even if I'm just a cadet. \n\t2. Me? I think I did amazing. I mean, I came into this police station and gave it a complete 180. Before me, this place was a bit sad, no offense, but now, this place is hustling and bustling. All thanks to me, of course. \n\t3. After these three days, I don’t know if I want to be a police officer anymore. Why are there so many bad things going around in this town?";
	
	//answer key
	answerBank[1][0] = true;
	answerBank[2][1] = true;
	answerBank[1][2] = true;
	answerBank[0][3] = true;
	answerBank[1][4] = true;
	answerBank[0][5] = true;
	answerBank[2][6] = true;
	answerBank[1][7] = true;
	answerBank[0][8] = true;

	//chief responses
	aftermath[0][0]= ("\nChief Flo: How dare you question me and make a lame joke with my name?! \nChief Flo: Do you not have a uniform? On your first day?! ");
	aftermath[1][0] = ("\nChief Flo: Oh my gosh, I thought you’d never ask. I’d like two boston creams, one without the cream, 1 glaze, but pick the one with a medium amount of glaze, and 1 chocolate with strawberry filling and rainbow sprinkles, and make sure the sprinkles are evenly distributed. \nChief Flo: Wow, I wish all our cadets were like you.");
	aftermath[2][0] = ("\nChief Flo: Jeez, you're a little clingy, aren't you?");

	aftermath[0][1] = ("Chief Flo: You sound like you’re in trouble. Are you causing more trouble in my city?! \nWe are ranked as the second safest city in this district. Don’t make us drop to third.");
	aftermath[1][1] = ("Chief Flo: Excuse me? Who doesn’t have time to talk to their chief? \nChief Flo: I expected a better attitude from you.");
	aftermath[2][1] = ("Chief Flo: Wow, you sound like you’re doing ok. Looks like you’re as promising as I thought. \nChief Flo: Keep up the good work, Jack. Uh, I mean, Jake.");

	aftermath[0][2] = ("Chief Flo: Since the beginning of the day, huh? \nChief Flo: Wow I see how much you’re enjoying this job then. \nChief Flo (aside): Bro? I’m his bro? I’m no one’s bro. Who am I?");
	aftermath[1][2] = ("Chief Flo: *tears in eyes* You remind me of when I was younger.\nChief Flo: Have a good night, Jake. I’ll get you a donut tomorrow.");
	aftermath[2][2] = ("Chief Flo: What the - He left already? Does he have issues? I’ll be watching him tomorrow...");

	aftermath[0][3] = ("Chief Flo: Wow, for a cadet you sure do show a lot of potential. \nChief Flo: ...I'm impressed.");
	aftermath[1][3] = ("Chief Flo: Uhh, just don’t screw up, Jake, we’re all counting on you here. \nChief Flo: We were only able to accept one cadet this year, so don’t be the one who makes everyone’s decision look bad. \nChief Flo: No pressure. ");
	aftermath[2][3] = ("Chief Flo: Jeez, get off your knees Jake. You don’t even know how I’m going to test you. \nChief Flo: Are you going to act this way when something bad happens on the field?");

	aftermath[0][4] = ("Chief Flo: Um...Should we get you to the hospital? ");
	aftermath[1][4] = ("Chief Flo: Wowwee, donuts for everyone? With your salary? Much appreciation.");
	aftermath[2][4] = ("Chief Flo: ...Jake? Are you, uh...mentally sound?");

	aftermath[0][5] = ("Chief Flo: You cleaned? No wonder why I can finally see my reflection in the floor.\nChief Flo: Thanks, cadet, I’ll make sure you’ll be rewarded for what you did. ");
	aftermath[1][5] = ("Chief Flo: You want to go home already? \nChief Flo: Grow some perseverance, cadet!");
	aftermath[2][5] = ("Chief Flo: You bet I will. \nChief Flo: In fact, I’ll make it even harder. You'd better prepare yourself.");

	aftermath[0][6] = ("Chief Flo: You can’t handle the pressure? \nChief Flo: You need all this extra stuff? Is your cruiser just filled with stress relaxation products?\nChief Flo: Do you even have time to solve crimes with all the teas you’re drinking?");
	aftermath[1][6] = ("Chief Flo: Do you only think that I eat donuts? Do you not see me working in the field like you? \nChief Flo: I’m more than just donuts, Jake. You'd better understand that. ");
	aftermath[2][6] = ("Chief Flo: Mixtape? For your cruiser?! I have one too! We should compare after your shift ends.");

	aftermath[0][7] = ("Chief Flo: You’re using stress products instead of solving crimes? Where are your priorities, Jake?");
	aftermath[1][7] = ("Chief Flo: Totally fine with me, as long as you stop by the station after your shift so we can celebrate your first days as a cadet. ");
	aftermath[2][7] = ("Chief Flo: You watch that cops show and not pay attention to your own job?\nChief Flo: And I don't need you to tell me how to do my job. Get back to work.");

	aftermath[0][8] = ("Chief Flo: *Getting teary* Wow Jake, that was the sweetest thing anyone has ever said to me in my whole life. Let me just give you a promotion right now. \nChief Flo: Do you want a promotion? Or a raise? How about both? ");
	aftermath[1][8] = ("Chief Flo: A complete 180? I think my station was completely fine without you and will continue to do fine without you.\nChief Flo: I don’t think you’re a good fit for our department. Please leave.");
	aftermath[2][8] = ("Chief Flo: To be honest, Jake, I don’t think you’re cut out to be a police officer either. It’s a lot of responsibility.\nChief Flo: But I can help you find a new job.");

    }

    public void rank(int difficulty, PriorityQueue crimes, Crime newCrime) {
	String prompter = "";
	int choice;

	prompter = "Here is the crime coming in: " + newCrime.toString() + "\nHere is your current ranking of your crimes: \n";
	prompter += CallCenter.crimes.toString();
	prompter += "\nHow would you like to rank this crime?";
	prompter += "\n(To rank something as first, enter 1. To rank something as second, enter 2. And so on...)";
	System.out.println(prompter);

	choice = Keyboard.readInt();
	if (choice < 1 || (difficulty == 1 && choice > 11)
	    || (difficulty == 2 && choice > 12)
	    || (difficulty == 3 && choice > 13)) {
	    prompter = "This is no time to be messing around, Jake. Don't make me call the chief.";
	    rank(difficulty, crimes, newCrime);
	}

	newCrime.setPriority(choice);
        crimes.add(newCrime);

    }

    public void increaseScore() {
	score += 100;
    }

    public static void interact(CallCenter currentLv, int numInteract) {
	String prompter = "";
	int choice;

	prompter = interactions[numInteract-1];
	System.out.println(prompter);

	choice = Keyboard.readInt();
	while (choice != 1 && choice != 2 && choice != 3) {
	    System.out.println("(I said to try to look good, not stand there like an idiot! Say something!)");
	    choice = Keyboard.readInt();
	}

	prompter = aftermath[choice-1][numInteract-1];
	System.out.println(prompter);
	
	if (answerBank[choice-1][numInteract-1]) {
	    int randomBenefit = (int)(Math.random()*2);
	    if (randomBenefit == 0) {
		currentLv.increaseTime(); //increases time limit by 30 seconds
		prompter = "\nYour time limit has increased by an hour! (real time: 30 seconds)";
		System.out.println(prompter);
	    }
	    else if (randomBenefit == 1) {
	        currentLv.crimes.peekMin().changeTimer(0.5);
		prompter = "\nYour next mission will only take half as much time!";
		System.out.println(prompter);
	    }
	}

	else {
	    int randomDetriment = (int)(Math.random()*2);
	    if (randomDetriment == 0) {
		currentLv.increaseTime(); //increases time limit by 30 seconds
		prompter = "\nThe chief is getting sick of you, so he wants you to go home earlier. Your time limit has decreased by an hour. (real time: 30 seconds)";
		System.out.println(prompter);
	    }
	    else if (randomDetriment == 1) {
		currentLv.crimes.peekMin().changeTimer(2.0);
		prompter = "\nYour next mission will take twice as much time. Have fun with that.";
		System.out.println(prompter);
	    }
	}
	proceed();
    }

    public static void proceed() {
	String s = "(Press ENTER to continue)";
	Scanner sc = new Scanner(System.in);
	System.out.println(s);
	sc.nextLine();
	System.out.print("\033[H\033[2J");
    }
    
}
