
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class DrawPanel extends JPanel {
	
	//Class variable declaration
	private ArrayList<DrawPanel.ColorPoint> pointArray;
	private boolean drawing;
	private boolean erasing;
	public Color pen = Color.GREEN;
	public int size = 5;
    
    public void setColor(Color color){
    	pen = color;
    }
    //constructor
    public DrawPanel(){
    	
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension (400, 400));
		this.pointArray = new ArrayList<ColorPoint>();
		
		DrawHandler handler = new DrawHandler();
    	addMouseListener(handler);
    	addMouseMotionListener(handler);
    	
    	this.drawing = false;
    	this.erasing = false;
	}
	//draw circles at specified coordinates
	public void paintComponent(Graphics g){
		super.paintComponent(g);  
			for(ColorPoint p: this.pointArray ){
			
			g.setColor(p.color);
			g.fillOval(p.point.x, p.point.y, p.size, p.size);
			
			if(this.erasing){
				g.fillOval(p.point.x, p.point.y, p.size, p.size);
			} 
		}
	}
	
	//change radius method
	public void setSize(int i){
		this.size = (i+1)*5;
	}
	
	//clear the panel
	public void clearPanel(){
		this.pointArray = new ArrayList<ColorPoint>();
		repaint();
	}

	//handler for mouse events
	private class DrawHandler implements MouseListener, MouseMotionListener{
		
		public void mouseEntered(MouseEvent e){}   
		public void mouseExited(MouseEvent e){ }
		public void mousePressed(MouseEvent e){ }
		public void mouseReleased(MouseEvent e){ }
		public void mouseDragged(MouseEvent e){ }
		
		public void mouseClicked(MouseEvent e){
			//start or stop drawing
			drawing = !drawing;
		}
		public void mouseMoved(MouseEvent e){
			//draw 
			if (drawing){
		        pointArray.add( new ColorPoint( e.getPoint(), pen, size));
		        repaint();
			}
		}
	}
	
	//custom point object, tracks where user has drawn
	private class ColorPoint {
		private Color color;
		private Point point;
		private int size;
		
		public ColorPoint(Point point, Color color, int size) {
			this.point = point;
			this.color = color;
			this.size = size;
		}	
	}
}