import java.io.*;
import java.util.*;




public class PassMaker{

    String fname = "";
    String lname = "";     // Eventually we will need to
    String dob = "";       // change these all to whatever = Character.whatever
    String sex = "";       // but for now, I'll leave them blank
    String iss = "";
    String exp = "";
    String serial = "";
    static String photo[] = new String[17];
    private ArrayList<String> wordList;



    public void photoParser(String filename) throws IOException {
    	File f = new File(filename);
    	try {
    		Scanner sc = new Scanner(f);
    		int count = 0;
    		while (sc.hasNext()) {
    			//System.out.println(count);
    			photo[count] = sc.nextLine();
    			//System.out.println(photo[count]);
    			count++;
    		}	
    	} 
    	catch (FileNotFoundException e) {
    		System.out.println("Error: Face file not found");
    		System.exit(0);
    	}
    }

    
    
    public String make(String fname, String lname, String dob, String sex, String iss, String exp, String serial){

	String passport = "";
 
	//	toString(photoMaker("f1.txt"));
	
	//Top part of the pasport. Note that all backslashes need a backslash before it.
	passport += "<html><pre>\n";
	passport += "  ____________________________________   ___________________________________         \n";
	passport += " /|                                   \\ /                                   |\\     \n";
 	passport += "|||        OFFICIAL DOCUMENT OF        :            ENTRY VISAS             |||      \n";
 	passport += "|||        __   _____ __     __        :                                    |||      \n";
	passport += "||| ~~ /\\ |__)|(_  | /  \\|_/(_  /\\ ~~  :                                    |||   \n";
	passport += "||| ~~/--\\| \\ |__) | \\__/| \\__)/--\\~~  :                                    ||| \n";
 	passport += "|||                                    :                                    |||      \n";
 	passport += "|||                                    :                                    |||      \n";
	passport += "|||                                    :      - - - - - - - - - - - - -     |||      \n";
	passport += "|||  NAME: ";

	// adding in the name to the passport
	String name = lname.toUpperCase() + ", " + fname.toUpperCase();
	passport += name;
	passport += fillAfter(name,28);


	//Pictures HAVE NOT been implemented yet - maybe if we decide this is our actual project...


	// Continuing with passport ascii art
	passport += ":     |                         |    |||\n";
	passport += "||| .---------------.                  :                                    |||\n";
	passport += "||| |";
	passport +=	this.photo[0];	
	passport += "|                  :     |                         |    |||\n";
	passport += "||| |";
	passport += this.photo[1];
	passport += "|  DOB: "; //before dob
	passport += dob;
	passport += fillAfter(dob, 11);
	passport += ":                                    |||\n"; //after dob
	passport += "||| |";
	passport += this.photo[2];
	passport += "|                  :     |                         |    |||\n";
	passport += "||| |";
	passport += this.photo[3];
	passport += "|  SEX: "; //before sex
	passport += sex.toUpperCase();
	passport += fillAfter(sex, 11);
	passport += ":      - - - - - - - - - - - - -     |||\n"; //after sex (hehe)
	passport += "||| |";
	passport += this.photo[4];
	passport += "|                  :                                    |||\n";
	passport += "||| |";
	passport += this.photo[5];
	passport += "|  ISS: "; //before issuing city
	passport += iss.toUpperCase();
	passport += fillAfter(iss, 11);
	passport += ":            Stamp Above             |||\n"; //after issuing city
	passport += "||| |";
	passport += this.photo[6];
	passport += "|                  :                                    |||\n";
	passport +="||| |";
	passport += this.photo[7];
	passport += "|  EXP: "; //before expiraton date
	passport += exp;
	passport += fillAfter(exp, 11);
	passport += ":                                    |||\n"; //after expirtion date
	passport += "||| |";
	passport += this.photo[8];
	passport += "|                  :                                    |||\n";
	passport +="||| |";
	passport += this.photo[9];
	passport += "|                  :                                    |||\n";
	passport +="||| '---------------'                  :                                    |||\n";
	passport +="||| "; //before serial number
	passport += serial;
	passport += fillAfter(serial,35);
	passport +=":                                    |||\n"; //after serial number
	passport +="|||___________________________________ : ___________________________________|||\n";
	passport +="|/====================================\\:/====================================\\|\n";
	passport +="'------------------------------------~___~------------------------------------'";
	
	//System.out.println(this.getClass().getClassLoader().getResource("").getPath() + "people/m1.txt");
	

	// FIN - The return statement
	return passport;       
    }

   
    //refactored out this for cleaner code - just fills in whitespace.
    private String fillAfter(String data,int len){
        String filler = "";
	
	for (int i=0; i<len-data.length(); i++) { //adding whitespace to fill ascii passport
	    filler += " ";
	}
	
	return filler;
    }
    
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

    
    public String getName(String sex){
    	if (sex.equals("Female")){
    		return getRandLine(this.getClass().getClassLoader().getResource("").getPath() /*workingdir*/ + "fNames.txt");
    	}
    	else if (sex.equals("Male")){
    		return getRandLine(this.getClass().getClassLoader().getResource("").getPath() + "mNames.txt");
    	}
    	else {return "error.";}
    }
    
    public String getLName(){
    	return getRandLine(this.getClass().getClassLoader().getResource("").getPath() + "lNames.txt");
    }

    public String getDOB(){
	 int randDay = (int)(30 * Math.random());
	 int randMon = (int)(12 * Math.random());
	 int randYr = (int)(1920 + (25 * Math.random())); //1920 to 1965 being born
	 
	 String d = randDay + "";
	 String m = randMon + "";
	 String y = randYr + "";
	 
	 return d + "/" + m + "/" + y;
    }
	 
    public String getExp(){
	int randDay = (int)(30 * Math.random());
	int randMon = (int)(12 * Math.random());
	int randYr = (int)(1980 + (5 * Math.random())); //expires between 1980 and 1985
	                                                //so some passports will be void
	String d = randDay + "";
	String m = randMon + "";
	String y = randYr + "";
					
	return d + "/" + m + "/" + y;
    }
    
    public String getTerritory(){
        return getRandLine(this.getClass().getClassLoader().getResource("").getPath() + "territories.txt");
    }

    public String getSerial(){
	return "" + (int)(1000+(9999 * Math.random())) + "-" + (int)(1000+(9999 * Math.random())) + "-" +(int)(1000+(9999 * Math.random())) + "-" +(int)(1000+(9999 * Math.random()));
    }

}
