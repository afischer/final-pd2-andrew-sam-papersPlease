import java.io.*;
import java.util.*;

public class Level1 extends Level {
	public void runLevel() throws IOException {
		RuleGui rGUI = new RuleGui();
		
	//	rGUI.bulletinTxt = "<html> Hello inspector. Welcome to your first day. <br><br> Congratualtions on winning the 1982 Labor Lottery. I'm sure you will find it an honor to work for your country. <br> <br> This book will be your guide through your new job.";
	//	rGUI.ruleTxt = "<html>All documents must be current and legal. <br> Only allow Arstotzkan citizens through the checkpoint.";
		
		Level.btext = "WHY WONT YOU OVERRIDE THE FRICKIN TEXT AUGHHHHHHH!";
		thisLevel = 2;  //AND WHY WON"T THIS WORK EITHER AUFOIDFODSFOIDSP
		
		while (inCount + outCount + detCount < 3){
			encounter();
		}
		
	}
}
