
class Deque<Base> {
	private class Node {
    	Base object;
    	Node left;
    	Node right;
    	Node(Base object, Node left, Node right) {
        	this.object = object;
        	this.left = left;
        	this.right = right;
    	}
	}
    
	private Node head;
	private Node deque;
	public Deque () {
    	head = new Node(null, head, head);
    	deque = head;
   	 
	}
    
	public void enqueueFront (Base object) {
    	Node f = new Node (object, head, deque);
    	head.right = f;
    	deque.left = f;
    	deque = deque.left;
	}
    
	public void enqueueRear (Base object) {
    	Node r = new Node (object, deque, head);
    	head.left = r;
    	deque.right = r;
    	deque = deque.right;
	}
    
	public Base dequeueFront() {
    	if (deque.object == null) {
        	throw new IllegalStateException();
    	}
    	deque = head.right;
    	Base temp = deque.object;
    	deque.right.left = deque.left;
    	deque.left.right = deque.right;
    	deque = head.right;
    	return temp;
	}
	
    
	public Base dequeueRear() {
	    if (deque.object == null) {
        	throw new IllegalStateException();
    	}
    	deque = head.left;
	    deque.right.left = deque.left;
	    deque.left.right = deque.right;
	    Base temp = deque.object;
	    deque = deque.left;
    	return temp;
	}
    
    public boolean isEmpty() {
    	if (deque.object == null) {
        	return true;
    	}
    	return false;
	}
}


//OBSERVATION DEQUE. Test the class DEQUE. 40 points total.

class ObservationDeque
{

//MAIN. Test the DEQUE on various example arguments.

public static void main(String [] args)
{
Deque<String> deque = new Deque<String>();

System.out.println(deque.isEmpty());   	// true            	2 points.

try
{
	System.out.println(deque.dequeueFront());
}
catch (IllegalStateException ignore)
{
	System.out.println("No dequeueFront.");  //  No dequeueFront.   2 points.
}

try
{
	System.out.println(deque.dequeueRear());
}
catch (IllegalStateException ignore)
{
	System.out.println("No dequeueRear.");   //  No dequeueRear.	2 points.
}

//Enqueueing to the rear and dequeueing from the rear makes the DEQUE act
//like a stack.

deque.enqueueRear("A");
deque.enqueueRear("B");
deque.enqueueRear("C");

System.out.println(deque.isEmpty());   	//  false          	2 points.

System.out.println(deque.dequeueRear());   //  C              	2 points.
System.out.println(deque.dequeueRear());   //  B              	2 points.
System.out.println(deque.dequeueRear());   //  A              	2 points.

System.out.println(deque.isEmpty());   	//  true           	2 points.

//Enqueueing to the rear and dequeueing from the front makes the DEQUE act
//like a queue.

deque.enqueueRear("A");
deque.enqueueRear("B");
deque.enqueueRear("C");

System.out.println(deque.dequeueFront());  //  A              	2 points.
System.out.println(deque.dequeueFront());  //  B              	2 points.
System.out.println(deque.dequeueFront());  //  C              	2 points.

System.out.println(deque.isEmpty());   	//  true           	2 points.

//Enqueueing to the front and dequeueing from the front makes the DEQUE act
//like a stack.

deque.enqueueFront("A");
deque.enqueueFront("B");
deque.enqueueFront("C");

System.out.println(deque.dequeueFront());  //  C              	2 points.
System.out.println(deque.dequeueFront());  //  B              	2 points.
System.out.println(deque.dequeueFront());  //  A              	2 points.

System.out.println(deque.isEmpty());   	//  true           	2 points.

//Enqueueing to the front and dequeueing from the rear makes the DEQUE act
//like a queue.

deque.enqueueFront("A");
deque.enqueueFront("B");
deque.enqueueFront("C");

System.out.println(deque.dequeueRear());   //  A              	2 points.
System.out.println(deque.dequeueRear());   //  B              	2 points.
System.out.println(deque.dequeueRear());   //  C              	2 points.

System.out.println(deque.isEmpty());   	//  true           	2 points.
}
}



