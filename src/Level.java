

import java.io.*;
import java.util.*;

public class Level {
	String state = "none";
	String answer = "";
	int inCount = 0; 		//How many you have allowed in
	int outCount = 0;		//How many you have kept out
	int detCount = 0;		//How many you have detained
	int citationCount = 0;
	static int thisLevel = 0;
	
    
    public static String currSex = "";
    private ArrayList<String> wordList;

    	
    //Main encounter protocol.
	public void encounter() throws IOException{

		System.out.println("Day "+thisLevel);
		Scanner sc = new Scanner(System.in);
		PassMaker p = new PassMaker();
		BoothMaker b = new BoothMaker();

		String currPath = p.getClass().getClassLoader().getResource("").getPath();


		p.photoParser(currPath + getRandFace()); //creates the passport of a person.
		System.out.println(b.makeBooth(todaysDate(),"22","4.2")); //makes and prints the booth, using passport image.
		try{Thread.sleep(1000);}catch(InterruptedException ex){}


		System.out.println(">> Papers, please.");

		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("<< Here they are, sir.");
		try{Thread.sleep(1000);}catch(InterruptedException ex){}
		System.out.println("   Choose an option: \n     a. take papers \n     b. deny access");
		answer = sc.next();

		//ADD CATCH FOR THIS FOR WRONG KEYS
		if (answer.equals("a")){
			System.out.println("   Papers picked up.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("<< Everything should be in order. I'm visiting friends.");
			String[] guiArgs = {};
			PassGui.main(guiArgs);
		}
		else if(answer.equals("b")){
			System.out.println(">> These papers are not correct.");
			state = "denied";
		}


		//catch added
		while (state == "none"){ //makes sure that when state is none, options are always shown
			if (state != "accepted" || state != "denied" || state != "questioning") { //Stops the options from being shown when state given
				//System.out.println(state);
				System.out.println("   Choose an option: \n     a. allow through \n     b. deny access \n     c. interrogate entrant \n     d. read rulebook");
				answer = sc.next();

				if (answer.equals("a")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> Go through. Cause no trouble. Glory to Arstoksa.");
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
					String[] guiArgs = {};
					RuleGui.main(guiArgs);
				}
			}
		}

		if (state.equals("accepted")) {
		    inCount++;
		    try{Thread.sleep(1000);}catch(InterruptedException ex){}
		    System.out.println("<< " + getRandLine(getFilePath() + "dialogue/thanks.txt"));
		    try{Thread.sleep(1000);}catch(InterruptedException ex){}
		    System.out.println("<< Glory to Arstoksa.");
		    try{Thread.sleep(500);}catch(InterruptedException ex){}
		    if (p.valid = false) {
		    	citationCount++;
			    System.out.println("   PRINTING: MOA CITATION - PASSPORT INVALID");
			    try{Thread.sleep(500);}catch(InterruptedException ex){}
		    }
		    System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount + ", Detained:" + detCount + ", Citations:" + citationCount);
		}
		if (state.equals("denied")) {
		    outCount++;
		    try{Thread.sleep(1000);}catch(InterruptedException ex){}
		    System.out.println("<< " + getRandLine(getFilePath() + "dialogue/nothanks.txt"));
		    try{Thread.sleep(500);}catch(InterruptedException ex){}
		    if (p.valid = true) {
		    	citationCount++;
			    System.out.println("   PRINTING: MOA CITATION - CREDENTIALS VALID, UNNEEDED DENIAL");
			    try{Thread.sleep(500);}catch(InterruptedException ex){}
		    }
		    System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount + ", Detained:" + detCount + ", Citations:" + citationCount);
		}
		if (state.equals("detained")) {
		    detCount++;
		    try{Thread.sleep(1000);}catch(InterruptedException ex){}
		    System.out.println("<< " + getRandLine(getFilePath() + "dialogue/nothanks.txt"));
		    try{Thread.sleep(500);}catch(InterruptedException ex){}
		    System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount + ", Detained:" + detCount + ", Citations:" + citationCount);  
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
					System.out.println(">> This issuing city is invalid. It does not exist.");
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
