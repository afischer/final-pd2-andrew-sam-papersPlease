import java.io.*;
import java.util.*;

public class Driver {
	public static int currLevel = 1;
	
	public static void levelUp(){
		currLevel++;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Level l = new Level();
		
		Level1 l1 = new Level1();
		Level2 l2 = new Level2();
		
		System.out.println(currLevel); //HOLY BALLS FIX THIS
		
		if (currLevel == 1){
			l1.runLevel();
		}
		if (currLevel == 2){
			l2.runLevel();
		}

	}

}

