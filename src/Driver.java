import java.io.*;
import java.util.*;

public class Driver {
	int currLevel = 1;
	
	public String getLevel(){
		return "Level" + currLevel;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Level1 l = new Level1();
		
		
		l.runLevel();


	}


}

