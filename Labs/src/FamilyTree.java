
class FamilyTree {
	private class Node { //constructs the node
    	String name;
    	Node father;
    	Node mother;
    	private Node (String name, Node father, Node mother) {
        	this.name = name;
        	this.father = father;
        	this.mother = mother;
    	}
	}
    
	private Node al;
	public FamilyTree(String ego) { //this is the constructor for the head node
    	al = new Node (ego, null, null);
	}
	
	
	private boolean found;
	private Node current; //gives the point of traversal in the tree
	
	private Node find(String name, Node root) {
	    current = root; //sets the head node to root
	    found = false;
	    finder(current, name); 
	    if (found == true) { //finder must change the value and return this to true to return the current node
	        return current;
	    }
	    else {
	        return null; //returns null otherwise
	    }
	}
    
    
	
	private Node find (String name) { //this is like the previous find method, however, this one uses al as the head node
    	current = al;
    	found = false;
    	finder(current, name);
    	if (found == true) {
    	    return current;
    	}
    	else { 
    	    return null;
    	}
	}
    
	private void finder (Node currently, String name) { //a helper method, using deep recursion
        	if (name.equals(currently.name)) {
        	    found = true;
        	    current = currently;
            	return; //if true, changes variables to findings and ends the method
        	}
        	else {
            	if (currently.father == null && currently.mother == null) { //if at the bottom of tree, ends the method for the section
                	return;
            	}
            	else {
                	if (currently.father != null) {
                    	finder (currently.father, name); //calls the finder method for the father node
                	}
                	if (currently.mother != null) {
                    	finder (currently.mother, name); //calls the finder method for the mother node
                	}
            	}
        	}
	}
	
	public void addParents(String ego, String father, String mother) {
    	found = false; //assumes the node for the addition of parents is not legitimate
    	addingParents(al, ego, father, mother); //finds if the child node heir is valid
    	if (!found) {
        	throw new IllegalArgumentException(); //if there is no child node, then throws and exception
    	}
	}
    
	public void addingParents(Node currently, String ego, String father, String mother) { //helper method using deep recursion
    	if (currently.name.equals(ego)) {
        	currently.father = new Node (father, null, null);
        	currently.mother = new Node (mother, null, null);
        	found = true;
        	return; //if the node checked is the child, then the parents are added
    	}
    	else if (currently.father != null || currently.mother != null) { //otherwise if either parent is not null, then those nodes are checked
        	if (currently.father != null) {
            	addingParents(currently.father, ego, father, mother);
        	}
        	if (currently.mother != null) {
            	addingParents(currently.mother, ego, father, mother);
        	}
    	} 
	}
    
	public boolean isDescendant (String ego, String ancestor) {
	    Node younger = find(ego); //finds the node of the ego string
	    Node older = find(ancestor); //finds the node of the ancestor string
	    if (find(ego) != null && find(ancestor) != null) { //if both are not null
	        return isDescendant (younger, older); //returns the node version of isDescendant
	    }
    	return false; //if either is null then return false
	}
	
	public boolean isDescendant (Node root, Node ancestor) {
		return (find(ancestor.name, root) != null); //calls the find method
	}
}






