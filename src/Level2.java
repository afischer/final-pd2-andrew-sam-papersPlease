import java.io.*;
import java.util.*;

public class Level2 extends Level {

	public void runLevel() throws IOException {
		
		
		
		//Below this must be in EVERY LEVEL. You can put special parameters and text above (like announcements, whatever) if you want.
		setLevel(2);
		RuleGui rGUI = new RuleGui();
		
		//These methods overwrite the default crap in the 
		rGUI.setBulletin("<html><b>Arstotzka<br>Ministry of Admission<br><i>Official Bulletin</i></b><br><br>Inspector,<br><br>From today, foreigners with a valid passport are permitted to enter.<br><br>Use your booth's pre-installed question protocol to inspect passports and other items. Check all passports carefully, and deny any entrant with inconsistant information. <br><br><hr><br><b> QUESTION MODE </b> If any information seems faulty, ask the entrant about the papers using the question protocol. It can be accessed after picking up their passport. <br<br><hr><br> <b>RULES, REGULATIONS</b> This post is bound by Ministry of Admission rules and regulations. Study the rulebook closely. Failing to follow these rules will result in citations and fines. <br><br> <b> Glory to Arstotzka.</b> ");
		rGUI.setRules("<html>All entrants must have a passport. <br><br><hr><br> Allow foreigners in with good passports. <br><br><hr><br> Be sure issuing city is valid.");
		
		encounter();
		
	}
}
