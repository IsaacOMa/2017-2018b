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



