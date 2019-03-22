/* File: DrawTurtle.java
   U.Wolz 1999
   For Assignment 3, CMSC 230, The College of New Jersey. All rights reserved.
   This code may be used if properly acknowledged.
*/
import java.awt.*;

public class DrawTurtle extends Turtle {
	protected Graphics g;
	protected boolean penstate;
	protected int centerX;
	protected int centerY;
	protected Color c = Color.black;

	public void home() {
		cx = 0;
		cy = 0;
		ch = 0;
		penstate = true;
	}
	
	
	public DrawTurtle(Component c) {
		this.g = c.getGraphics();
		centerX = c.getSize().width/2;
		centerY = c.getSize().height/2;
	}
	
	public void setColor(Color color) {
		c = color;
	}
	public Color getColor() { return c;}
	
	
	public void penDown() { penstate = true;}
	public void penUp() {penstate = false;}
		
	public void forward(double d) {
		double nx = cx + d * Math.sin(ch * Math.PI/180);
		double ny = cy + d * Math.cos(ch * Math.PI/180);
		if ( penstate) {
			Color temp = g.getColor();
			g.setColor(c);
			g.drawLine((int)cx+centerX,centerY-(int)cy,(int)nx+centerX,centerY-(int)ny);
			g.setColor(temp);
		}
		cx = nx;
		cy = ny;
	}
	
}
