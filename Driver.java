import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) throws IOException {
		
    String state = "none";
	
    Scanner sc = new Scanner(System.in);
	passmaker p = new passmaker();
	boothMaker b = new boothMaker();
	
	p.photoParser("m1.txt");
	System.out.println(b.makeBooth("00/00","00","0,0"));

	System.out.println(">> Papers, please.");
	
	try{Thread.sleep(1000);}catch(InterruptedException ex){}
	System.out.println("<< Here they are, sir.");
	try{Thread.sleep(1000);}catch(InterruptedException ex){}
	System.out.println("   Choose an option: \n     a. take papers \n     b. deny access");
	String answer = sc.next();
	
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
	

	
	System.out.println("Reached end of program. Terminating.");
	
	
	//System.out.println(p.make("John", "Doe", "08/19/44", "male", "impor","11/22/83" , "1832-ASDE-DFSD-EF"));
	//System.out.println(p.make("Janey", "Doe", "3-5-55","female","latvia","6.12.93","IFSD-4328-UASD-3289"));
	
	

    }
    
    public String getFilePath(){
    	return this.getClass().getClassLoader().getResource("").getPath();
    }
}
