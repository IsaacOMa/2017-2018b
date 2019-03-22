class RunnyStack <Base>{
    
	private Run top;
	private int count;
	private int runNumber;
    
	public RunnyStack(){
    	top = null; //this is not in the constructor in the class example
    	count = 0;
    	runNumber = 0;
	}
    
	private class Run {
    	private Base base;
    	private Run next;
    	private int length;
    	private Run (Base base, Run next, int length) {
        	this.base = base;
        	this.next = next;
        	this.length = length;
    	}
	}
    
    
	public int depth() {
    	return count;
	}
    
	public boolean isEmpty() {
    	return top == null;
	}
    
	public Base peek() {
    	if (isEmpty()) {
        	throw new IllegalStateException();
    	}
    	else {
         	return top.base;
    	}
	}
    
	public void pop() {
    	if (isEmpty()) {
        	throw new IllegalStateException();
    	}
    	else {
    	    if (top.length > 1) {
    	        top.length -=1;
    	    }
    	    else {
    	        top = top.next;
    	        runNumber-=1;
    	    }
    	}
    	count-=1;
	}
    
	public void push (Base base) {
    	if ((count > 0) && isEqual(base, top.base)) {
        	top.length+=1;
    	}
    	else {
       	top = new Run(base, top, 1);
       	runNumber+=1;
    	}
    	count+=1;
	}
    
	private boolean isEqual(Base baseA, Base baseB) {
    	if (baseA == null || baseB == null) {
        	return (baseA == baseB);
    	}
    	else {
        	return (baseA.equals(baseB));
    	}
	}
    
	public int runs() {
    	return runNumber;
	}
}

//
//  Tests for CSci 1913 Lab 8
//  James Moen
//  20 Mar 17
//
//  The TRY-CATCH statements catch exceptions thrown by RUNNY STACK's methods,
//  so that the program can continue to run even if a method fails. We still
//  haven't talked about TRY-CATCH'es in the lectures yet.
//
//  Most tests have comments that show what they should print, and how many
//  points they are worth, for a total of 40 points.
//
//  Camembert is a soft French cheese. It may be runny. It can be stacked.
//

class Camembert
{
  public static void main(String [] args)
  {
	RunnyStack<String> s = new RunnyStack<String>();

	System.out.println(s.isEmpty());     	//  true   	1 point
	System.out.println(s.depth());       	//  0      	1 point
	System.out.println(s.runs());        	//  0      	1 point

	try
	{
  	s.pop();
	}
	catch (IllegalStateException ignore)
	{
  	System.out.println("No pop");      	//  No pop 	1 point
	}

	try
	{
  	System.out.println(s.peek());
	}
	catch (IllegalStateException ignore)
	{
  	System.out.println("No peek");     	//  No peek	1 point
	}
 
	s.push("A");
	System.out.println(s.peek());        	//  A      	1 point
	System.out.println(s.depth());       	//  1      	1 point
	System.out.println(s.runs());        	//  1      	1 point

	System.out.println(s.isEmpty());     	//  false  	1 point

	s.push("B");
	System.out.println(s.peek());        	//  B      	1 point
	System.out.println(s.depth());       	//  2      	1 point
	System.out.println(s.runs());        	//  2      	1 point

	s.push("B");
	System.out.println(s.peek());        	//  B      	1 point
	System.out.println(s.depth());       	//  3      	1 point
	System.out.println(s.runs());        	//  2      	1 point

	s.push("B");
	System.out.println(s.peek());        	//  B      	1 point
	System.out.println(s.depth());       	//  4      	1 point
	System.out.println(s.runs());        	//  2      	1 point

	s.push("C");
	System.out.println(s.peek());        	//  C      	1 point
	System.out.println(s.depth());       	//  5      	1 point
	System.out.println(s.runs());        	//  3      	1 point

	s.push("C");
	System.out.println(s.peek());        	//  C      	1 point
	System.out.println(s.depth());       	//  6      	1 point
	System.out.println(s.runs());        	//  3      	1 point

	s.pop();
	System.out.println(s.peek());        	//  C      	1 point
	System.out.println(s.depth());       	//  5      	1 point
	System.out.println(s.runs());        	//  3      	1 point

	s.pop();
	System.out.println(s.peek());        	//  B      	1 point
	System.out.println(s.depth());       	//  4      	1 point
	System.out.println(s.runs());        	//  2      	1 point

	s.pop();
	System.out.println(s.peek());        	//  B      	1 point
	System.out.println(s.depth());       	//  3      	1 point
	System.out.println(s.runs());        	//  2      	1 point

	s.pop();
	s.pop();
	System.out.println(s.peek());        	//  A      	1 point
	System.out.println(s.depth());       	//  1      	1 point
	System.out.println(s.runs());        	//  1      	1 point

	s.pop();
	System.out.println(s.isEmpty());     	//  true   	1 point
	System.out.println(s.depth());       	//  0      	1 point
	System.out.println(s.runs());        	//  0      	1 point

	try
	{
  	System.out.println(s.peek());
	}
	catch (IllegalStateException ignore)
	{
  	System.out.println("No peek");     	//  No peek	1 point
	}
  }
}




