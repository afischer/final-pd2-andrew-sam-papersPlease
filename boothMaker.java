import java.io.*;
import java.util.*;

public class boothMaker{

    static String photo[] = new String [17];
    private ArrayList<String> wordList;
    String date = "00/00";
    String wt = "00";
    String ht = "0.0";
    passmaker p = new passmaker();

    //     public void photoParser(String filename) throws IOException {
    // 	File f = new File(filename);
    // 	try {
    //		Scanner sc = new Scanner(f);
    // 		int count = 0;
    // 		while (sc.hasNext()) {
    // 			//System.out.println(count);
    // 			photo[count] = sc.nextLine();
    // 			//System.out.println(photo[count]);
    // 			count++;
    // 		}	
    // 	} 
    // 	catch (FileNotFoundException e) {
    // 		System.out.println("Error: Face file not found");
    // 		System.exit(0);
    // 	}
    // }
    
        
    public String makeBooth(String Date, String weight, String height){

	String booth = "";

	booth += "<html><pre>\n";
	booth += " __________________________________________ \n";
	booth += "|                                          |\n";

	//adding photo to booth printout
	booth += "|             ";
	booth += p.photo[0];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[1];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[2];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[3];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[4];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[5];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[6];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[7];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[8];
	booth += "              |\n";
	booth += "|             ";
	booth += p.photo[9];
	booth += "              |\n";


	booth += "|------------------------------------------|\n";
	booth += "|          |                 |             |\n";
	booth += "|   DATE:  |    TYPE R FOR   |  WT/HEIGHT: |\n";
	booth += "|   "+ date +"  |     RULEBOOK    |  " + wt + "kg/" + ht + "m  |\n";
	booth += "|__________________________________________|\n";
	booth += "\n";
	
	return booth;

    }
}
