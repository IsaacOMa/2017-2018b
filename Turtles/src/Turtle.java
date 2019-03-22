/* File: Turtle.java
   U. Wolz, October 1998
   For in class demonstration of the Software Development Method.
   Please cite properly if you use or enhance this code
   */

public class Turtle {
  // datafields
  double ch;    // current heading
  double cx;    // current x coordinate
  double cy;    // current y coordinate

  // modifiers
  public void forward(double d) {
    cx = cx + d * Math.sin(ch*Math.PI/180);
    cy = cy + d * Math.cos(ch*Math.PI/180);
  }

  public void back (double d) {
    forward(-d);
  }

  public void right(double turn) {
    ch = (ch + turn + 360) % 360;
  }

  public void left(double turn) {
    right(- turn);
  }

  // accessors
  public double getH() {
    return ch;
  }

  public double getX() {
    return cx;
  }

  public double getY() {
    return cy;
  }

}
