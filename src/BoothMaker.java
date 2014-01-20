import java.io.*;
import java.util.*;

public class BoothMaker{

    static String photo[] = new String [17];
    PassMaker p = new PassMaker();
    


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
    
        
    public String makeBooth(String date, String weight, String height){

	String booth = "";

	booth += " ___________________________________________ \n";
	booth += "|                                           |\n";

	//adding photo to booth printout
	booth += "|             ";
	booth += p.photo[0];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[1];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[2];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[3];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[4];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[5];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[6];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[7];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[8];
	booth += "               |\n";
	booth += "|             ";
	booth += p.photo[9];
	booth += "               |\n";


	booth += "|----------|------------------|-------------|\n";
	booth += "|          |                  |             |\n";
	booth += "|   DATE:  |Arstotzka Ministry|  WT/HEIGHT: |\n";
	booth += "| "+ date +" |  of  Admission   |  " + weight + "kg/" + height + "m  |\n";
	booth += "|__________|__________________|_____________|\n";
	booth += "\n";
	
	return booth;

    }
}
