

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionsPanel extends JPanel {
	
    //Class variable declaration
    DrawPanel drawPanel;
    private final JRadioButton greenButton;
	private final JRadioButton yellowButton;
	private final JRadioButton blueButton;
	private final JRadioButton eraseButton;
	private final ButtonGroup radioGroup;
	private final JButton clearButton;
	private final JComboBox<String> penRadius;
	private final String[] choices;
	
	public OptionsPanel(DrawPanel drawPanel){
		//init all variables
		choices = new String[3];
		choices[0] = "5 pt";
		choices[1] = "10 pt";
		choices[2] = "15 pt";
		this.drawPanel = drawPanel;
		
		//attach handler to radiobuttons
		RadioButtonHandler handler = new RadioButtonHandler (Color.GREEN);
		
		//construct buttons
		greenButton = new JRadioButton("Green", true);
		yellowButton = new JRadioButton("Yellow", true);
		blueButton = new JRadioButton("Blue", true);
		eraseButton = new JRadioButton("Erase", true);
		clearButton = new JButton("Clear");
		radioGroup = new ButtonGroup();
		penRadius = new JComboBox<>(choices);
		
		//add buttons to the GUI
		add(greenButton);
		add(yellowButton);
		add(blueButton);
		add(eraseButton);
		add(penRadius);
		add(clearButton);
		
		//add buttons to radiogroup
		radioGroup.add(greenButton);
		radioGroup.add(yellowButton);
		radioGroup.add(blueButton);
		radioGroup.add(eraseButton);
		
		//itemlistener for changing girth
		penRadius.addItemListener(
			new ItemListener(){
				// handle JComboBox event
				@Override
				public void itemStateChanged(ItemEvent event)
				{
				// determine whether item selected
				if (event.getStateChange() == ItemEvent.SELECTED)
					drawPanel.setSize(penRadius.getSelectedIndex());
				}
		});
		
		//add actionlisteners to radio buttons/clear
		greenButton.addActionListener(
			new RadioButtonHandler(Color.GREEN));
		yellowButton.addActionListener(
			new RadioButtonHandler(Color.YELLOW));
		blueButton.addActionListener(
			new RadioButtonHandler(Color.BLUE));
		eraseButton.addActionListener(
			new RadioButtonHandler(Color.WHITE));
		clearButton.addActionListener(
			new RadioButtonHandler());
		
	}
	
	//handler for radiobuttons/clear
 	class RadioButtonHandler implements ActionListener{
		private Color color;
		
		public RadioButtonHandler(Color c){
			color = c;
		}
		//no arg constructor
		public RadioButtonHandler(){
			color = null;
		}
		@Override
 		public void actionPerformed(ActionEvent event){
 			//only clear sets to null
 			if (color == null){
 				//call clearpanel method
 				OptionsPanel.this.drawPanel.clearPanel();
 			}
 			//all others pass a color
 			else
 				OptionsPanel.this.drawPanel.pen = color;		
 		}	
	}	
}