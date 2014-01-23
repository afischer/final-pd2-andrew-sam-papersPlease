import java.io.*;
import java.util.*;

public class Driver {
	//static int currLevel = 1;
	
	
	
	public static void main(String[] args) throws IOException {
		Level l = new Level();
		
		Level1 l1 = new Level1();
		Level2 l2 = new Level2();
		
		
		if (l.getThisLevel() == 1){
			l1.runLevel();
		}
		else if (l.getThisLevel() == 2){
			l2.runLevel();
		}

	}

}

