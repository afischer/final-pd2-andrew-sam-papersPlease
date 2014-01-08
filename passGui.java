import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class passGui extends JFrame implements ActionListener{
    
    private JButton exitButton;
    private JLabel label;
    //private JPanel canvas;
    private Container buttons;
    protected Container pane;
    
    passmaker p = new passmaker();
    
	String passport = p.make(p.getName("Male"), p.getLName(), "08/19/44", "male", "impor","11/22/83" , "1832-ASDE-DFSD-EF");
	
	//Action Listener for Exit Button
	public void actionPerformed(ActionEvent e) {
	if (e.getSource() == exitButton) {
	    System.exit(0);
	} else { }
    }
    
    public passGui() {
	this.setTitle("ARISTOKSA MOA Passport Viewer");
	this.setSize(800,420);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setAlwaysOnTop(true);
	
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	//pane.setLayout(new GridLayout(4,0));

	exitButton = new JButton("Close");
	label = new JLabel(passport);
	
	
	buttons = new Container();

	buttons.setLayout(new FlowLayout());
	buttons.add(exitButton);
	
	
	pane.add(label);
	pane.add(buttons);

	exitButton.addActionListener(this);
    }

    public static void main(String[] args) {
    	passGui g = new passGui();
    	g.setVisible(true);
    }
}