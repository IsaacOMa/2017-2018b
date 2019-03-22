

class AssociationList<Key, Value> {
	private class Node {
    	private Key key;
    	private Value value;
    	private Node next;
    	private Node (Key key, Value value, Node next) {
        	this.value = value;
        	this.key = key;
        	this.next = next;
    	}
	}
	private Node head;
	private Node front;
	public AssociationList() {
    	head = new Node(null, null, null); //makes a fake node
    	front = head; //starts with the fake node, will be built off of later
	}
	public void delete (Key key) { 
		Node left = head; //uses left-right trick in order to find an element to delete
		Node right = head.next;
    	while(right != null) {
        	if (isEqual(key, right.key)) {
            	left.next = right.next;
            	return;
        	}
        	else {
            	left = right;
            	right = right.next;
        	}
    	}
	}
    
	private boolean isEqual(Key leftKey, Key rightKey) {
    	if (leftKey == null || rightKey == null) { //decides if a node is null
        	return leftKey == rightKey; //if null, then == is used. If not, then .equals() is used
    	}
    	else {
        	return leftKey.equals(rightKey);
    	}
	}
    
	public Value get (Key key) { //searches the nodes for a specific value, returns it
    	Node right = head.next;
    	while(right != null) {
        	if (isEqual(key, right.key)) {
            	return right.value;
        	}
        	else {
            	right = right.next;
        	}
    	}
    	throw new IllegalArgumentException(); //throws an exception if the value is not found
	}
    
	public boolean isIn (Key key) { //similar to method get(), but it returns a boolean value
    	Node right = head.next;
    	while(right != null) {
        	if (isEqual(key, right.key)) {
            	return true;
        	}
        	else {
            	right = right.next;
        	}
    	}
    	return false;
	}
    
	public void put (Key key, Value value) {
    	if(front.next != null) { //makes sure front is at the last node
            front = front.next;
    	}
    	Node finder = head.next;
    	while(finder != null) { //checks all nodes for key
    		if (isEqual(key, finder.key)) {
    			finder.value = value; // if found changes finder.value to value
    			return; //ends process
    		}
    		else {
    			finder = finder.next;
    		}
    	}
    	front.next = new Node(key, value, null); //if key not found, then adds new node to end
	}
}

