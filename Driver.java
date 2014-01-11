import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws IOException {
		

	String state = "none";
	String answer = "";
	
	Scanner sc = new Scanner(System.in);
	passmaker p = new passmaker();
	boothMaker b = new boothMaker();
	
	p.photoParser("people/m1.txt"); //creates the passport of a person.
	System.out.println(b.makeBooth("00/00","00","0,0")); //makes and prints the booth, using passport img.
	try{Thread.sleep(1000);}catch(InterruptedException ex){}


	System.out.println(">> Papers, please.");
	
	try{Thread.sleep(1000);}catch(InterruptedException ex){}
	System.out.println("<< Here they are, sir.");
	try{Thread.sleep(1000);}catch(InterruptedException ex){}
	System.out.println("   Choose an option: \n     a. take papers \n     b. deny access");
        answer = sc.next();
	

	if (answer.equals("a")){
	    System.out.println("   Papers picked up.");
	    try{Thread.sleep(1000);}catch(InterruptedException ex){}
	    System.out.println("<< Everything should be in order. I'm visiting friends.");
	    String[] guiArgs = {};
	    passGui.main(guiArgs);
	}
	else if(answer.equals("b")){
	    System.out.println(">> These papers are not correct.");
	    state = "denied";
	}
	else{
	    System.out.println("WRONG BUTTON."); //we have to put in a catch if they don't put in an int.
	}


		
	System.out.println("   Choose an option: \n     a. allow through \n     b. deny access \n     c. read rulebook");
	answer = sc.next();

	if (answer.equals("a")){
	    try{Thread.sleep(1000);}catch(InterruptedException ex){}
	    System.out.println(">> Go through. Glory to Arstoksa.");
	    state = "accepted";
	}
	else if(answer.equals("b")){
	    try{Thread.sleep(1000);}catch(InterruptedException ex){}
	    System.out.println(">> These papers are not correct. Please leave.");
	    state = "denied";
	}
	else if(answer.equals("c")){
	    String[] guiArgs = {};
	    ruleGui.main(guiArgs);
	}
	else{
	    System.out.println("WRONG BUTTON."); //we have to put in a catch if they don't put in an int.
	}

    }
    
    public String getFilePath(){
    	return this.getClass().getClassLoader().getResource("").getPath();
    }
}
