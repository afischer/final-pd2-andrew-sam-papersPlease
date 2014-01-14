

import java.io.*;
import java.util.*;

public class Level {
	String state = "none";
	String answer = "";
	int inCount = 0; 		//How many you have allowed in
	int outCount = 0;		//How many you have kept out
	boolean validInpt = false;
	int thisLevel = 0;

	public void encounter() throws IOException{



		Scanner sc = new Scanner(System.in);
		PassMaker p = new PassMaker();
		BoothMaker b = new BoothMaker();

		String currPath = p.getClass().getClassLoader().getResource("").getPath();


		p.photoParser(currPath + "people/m1.txt"); //creates the passport of a person.
		System.out.println(b.makeBooth("00/00","00","0,0")); //makes and prints the booth, using passport image.
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
			if (state != "accepted" || state != "denied") { //Stops the options from being shown when state given
				//System.out.println(state);
				System.out.println("   Choose an option: \n     a. allow through \n     b. deny access \n     c. read rulebook");
				answer = sc.next();

				if (answer.equals("a")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> Go through. Glory to Arstoksa.");
					state = "accepted";
					validInpt = true;
				}
				else if(answer.equals("b")){
					try{Thread.sleep(500);}catch(InterruptedException ex){}
					System.out.println(">> These papers are not correct. Please leave.");
					state = "denied";
					validInpt = true;
				}
				else if(answer.equals("c")){
					String[] guiArgs = {};
					RuleGui.main(guiArgs);
				}

			}
		}

		if (state.equals("accepted")) {
			inCount++;
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("<< Thank you. God Bless.");
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("<< Glory to Arstoksa.");
			try{Thread.sleep(500);}catch(InterruptedException ex){}
			System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount);
		}
		if (state.equals("denied")) {
			outCount++;
			try{Thread.sleep(1000);}catch(InterruptedException ex){}
			System.out.println("<< Go to hell!.");
			try{Thread.sleep(500);}catch(InterruptedException ex){}
			System.out.println("Totals - Accepted:" + inCount + ", Denied:" + outCount);
		}
	}
}
