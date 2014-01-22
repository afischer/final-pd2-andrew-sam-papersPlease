//Special thanks to some serious help from some very friendly people on StackOverflow

//THIS CODE IS MESSY AND NEEDS TO BE SERIOUSLY CLEANED UP.

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class RuleGui extends javax.swing.JFrame {

    public RuleGui() {
	initComponents();
    }

    public static String bulletinTxt = "<html> Hello inspector. Welcome. <br><br> Congratualtions on winning the 1982 Labor Lottery. I'm sure you will find it an honor to work for your country. <br> <br> This book will be your guide through your new job. <br><br> Please click the Rules tab in order to view your responsibilities.";
    public String ruleTxt = "<html> Remember, current and valid passports should never be expired, and should always match the holder's face, gender, etc. <br><br> Rule established Day 1: Only allow Arstotzkan citizens with current and valid passports through the checkpoint. <br><br> Rule established Day 2: Allow foreigners with current and valid passports through the checkpoint as well. <br><br> Rule established Day 3: Antegria, Republica, & Kolechia are sending in spies to Arstotzka. Immediately interrogate and detain any citizens of those territories.";
    public String docTxt = "<html> <b> VALID ARSTOKSAN DOCUMENTS: </b><br><br><br> <i> Passport: </i> The passport is a simple document that is required for all entrants. Foregeries are rampant - keep a keen eye.";
    public String copyTxt = "";
    
    
    public void setBulletin(String newTxt){
    	bulletinTxt = newTxt;
    }
 
	

    private void initComponents() {

	tabbedPane = new JTabbedPane();
	bulletinPane = new JLayeredPane();
	bulletinText = new JLabel();
	rulePane = new JPanel();
	ruleText = new JLabel();
	mapPane = new JPanel();
	mapImage = new JLabel();
	documentsPane = new JPanel();
	documentText = new JLabel();
	copyrightPane = new JPanel();
	copyrightText = new JLabel();
	setDefaultCloseOperation(EXIT_ON_CLOSE);


	//bulletinTxt = "Hello inspector. Welcome to your first day.";
	//ruleTxt = "This is where your rules will go.";
	//docTxt = "Come here to learn about the various documents you will encounter.";

	copyTxt = "<html><center><b>Copyright MOA.</b> <br> Glory to Arstotzka. <br><br><br> Arstokzan Ministry of Admission <br> Rules & Regulations for Inspectors <br><br> =========== <br><br> 1982-1983 Edition <br> IBSN: 978-0-452-28423-4 <br><br> DO NOT DISTRUBUTE <br> UNDER SEVERE PENALTY <br><br> ============ <br><br><i> Original Papers Please game By <br> Lucas Pope <br> dukope.com</i>";
	copyrightText.setHorizontalTextPosition(JLabel.CENTER);
	copyrightText.setVerticalTextPosition(JLabel.CENTER);
		
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	this.setAlwaysOnTop(true);

	//Meh fonts. Forget it for now. 
	//	File font_file = new File("BMmini.TTF");
	//	Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);


	bulletinText.setText(bulletinTxt);

	GroupLayout bulletinPaneLayout = new GroupLayout(bulletinPane); //wow this seems so redundant...
	bulletinPane.setLayout(bulletinPaneLayout);
	bulletinPaneLayout.setHorizontalGroup(
					      bulletinPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					      .addGroup(bulletinPaneLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(bulletinText, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
							.addContainerGap())
					      );
	bulletinPaneLayout.setVerticalGroup(
					    bulletinPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					    .addGroup(bulletinPaneLayout.createSequentialGroup()
						      .addContainerGap()
						      .addComponent(bulletinText, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						      .addContainerGap())
					    );
	bulletinPane.setLayer(bulletinText, JLayeredPane.DEFAULT_LAYER);

	tabbedPane.addTab("Bulletin", bulletinPane);

	ruleText.setText(ruleTxt);

	GroupLayout rulePaneLayout = new GroupLayout(rulePane);
	rulePane.setLayout(rulePaneLayout);
	rulePaneLayout.setHorizontalGroup(
					  rulePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					  .addGroup(rulePaneLayout.createSequentialGroup()
						    .addContainerGap()
						    .addComponent(ruleText, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
						    .addContainerGap())
					  );
	rulePaneLayout.setVerticalGroup(
					rulePaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(rulePaneLayout.createSequentialGroup()
						  .addContainerGap()
						  .addComponent(ruleText, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						  .addContainerGap())
					);

	tabbedPane.addTab("Rules", rulePane);

	mapImage.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("").getPath() + "Map.png")); //Puts the image in the mapImage var

	GroupLayout mapPaneLayout = new GroupLayout(mapPane);
	mapPane.setLayout(mapPaneLayout);

	mapPaneLayout.setHorizontalGroup(
					 mapPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					 .addGroup(mapPaneLayout.createSequentialGroup()
						   .addContainerGap()
						   .addComponent(mapImage)
						   .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					 );
	mapPaneLayout.setVerticalGroup(
				       mapPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				       .addGroup(mapPaneLayout.createSequentialGroup()
						 .addComponent(mapImage)
						 .addGap(0, 0, Short.MAX_VALUE))
				       );

	tabbedPane.addTab("Map", mapPane);

	documentText.setText(docTxt);

	GroupLayout documentsPaneLayout = new GroupLayout(documentsPane);
	documentsPane.setLayout(documentsPaneLayout);
	documentsPaneLayout.setHorizontalGroup(
					       documentsPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					       .addGroup(documentsPaneLayout.createSequentialGroup()
							 .addContainerGap()
							 .addComponent(documentText, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
							 .addContainerGap())
					       );
	documentsPaneLayout.setVerticalGroup(
					     documentsPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					     .addGroup(documentsPaneLayout.createSequentialGroup()
						       .addContainerGap()
						       .addComponent(documentText, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						       .addContainerGap())
					     );

	tabbedPane.addTab("Documents", documentsPane);

	copyrightText.setText(copyTxt);

	GroupLayout copyrightPaneLayout = new GroupLayout(copyrightPane);
	copyrightPane.setLayout(copyrightPaneLayout);
	copyrightPaneLayout.setHorizontalGroup(
					       copyrightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					       .addGroup(copyrightPaneLayout.createSequentialGroup()
							 .addContainerGap()
							 .addComponent(copyrightText, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
							 .addContainerGap())
					       );
	copyrightPaneLayout.setVerticalGroup(
					     copyrightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					     .addGroup(copyrightPaneLayout.createSequentialGroup()
						       .addContainerGap()
						       .addComponent(copyrightText, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
						       .addContainerGap())
					     );

	tabbedPane.addTab("Copyright", copyrightPane);

	GroupLayout layout = new GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	layout.setHorizontalGroup(
				  layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				  .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
					    .addContainerGap()
					    .addComponent(tabbedPane))
				  );
	layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.Alignment.TRAILING)
				);

	pack();
    }


    public static void main(String args[]) {

	java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		    new RuleGui().setVisible(true);
		}
	    });
    }

    // Variables declaration - do not modify                     
    private JLayeredPane bulletinPane;
    private JLabel bulletinText;
    private JPanel copyrightPane;
    private JLabel copyrightText;
    private JLabel documentText;
    private JPanel documentsPane;
    private JLabel mapImage;
    private JPanel mapPane;
    private JPanel rulePane;
    private JLabel ruleText;
    private JTabbedPane tabbedPane;
    // End of variables declaration                   
}
