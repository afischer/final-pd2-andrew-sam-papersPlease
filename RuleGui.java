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

	public String ruleDay1 = "Only allow Arstotzkan citizens through the checkpoint.";
	public String ruleDay3 = "Allow foreigners through the checkpoint only if their passports are valid. Passports should not be expired, and should match the holder's face, gender, etc.";
	public String ruleDay5 = "";

	public String bulletinTxt = "";
	public String ruleTxt = "";
	public String docTxt = "";
	public String copyTxt = "";

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
		
		copyTxt = "<html><center><b>Copyright MOA.</b> <br> Glory to Arstoksa.";

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);


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
						.addComponent(bulletinText, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
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
	private javax.swing.JLayeredPane bulletinPane;
	private javax.swing.JLabel bulletinText;
	private javax.swing.JPanel copyrightPane;
	private javax.swing.JLabel copyrightText;
	private javax.swing.JLabel documentText;
	private javax.swing.JPanel documentsPane;
	private javax.swing.JLabel mapImage;
	private javax.swing.JPanel mapPane;
	private javax.swing.JPanel rulePane;
	private javax.swing.JLabel ruleText;
	private javax.swing.JTabbedPane tabbedPane;
	// End of variables declaration                   
}
