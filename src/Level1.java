import java.io.*;
import java.util.*;

public class Level1 extends Level {
	public void runLevel() throws IOException {
		RuleGui rGUI = new RuleGui();
		
		rGUI.setBulletin("Overwrite me, yo!");
	//	rGUI.ruleTxt = "<html>All documents must be current and legal. <br> Only allow Arstotzkan citizens through the checkpoint.";
		
		setLevel(3);  //AND WHY WON"T THIS WORK EITHER AUFOIDFODSFOIDSP
		
		while (inCount + outCount + detCount < 3){
			encounter();
		}
		
	}
}
