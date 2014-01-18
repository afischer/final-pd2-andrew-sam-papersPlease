import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class PassGui extends JFrame implements ActionListener {
    
    private JButton exitButton;
    private JLabel label;
    //private JPanel canvas;
    private Container buttons;
    protected Container pane;
    
    PassMaker p = new PassMaker();
    
    String passport = p.make(p.getName("Male"), p.getLName(), p.getDOB(), Level.currSex , p.getTerritory() , p.getExp() , p.getSerial());
	
	//Action Listener for Exit Button
	public void actionPerformed(ActionEvent e) {
	if (e.getSource() == exitButton) {
	    this.setVisible(false);
	} else { }
    }
    
    public PassGui() {
	this.setTitle("ARISTOKSA MOA Passport Viewer");
	this.setSize(800,480);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(HIDE_ON_CLOSE);
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
    	PassGui g = new PassGui();
    	g.setVisible(true);
    }
}
