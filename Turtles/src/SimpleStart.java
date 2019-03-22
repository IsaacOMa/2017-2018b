/* File: ExampleT1.java
   U.Wolz 1999
   For Assignment 3, CMSC 230, The College of New Jersey. All rights reserved.
   This code may be used if properly acknowledged.
*/
import java.awt.*;
import java.applet.Applet;

public class SimpleStart extends Applet {
 
 public void paint(Graphics g) {
 
  DrawTurtle t = new DrawTurtle(this);  //t is an instance of DrawTurtle
  t.home();  // look for this method
  t.penDown();  // look for this method
  t.forward(50);  //what to you think will happen
  // run and see what happens
  t.right(90);
  t.forward(50);
  //make the turtle turn right and travel a distance of 50
  t.right(90);
  t.forward(50);
  t.right(90);
  t.forward(50);
  //make a square
  for (int i = 0; i < 6; i ++)
  {
	  int angle = 60;
	  t.right(angle);
	  t.forward(50);
  }
  //make a regular hexagon
  for (int i = 0; i < 8; i ++)
  {
	  int angle = 45;
	  t.right(angle);
	  t.forward(50);
  }
  //make a regular octagon
 }  
}
 







