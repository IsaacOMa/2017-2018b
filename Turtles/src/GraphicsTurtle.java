/* File GraphicsTurtle.java
   U.Wolz 1999
   For Assignment 3, CMSC 230, The College of New Jersey. All rights reserved.
   This code may be used if properly acknowledged.
   
   Note that the graphics figures  use the turtle position as the upper left corner. 
   To be more consistent with turtle geometry, the center of the figure should
   be the turtle's position. Someday......
   
   Future enhancements:  drawImage.
*/
import java.awt.*;
public class GraphicsTurtle extends DrawTurtle {

	public GraphicsTurtle(Component c) {
		super(c);
	}
	
	public void draw3DRect(int width, int height, boolean raised) {
		Color temp = g.getColor();
		g.setColor(c);
		g.draw3DRect((int)cx+centerX,centerY-(int)cy,width, height, raised);
		g.setColor(temp);
	}
	
	public void drawArc(int width, int height, int startAngle, int arcAngle) {
		Color temp = g.getColor();
		g.setColor(c);
		g.drawArc((int)cx+centerX,centerY-(int)cy, width, height, startAngle, arcAngle);
		g.setColor(temp);
	}
	
	public void drawOval(int width, int height) {
		Color temp = g.getColor();
		g.setColor(c);
		g.drawOval((int)cx+centerX,centerY-(int)cy, width, height);
		g.setColor(temp);
	}
	
	public void drawRect(int width, int height) {
		Color temp = g.getColor();
		g.setColor(c);
		g.drawRect((int)cx+centerX,centerY-(int)cy,width, height);
		g.setColor(temp);
	}
	
	public void drawString(String s) {
		Color temp = g.getColor();
		g.setColor(c);
		g.drawString(s, (int)cx+centerX,centerY-(int)cy);
		g.setColor(temp);
	}
	
   public void fill3DRect(int width, int height, boolean raised) {
		Color temp = g.getColor();
		g.setColor(c);
		g.fill3DRect((int)cx+centerX,centerY-(int)cy,width, height, raised);
		g.setColor(temp);
	}
	
	public void fillArc(int width, int height, int startAngle, int arcAngle) {
		Color temp = g.getColor();
		g.setColor(c);
		g.fillArc((int)cx+centerX,centerY-(int)cy, width, height, startAngle, arcAngle);
		g.setColor(temp);
	}
	
	public void fillOval(int width, int height) {
		Color temp = g.getColor();
		g.setColor(c);
		g.fillOval((int)cx+centerX,centerY-(int)cy, width, height);
		g.setColor(temp);
	}
	
	public void fillRect(int width, int height) {
		Color temp = g.getColor();
		g.setColor(c);
		g.fillRect((int)cx+centerX,centerY-(int)cy,width, height);
		g.setColor(temp);
	}
}