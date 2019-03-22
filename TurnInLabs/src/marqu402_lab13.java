
class PriorityQueue<Base>
	{
  	private class Node
  	{
    	private Base object;
    	private int  rank;
    	private Node left;
    	private Node right;
	 
    	private Node(Base object, int rank)
    	{
      	this.object = object;
      	this.rank = rank;
      	left = null;
      	right = null;
    	}
  	}
	 
  	private Node root;  //  Root node of the BST.
 
	 
  	public PriorityQueue () {
      	root = new Node(null, 8); //makes a new queue with head node root
  	}
 	 
  	public Base dequeue() {
      	if (root.left == null && root.right == null) { //if the queue is empty, throw an exception
          	throw new IllegalStateException();
      	}
      	Base temp;
      	Node subtree = root;
      	Node subtreePrev = root; //keeps track of the previous node
      	if (subtree.left == null) {//if everything left of head node is null, the node goes one to the right
          	subtree = subtree.right;
      	}
      	while(subtree.left != null) { //while left is not null, the node goes left
          	subtreePrev = subtree;
          	subtree = subtree.left;
      	}
     	 
      	temp = subtree.object; //stores the lowest ranked object's value
     	 
      	if (subtree.right == null && root.left != null){ //deletes a node if it's larger than the smallest subtree
          	subtreePrev.left = null; //node on the left side of the tree
      	}
      	else {
          	Node prev = root; //keeps track of previous node
          	while(subtree.right != null) { //while right node is not null, node copies to the next node until last
              	subtree.object = subtree.right.object;
              	subtree.rank = subtree.right.rank;
              	prev = subtree;
              	subtree = subtree.right;
          	}
          	prev.right = null; //deletes the last node to the right
      	}
      	return temp; //returns the object of the lowest rank
  	}
 	 
  	public void enqueue(Base object, int rank) {
      	if (rank < 0) {//if invalid rank throws an exception
          	throw new IllegalArgumentException();
      	}
      	Node subtree = root;
      	while(true) { //continues until a null for subtree left or right is found
          	if (rank < subtree.rank) { // left of node if smaller
              	if (subtree.left == null) { //adds new node
                  	subtree.left = new Node (object, rank);
                  	return;
              	}
              	else{ //goes to next node
                  	subtree = subtree.left;
              	}
          	}
          	else { // right of node otherwise
              	if (subtree.right == null) {
                  	subtree.right = new Node(object, rank);
                  	return;
              	}
              	else {//goes to next node
                  	subtree = subtree.right;
              	}
          	}
      	}
  	}
 	 
  	public boolean isEmpty(){
      	return (root.left == null && root.right == null);
  	}
	}


//  SNOBBERY. How the aristocracy behaves in a queue. 20 points.



class Snobbery
{

//  MAIN. Queue them up.

  public static void main(String[] args)
  {
	PriorityQueue<String> queue = new PriorityQueue<String>();

	System.out.println(queue.isEmpty());  //  true    	2 points

	try
	{
  	System.out.println(queue.dequeue());
	}
	catch (IllegalStateException ignore)
	{
  	System.out.println("Blimey!");  	//  Blimey! 	2 points
	}

	queue.enqueue("Lancelot",  5);
	queue.enqueue("Fawlty",	7);
	queue.enqueue("Elizabeth", 0);
	queue.enqueue("Charles",   1);
	queue.enqueue("Turing",	7);

	try
	{
  	queue.enqueue("Zeus", -100);
	}
	catch (IllegalArgumentException ignore)
	{
  	System.out.println("No gods!"); 	//  No gods!	2 points
	}

	System.out.println(queue.isEmpty());  //  false   	2 points

	System.out.println(queue.dequeue());  //  Elizabeth   2 points
	System.out.println(queue.dequeue());  //  Charles 	2 points
	System.out.println(queue.dequeue());  //  Lancelot	2 points
	System.out.println(queue.dequeue());  //  Turing  	2 points
	System.out.println(queue.dequeue());  //  Fawlty  	2 points

//  It's OK if Fawlty comes out before Turing, but both must come out last.

	System.out.println(queue.isEmpty());  //  true    	2 points.
  }

}

