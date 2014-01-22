import java.io.*;
import java.util.*;

public class Level1 extends Level {

	public void runLevel() throws IOException {
		
		
		
		//Below this must be in EVERY LEVEL. You can put special parameters and text above (like announcements, whatever) if you want.
		setLevel(1);
		RuleGui rGUI = new RuleGui();
		
		//These methods overwrite the default crap in the 
		rGUI.setBulletin("<html><b>Arstotzka<br>Ministry of Admission<br><i>Official Bulletin</i></b><br><br>Inspector,<br><br>Welcome to your new position at the Arstotzkan border checkpoint. This is a proud day for your family-you now have a job!<br><br>Stamp passport ENTRY VISA after inspecting all documents. <br><br>Today, entry is restricted to <b> Arstotzkan citizens only. </b> Deny all foreigners. <br><br> These rules are subject to change day to day. Check the rules section for more. <br><br> <b> Glory to Arstotzka.</b> ");
		rGUI.setRules("<html>All entrants must have a passport. <br><br><hr><br> Only allow Arstotzkan citizens to enter today.");
		
		encounter();
		
	}
}
