
import java.util.Random;

class ShuffleTree <Value> {
	private class Node { //is the node class, similar to past lab private Node classes
		private String key;
		private Value value;
		private Node left;
		private Node right;
		private Node (String key, Value value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	private String[] keys; //private variables used in the lab
	private Value[] values;
	private int count;
	private Node root;
	private Random generator;
	
	public ShuffleTree (int size) {
		if (size < 0) { //size less than 0 is invalid
			throw new IllegalArgumentException();
		}
		keys = new String[size]; //otherwise, assign values to the variables
		values = (Value[]) new Object[size];
		count = 0;
		root = null;
		generator = new Random();
	}
	
	
	public void flush () {
		for (int i = 0; i < count; i+=1) {
		    int random = Math.abs(generator.nextInt() % (count - i)); //generates a random number with max value count - i
		    String tempKey = keys[i]; //this section  randomizes the order of the objects in values and keys 
		    keys[i] = keys[i + random];
		    keys[i + random] = tempKey;
		    
		    Value tempValue = values[i];
		    values[i] = values[i + random];
		    values[i + random] = tempValue;
		}
		
		for (int i = 0; i < count; i +=1) { //adds the objects to the BST
			adding(keys[i], values[i]);
		}
		
		values = (Value[]) new Object[values.length]; //makes all the elements in array values and next line keys null
		keys = new String[keys.length];

		count = 0; //resets the count to 0
	}
		
	
		private void adding(String key, Value value) {//this is the method found in class, adds the element to the BST
		if (root == null) { //if root is null, it now holds the new node
			root = new Node(key, value);
		}
		else {
			Node subtree = root;
			while(true) {
				int compared = key.compareTo(subtree.key);
				if (compared < 0) { //if letter is before the previous node, go to the left, or add node
					if (subtree.left == null) {
						subtree.left = new Node (key, value);
						return;
					}
					else { 
						subtree = subtree.left;
					}
				}
				else if (compared > 0) { //if letter is after the previous node alphabetically, go to the right, or add node
					if (subtree.right == null) {
						subtree.right = new Node (key, value);
						return;
					}
					else {
						subtree = subtree.right;
					}
				}
				else { //otherwise it's equal, which is invalid
					throw new IllegalStateException();
				}
			}
		}
		}
		
	
	public Value get(String key) { //recycled version of the adding method
	    if (count > 0) {//empties the arrays into the BST
	        flush();
	    }
		Node subtree = root;
		if (subtree == null) {//if root null, throw an exceptions
			throw new IllegalStateException();
		}
		while(true) {
			if (subtree == null) { //if subtree is equal, the loop will end, raising an exception
				break;
			}
			int compared = key.compareTo(subtree.key);
			if (compared < 0) { //if key word alphabetically before node word, go to the left
				subtree = subtree.left;
			}
			else if (compared > 0) {//if key word alphabetically after node word, go to the right
				subtree = subtree.right;
			}
			else if (compared == 0){ //if words are equal, return node word's value
				return subtree.value;
			}
		}
		throw new IllegalStateException();//if not in tree, throw an exception
	}


	public int height() {
		if (count != 0) {//empties the array
			flush();
		}
		return findHeight(root);
	}
	
	private int findHeight(Node root) {//this function is another method from class, finds height
		if (root == null) {// if root null, height = 0
			return 0;
		}
		else {//otherwise keep track of possible max heights
			int l = findHeight(root.left); 
			int r = findHeight(root.right);
			if (l > r) {
				return l +1;
			}
			else {
				return r + 1;
			}
		}
	}



	public void put (String key, Value value) {//puts the new key and value into the array
	    if (key == null) {
	        throw new IllegalArgumentException();
	    }
	    if (count == keys.length) {//flushes if array is full
	        flush();
	    }
	    keys[count] = key;
	    values[count] = value;
	    count +=1;
	}
}

