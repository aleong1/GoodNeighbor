/**********************
 Jake class - represents player
*********************/

import java.util.Stack;
import cs1.Keyboard;
import java.util.Scanner;

public class Jake {

    public static int score;
    private static Stack<String> interactions;
    private static String[][] aftermath = new String[3][9];
    private static boolean[][] answerBank = new boolean[3][9];

    //constructor
    public Jake() {
	score = 0;
	interactions = new Stack<String>();

	//interactions are in reverse order
	
	//day 3
	interactions.push("These past three days have been tough on you Jake, but at least you made it through them. How do you think you did, Jake?");

	interactions.push("How’s this test gong for you, Jake. Is it going well, I hope you’re not slacking off because it’s almost the end of the day. I’ll be watching you.");
	interactions.push("The start of your third day, Jake. \nDid you wake up and smell the roses because get ready, you have a big day in front of you.\nThis will be the last day of me testing you out to see if you’re cut out for our department.\nIf you ask any of the other officers here, they’ll tell you that they went through this process as well.\nI’m a hard chief to get by, Jake.");
	//day 2
	interactions.push("Day 2 done, Jake. How was it? \nIn case you didn’t know I was testing you out to see if you were really for for our department. \nYou know how here in Progressive Police Department all we do is the best work law \nenforcement has ever seen. So here, you have to be at your best, always.");
	interactions.push("So how’s the test coming along. Are you handling it well? Do you think you’re able to do more till the sun goes down?");
	interactions.push("Day 2 on the job, Jake. \nI saw how you were doing yesterday and do you know what I \nthought, “Wow, I’m gonna test Jake a little more.” Don’t worry Jake, just keep doing what \nyou’ve been doing. All cadets go through this. Just be grateful that you don’t have to go on \nthe station donut and coffee run, or clean the cells, or get paper cuts from filing all the paperwork.");

	//day 1
	interactions.push("The end of a long day, huh. How was your first day, happy to leave the station and go home? I know I am. \n1. I’ve been waiting for this moment since I stepped into the station, thanks for being so considerate, bro.\n 2. I still have a little more paperwork to get done at my desk. But after that I’m heading home. Thanks for asking, night.\n3. Yeah bye! *runs out*");
	interactions.push("Hey, Jake, just checking in on you on your first day. \nHow are your cases going, I know you requested to work without a partner but is everything going swell, \nI know that a cadet with your personality has a lot of potential for many things to happen.\n 1. Yeah, umm, everything’s fine (haha). I surely did great on my first day, I mean I caught all the criminals and everything, I even got lunch.\n 2. Sorry sir, I can’t talk to you right now. I’m busy solving crimes and doing the work you’re not while you’re on the phone. Good day and goodbye.\n 3. Thanks for checking up sir, gotta say I’m doing ok. I’m used to working solo so it’s been swell, I’ve already solved a few crimes and now I’m working on another.");
	interactions.push("Welcome to the Progressive Police Station, Jake! \nBased off the application you submitted it seems like you’re a very promising cadet.\nI hope you’re not after my job (ha ha)! \nSince this is your first day, I’ll go easy on you, I’ll try to get the other officers to take on some cases to keep your workload a little light. \nBut don’t be a slacker, you’ve heard about me, Chief Flo, right? \nAnd you know how harsh I can be with my officers so give me a great first impression cadet. \nBut please change your outfit.  \n  1. What’s wrong with these khakis? They’re a versatile, thin, and FLO-y material am I right?\n 2. Of course, chief, I’ll go straight to work after I stop by We Are Donuts. Do you want me to get you some too?\n 3. Slacker? Me? HAA! I’ve never slacked on anything before in my life. I’m always there 24/7, whenever you call, if you call I’ll always be where you need me before you can put down the pager. I basically teleport.");


	//answer key
	answerBank[0][1] = true;
	answerBank[0][5] = true;
	answerBank[0][7] = true;
	answerBank[1][0] = true;
	answerBank[1][4] = true;
	answerBank[1][6] = true;
	answerBank[2][2] = true;
	answerBank[2][4] = true;
	answerBank[2][6] = true;

	//chief responses
	aftermath[0][0]= ("How dare you question me and make a lame joke with my name? \nDo you not have a uniform? On your first day?! ");
	aftermath[0][1] = ("Oh my gosh, I thought you’d never ask. I’d like two boston creams, \none without the cream, 1 glaze, but pick the one with a medium amount of glaze, \nand 1 chocolate with strawberry filling and rainbow sprinkles, make sure the sprinkles are evenly distributed. \nThanks, man, wow what a cadet you are.");
	aftermath[0][2] = ("Jeez, a little clingy are we?");
	aftermath[0][3] = ("You sound like you’re in trouble. Are you causing more trouble in my city?! \nWe are ranked #2 in safest city in this district, don’t put us at a 3.");
	aftermath[0][4] = ("Excuse me? Who doesn’t have time to talk to their chief?\nI mean I get that and you’re focused as a cadet but as a person? Wow, way to get shut down.");
	aftermath[0][5] = ("Wow, you sound like you’re doing ok. Looks like you’re as promising as I thought. \nKeep up the good work, Jack. I mean Jake.");
	aftermath[0][6] = ("Since the beginning of the day, huh. \nWow I see how much you’re enjoying this job then. Bro? I’m his bro? I’m no one’s bro. Who am I?");
	aftermath[0][7] = ("*Tears in eyes* You remind me of when I was younger.\nYou know what I’ll be seeing YOU tomorrow, bye Jake, I’ll get you a donut tomorrow.");
	aftermath[0][8] = ("Where’d Jake go? He left already? Does he have issues? I’ll be watching him tomorrow.");
	aftermath[1][0] = ("Wow, for only a cadet you do show a lot of potential. \nAnd you don’t mind doing those things? Wow then can you after your shift? ");
	aftermath[1][1] = ("Uhh, just don’t screw up, Jake, we’re all counting on you here. We were only \nable to accept one cadet this year so don’t be the one who makes everyone’s decision look bad. No pressure. ");
	aftermath[1][2] = ("Jeez, get off your knees Jake. You don’t even know how I’m going to test you. \nAre you going to act this way when something bad happens on the field?");
	aftermath[1][3] = ("Should we get you to the hospital? ");
	aftermath[1][4] = (" Wowwee, donuts for everyone? With your salary? Much appreciation.");
	aftermath[1][5] = ("Where are you? Are you on your route? Are you lost? Are you under ground? A different time zone?");
	aftermath[1][6] = ("You cleaned? No wonder why I can finally see my reflection in the floor.\nThanks, cadet, I’ll make sure you’ll be rewarded for what you did. ");
	aftermath[1][7] = ("You want to go home already? You want to get out of this station already?\nI thought you loved the station, at least, that’s what you wrote in your application. ");
	aftermath[1][8] = ("We will do the same thing tomorrow,\nin fact, I’ll make it a little harder so you better prepare yourself Jake.");
	aftermath[2][0] = ("You can’t handle the pressure with your own mind? \nYou need all this extra stuff? Is your cruiser just filled with stress relaxation products?\nDo you even have time to solve crimes with all the teas you’re drinking?");
	aftermath[2][1] = ("Do you only think that I eat donuts? Do you not see me working in the field like you? \nI’m more than just donuts, Jake, you better learn that. ");
	aftermath[2][2] = ("Mixtape? For your cruiser?! I have one too! We should compare after your shift ends.");
	aftermath[2][3] = ("You’re still using the stress products when you should be solving crimes? Where are your priorities, Jake?");
	aftermath[2][4] = ("Totally fine with me Jake, as long as you stop by the station after your shift so we can celebrate your first days as our cadet. ");
	aftermath[2][5] = ("You watch that cops show and not pay attention to your own job?\nI’m also not asking for your opinion about doing my job, Jake, now do yours. ");
	aftermath[2][6] = (" *Getting teary* Wow Jake, that was the sweetest thing anyone had ever said to me in my whole life, ever. Let me just give you a promotion right now. \nDo you want a promotion? Or a raise? How about both? ");
	aftermath[2][7] = ("A complete 180? I think my station was completely fine without you and will continue to do fine without you.\nI don’t think you’re a good fit for our department. Please leave.");
	aftermath[2][8] = ("To be honest, Jake, I don’t think you’re cut out to be a police officer either. It’s a lot of responsibility.\nBut I can help you find a new job.");

    }

    public void rank(int difficulty, PriorityQueue crimes, Crime newCrime) {
	String prompter = "";
	int choice;

	prompter = "Here is the crime coming in: " + newCrime.toString() + "\nHere is your current ranking of your crimes: \n";
	//prompter += CallCenter.crimes.toString();
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

    public static void interact(CallCenter currentLv) {
	String prompter = "";
	int choice;

	prompter = interactions.pop();
	System.out.println(prompter);

	choice = Keyboard.readInt();
	if (answerBank[currentLv.getDifficulty()-1][choice-1]) {
	    int randomBenefit = (int)(Math.random()*3);
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
	    else if (randomBenefit == 2) {
		//available officers increases. May implement later
		System.out.println("test");
	    }
	}

	else {
	    int randomDetriment = (int)(Math.random()*3);
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
	    else if (randomDetriment == 2) {
		//available officers decreases. May implement later
	    }
	}

	prompter = aftermath[currentLv.getDifficulty()-1][choice-1];
	System.out.println(prompter);
    }

    public static void main(String[] args) {
    }
}
