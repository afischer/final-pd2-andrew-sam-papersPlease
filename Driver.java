import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) throws IOException {
		Level l = new Level();

		int currLevel = 1;
		
		l.encounter();


	}

	public String getFilePath(){
		return this.getClass().getClassLoader().getResource("").getPath();
	}
}

