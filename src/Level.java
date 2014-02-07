import java.io.*;
import java.util.*;

public class Level {
	String state = "none";
	String respond = "none";
	String rule = "none";
	String play = "yes";
	String answer = "";
	int inCount = 0; 		//How many you have allowed in
	int outCount = 0;		//How many you have kept out
	int detCount = 0;		//How many you have detained
	int citationCount = 0;
	public int thisLevel = 1;
	String[] guiArgs = {};
	int credits = 0;

	int numEncounters = 12;  // THIS IS THE REALLY IMPORTANT ONE!!! //

	//Family & home Stuff
	String wifeStatus = "healthy";
	String sonStatus = "healthy";
	String molStatus = "healthy";
	int daysWOFood = 0;
	int daysWOHeat = 0;
	int wifeSick = 0;
	int sonSick = 0;
	int molSick = 0;


	public int getThisLevel(){
		return thisLevel;
	}

	public static String currSex = "";
	private ArrayList<String> wordList;

	public void setLevel(int levelNum){
		thisLevel = levelNum;
	}

	//Main encounter protocol.
	public void encounter() throws IOException{

		//String[] guiArgs = {};
		//RuleGui.main(guiArgs);

		while(play != "no"){ //loop for multiple peoples
			rule = "none";
			Scanner sc = new Scanner(System.in);
			PassMaker p = new PassMaker();
			BoothMaker b = new BoothMaker();

			String currPath = p.getClass().getClassLoader().getResource("").getPath();

			p.photoParser(currPath + getRandFace()); //creates the passport of a person.
			System.out.println(b.makeBooth(todaysDate(),"22","4.2")); //makes and prints the booth, using passport image.
			try{Thread.sleep(1000);}catch(InterruptedException ex){}

			System.out.println("Day " + thisLevel);
			System.out.println(">> Papers, please.");

			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("<< Here they are, sir.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}

			while(respond == "none") {
				if (respond != "yes" || respond != "no") {
					System.out.println("   Choose an option: \n     a. examine papers \n     b. deny access");
					answer = sc.next();

					if (answer.equals("a")){
						System.out.println("   Papers picked up.");
						try{Thread.sleep(1000);}catch(InterruptedException ex){}
						System.out.println("<< Everything should be in order. I'm visiting friends.");
						PassGui.main(guiArgs);
						respond = "yes";
					}
					else if(answer.equals("b")){
						System.out.println(">> These papers are not correct.");
						state = "denied";
						respond = "no";
					}
					else respond = "none";
				}
			}   

			//catch added
			while (state == "none"){ //makes sure that when state is none, options are always shown
				if (state != "accepted" || state != "denied" || state != "questioning") { //Stops the options from being shown when state given
					//System.out.println(state);
					//System.out.println(p.getValid);
					System.out.println("   Choose an option: \n     a. allow through \n     b. deny access \n     c. interrogate entrant \n     d. read rulebook");
					answer = sc.next();

					if (answer.equals("a")){
						try{Thread.sleep(500);}catch(InterruptedException ex){}
						System.out.println(">> Go through. Cause no trouble. Glory to Arstotzka.");
						state = "accepted";
					}
					else if(answer.equals("b")){
						try{Thread.sleep(500);}catch(InterruptedException ex){}
						System.out.println(">> These papers are not correct. Please leave.");
						state = "denied";
					}
					else if(answer.equals("c")){
						state = "questioning";
						questionProtocol(); //Begins questioning
					}
					else if(answer.equals("d")){
						RuleGui.main(guiArgs);
					}
				}
			}

			if (state.equals("accepted")) {
				inCount++;
				try{Thread.sleep(1000);}catch(InterruptedException ex){}
				System.out.println("<< " + getRandLine(getFilePath() + "dialogue/thanks.txt"));
				try{Thread.sleep(1000);}catch(InterruptedException ex){}
				System.out.println("<< Glory to Arstotzka.");
				try{Thread.sleep(500);}catch(InterruptedException ex){}
				//System.out.println(p.getValid());
				
				if (p.getValid() == false) {
					citationCount++;
					System.out.println("   PRINTING: MOA CITATION - PASSPORT INVALID");
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					
					
				}
				System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount + ", Detained:" + detCount + ", Citations:" + citationCount);
				answer = "none";
				respond = "none";
				state = "none";
				if (inCount+outCount+detCount >= numEncounters) {//CHANGE NUMENCOUNTERS TO SHORTEN DAYSS
					endOfDayProtocol();
					continueGame();
					thisLevel++;
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("It is now Day " + thisLevel);
					Driver.levelUp();
					break;
					//try{Thread.sleep(1000);}catch(InterruptedException ex){}
				}				

			}
			if (state.equals("denied")) {
				outCount++;
				try{Thread.sleep(1000);}catch(InterruptedException ex){}
				System.out.println("<< " + getRandLine(getFilePath() + "dialogue/nothanks.txt"));
				try{Thread.sleep(500);}catch(InterruptedException ex){}
				if (p.getValid() == true) { //fixed.
					citationCount++;
					System.out.println("   PRINTING: MOA CITATION - CREDENTIALS VALID, UNNEEDED DENIAL");
					try{Thread.sleep(500);}catch(InterruptedException ex){}
				}
				System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount + ", Detained:" + detCount + ", Citations:" + citationCount);
				answer = "none";
				respond = "none";
				state = "none";
				if (inCount+outCount+detCount >= numEncounters) { //CHANGE NUMENCOUNTERS TO SHORTEN DAYSS
					endOfDayProtocol();
					continueGame();
					thisLevel++;
					System.out.println("It is now Day " + thisLevel);
				}				

			}
			if (state.equals("detained")) {
				detCount++;
				try{Thread.sleep(1000);}catch(InterruptedException ex){}
				System.out.println("<< " + getRandLine(getFilePath() + "dialogue/nothanks.txt"));
				try{Thread.sleep(500);}catch(InterruptedException ex){}
				System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount + ", Detained:" + detCount + ", Citations:" + citationCount);  
				answer = "none";
				respond = "none";
				state = "none";
				if (inCount+outCount+detCount >= numEncounters) { //CHANGE NUMENCOUNTERS TO SHORTEN DAYSS
					endOfDayProtocol();
					continueGame();
					thisLevel++;
					System.out.println("It is now Day " + thisLevel);
				}

			}

		}
	}


	public void questionProtocol() throws IOException {

		String answer = "";
		Scanner sc = new Scanner(System.in);


		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("INITIATING: MOA Interrogation Protocol.");
		try{Thread.sleep(1000);}catch(InterruptedException ex){}


		while (state == "questioning"){
			if (state != "accepted" || state != "denied" || state != "detained"){
				//System.out.println(state);

				System.out.println("   Choose an option: \n   Note all options may not be applicable. \n     a. question expired document \n     b. question photo \n     c. question issuing city \n     d. question sex \n     e. missing documents \n     1. read rulebook \n     2. detain entrant \n     3. allow entrance \n     4. deny entrance \n");
				answer = sc.next();

				if (answer.equals("a")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> This document is expired.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("<< Oh? Must be misprint.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}

				}
				else if(answer.equals("b")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> This does not look much like you.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("<< What do you want? It is me.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}

				}
				else if(answer.equals("c")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> This issuing city is invalid.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("<< Huh? Must be typo.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}

				}
				else if(answer.equals("d")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> You are a " + currSex + "?");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("<< Excuse me? As the paper says.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}

				}
				else if(answer.equals("e")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> You are missing some documents.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("<< What are you talking about? This is what I was given.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}

				}
				else if(answer.equals("1")){ //read rulebook
					String[] guiArgs = {};
					RuleGui.main(guiArgs);
				}
				else if(answer.equals("2")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> Wait here.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					System.out.println("<< What?? What is this? What is going on?");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					state = "detained";
					break; //returns to the main encounter method
				}
				else if (answer.equals("3")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> Go through. Cause no trouble. Glory to Arstoksa.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					state = "accepted";
					break; //returns to the main encounter method
				}
				else if(answer.equals("4")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> You can not go through. Please leave.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					state = "denied";
					break; //returns to the main encounter method
				}

			}
		}
	}


	public void endOfDayProtocol() throws IOException{
		String answer = "";
		state = "";
		boolean gotHeat = false;
		boolean gotFood = false;
		Scanner sc = new Scanner(System.in);


		if (daysWOHeat >= 2){
			wifeStatus = "cold";
		}
		if (daysWOFood >= 2){
			wifeStatus = "hungry";
		}

		if (daysWOFood >= 2 && daysWOHeat >= 1){
			wifeStatus = "sick";
			wifeSick++;
		}
		if (wifeSick == 2){
			wifeStatus = "dead";
			System.out.println("Your Family has died.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("Arstoksa requires workers to support a family.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("You are to be replaced by someone with a family.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("You are left on the streets.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("Glory to Arstoksa!");
			System.exit(0);
		}

		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("END OF DAY " + thisLevel + ":");
		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("Your daily credit check is handed to you on your way out.");
		
		//counts up cash
		credits += (inCount*5)+(outCount*5)+(detCount*10);
		if (citationCount > 2) { //for fines
			credits -= ((citationCount-2)*5);
			System.out.println("You have been fined " + ((citationCount-2)*5) + " credits for your citations.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
		}
		
		
		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("Bank of Arstoksa Stmt: Balance: " + credits + " credits.");
		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("Your family is " + wifeStatus);
		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		if (credits < 15){
			System.out.println("Bank of Arstoksa ALERT: Balance insufficent for rent.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("Arstoksa has no patience for debtors.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("You are placed in debtors prison, and sentenced to forced labor.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("The safety of your family is uncertain.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("Glory to Arstoksa!");
			System.exit(0);
		}
		System.out.println("Bank of Arstoksa Stmt: 15 Credits removed for mandated rent.");
		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		credits -= 15;
		System.out.println("Bank of Arstoksa Stmt: Balance: " + credits + " credits.");
		try{Thread.sleep(1000);}catch(InterruptedException ex){}

		while (state != "done"){
			if (credits != 0) {
				System.out.println("   Choose an option:\n     a. pay for heat - 5 credits \n     b. pay for food - 5 credits\n     c. pay for medicine - 5 credits\n     d. go to sleep");
				answer = sc.next();

				if (answer.equals("a")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println("-- Heating Bill Paid.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					gotHeat = true;
					daysWOHeat = 0;
					credits -= 5;
					System.out.println("Bank of Arstoksa Stmt: Balance: " + credits + " credits.");


				}
				else if(answer.equals("b")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println("-- Rations Purchased.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					gotFood = true;
					daysWOFood = 0;
					credits -= 5;
					System.out.println("Bank of Arstoksa Stmt: Balance: " + credits + " credits.");

				}
				else if(answer.equals("c")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println("-- Medicine purchased.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					credits -= 5;
					System.out.println("Bank of Arstoksa Stmt: Balance: " + credits + " credits.");

				}
				else if(answer.equals("d")){

					if (gotHeat = false) {
						daysWOHeat++;
					}
					if (gotFood = false) {
						daysWOFood++;
					}

					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println("After a night of rest, you return to your glorious workplace.");
					try{Thread.sleep(1000);}catch(InterruptedException ex){}
					state = "done";
					break;

				}
			}
			else {
				System.out.println("No remaining credits.");
				break;
				}
		}
	}


	public void continueGame() throws IOException{
		Scanner sc = new Scanner(System.in);
		String answer = "";

		System.out.println("\n   Would you like to play for another day? \n    a. yes \n    b. no");
		answer = sc.next();
		if (answer.equals("b")){
			System.out.println("   Thank you for playing. Glory to Arstotzka. Goodbye.");
			play = "no";
			System.exit(0);
		}
		else if (answer.equals("a")) {
			inCount = 0;
			outCount = 0;
			detCount = 0;
			citationCount = 0; 
			Driver.levelUp();
			System.out.println("   A new rule may be added. Please examine the Rule Book before continuing..");
			/*
				while(rule == "none") {
					if(rule != "yes") {
						answer = sc.next();
						if (answer.equals("R")) {

							RuleGui.main(guiArgs);
							rule = "yes";
							play = "yes";
							respond = "none";
							state = "none";
							answer = "";
						}
					}
					else rule = "none";
				}
			}
			else {
			 */
			//System.out.println("  Let us continue.");
			play = "yes";
			respond = "none";
			state = "none";
			answer = "";
		}
	}







	//AUXILIARY FUNCTIONS//


	public String getRandLine(String filename){
		wordList = new ArrayList<String>();
		try {
			File f = new File(filename);
			Scanner sc = new Scanner(f);
			while (sc.hasNext()) {
				String s = sc.nextLine();
				wordList.add(s);
			}	

			int rand = (int)(wordList.size() * Math.random());

			return wordList.get(rand);

		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(0);
			return "error.";
		}
	}

	public String getFilePath(){
		return this.getClass().getClassLoader().getResource("").getPath();
	}

	//Decides sex, then gives a random face.
	public String getRandFace(){
		if ((int)(1 + (2 * Math.random())) == 1) {currSex = "male";} else {currSex = "female";}
		if (currSex.equals("male")){
			return "people/m" + (int)(1 + (11 * Math.random())) + ".txt";
		}
		else {
			return "people/f" + (int)(1 + (8 * Math.random())) + ".txt";
		}
	}

	public String todaysDate(){
		return "03/"+ (int)(10 + thisLevel) + "/82";
	}

	//END AUXILIARY FUNCTIONS//

}
