

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


class Hogwarts
{

//  MAIN. Make an instance of ASSOCIATION LIST and test it.

  public static void main(String[] args)
  {
	AssociationList<String,String> list = new AssociationList<String,String>();

	System.out.println(list.isIn(null));     	//  false     	2 points.

	try
	{
  	System.out.println(list.get(null));
	}
	catch (IllegalArgumentException ignore)
	{
  	System.out.println("No null");         	//  No null   	2 points.
	}

	list.put(null,    	"Wormtail");
	list.put("Ron",   	"Lavender");
	list.put("Voldemort", null);
	list.put("Dean",  	"Ginny");

	System.out.println(list.isIn("Dean"));   	//  true      	2 points.
	System.out.println(list.isIn("Ginny"));  	//  false     	2 points.
	System.out.println(list.isIn("Ron"));    	//  true      	2 points.
	System.out.println(list.isIn("Voldemort"));  //  true      	2 points.
	System.out.println(list.isIn(null));     	//  true      	2 points.
	System.out.println(list.isIn("Joanne")); 	//  false     	2 points.

	System.out.println(list.get("Ron"));     	//  Lavender  	2 points.
	System.out.println(list.get("Dean"));    	//  Ginny     	2 points.
	System.out.println(list.get("Voldemort"));   //  null      	2 points.
	System.out.println(list.get(null));      	//  Wormtail  	2 points.

	try
	{
  	System.out.println(list.get("Joanne"));
	}
	catch (IllegalArgumentException ignore)
	{
  	System.out.println("No Joanne");       	//  No Joanne 	2 points.
	}

	list.delete(null);

	System.out.println(list.isIn(null));     	//  false     	2 points.

	list.put(null,	null);
	list.put("Harry", "Ginny");
	list.put("Ron",   "Hermione");

	System.out.println(list.isIn(null));     	//  true      	2 points.
	System.out.println(list.get(null));      	//  null      	2 points.
	System.out.println(list.get("Harry"));   	//  Ginny     	2 points.
	System.out.println(list.get("Dean"));    	//  Ginny     	2 points.
	System.out.println(list.get("Ron"));     	//  Hermione  	2 points.

	list.delete("Dean");

	try
	{
  	System.out.println(list.get("Dean"));
	}
	catch (IllegalArgumentException ignore)
	{
  	System.out.println("No Dean");         	//  No Dean   	2 points.
	}
  }
}
