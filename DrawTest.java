

import java.awt.*;
import javax.swing.*;

public class DrawTest {
    
   public static void main (String [] args){
   	
   		JFrame frame = new JFrame("Draw Something!");
   		DrawPanel drawPanel = new DrawPanel();
   		OptionsPanel optionsPanel = new OptionsPanel(drawPanel);
   		
   	 	frame.add(drawPanel, BorderLayout.CENTER);
   	 	frame.add(optionsPanel, BorderLayout.SOUTH);
   	 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	frame.setPreferredSize(new Dimension(420, 500));
     	
     	frame.pack();
    	frame.setVisible(true);
    	frame.setResizable(true);
   }
}