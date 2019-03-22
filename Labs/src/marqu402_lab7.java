
class Map <Key, Value> {
    
	private Key[] keys;
	private Value[] values;
	private int count = 0;
	private int lengthy;
    
	public Map (int length) { //initializes arrays values and keys
    	if (length < 0) {
        	throw new IllegalArgumentException ("Length must be greater than 1.");
    	}
    	lengthy = length;
    	values = (Value[]) new Object [length];
    	keys = (Key[]) new Object [length];
	}
    
	public Value get(Key key) { //returns the value for an object of type Value if key is in keys
    	int location = where (key);
    	if (location == -1) { // if key is not in keys raise an exception
        	throw new IllegalArgumentException ("The index is invalid.");
    	}
    	else { //else return the value of Value at index location
        	return values[location];
    	}
	}
    
	private boolean isEqual (Key leftKey, Key rightKey) { 
    	if (leftKey == null || rightKey == null) { //if either of the key elements are null use ==
        	if (leftKey == rightKey) {
            	return true;
        	}
    	}
    	else {
        	if (leftKey.equals(rightKey)) { //if neither of the kye elements are null use .equals()
            	return true;
        	}
    	}
    	return false;
	}
    
	public boolean isIn(Key key) { //determines whether or not key is int keys
   	 
    	for (int index = 0; index < lengthy; index +=1) {
        	if (isEqual(key, keys[index])) {
            	return true;
        	}
    	}
    	return false;
	}
    
	public void put(Key key, Value value) { //inserts a new value into the arrays keys and values
    	int location = where (key);
    	if (location == -1) { //if key is not in keys
        	int isFull = where(null);
        	if (count >= lengthy - 1) { //if array is full raise an exception
            	throw new IllegalStateException ();
        	}
        	else { //if array not full add the element
            	keys[isFull] = key;
            	values[isFull] = value;
            	count++;
        	}
    	}
    	else { //if key in keys, change values[index] to value
        	values[location] = value;
    	}
	}
    
	private int where(Key key) { 
    	if (key == null) {
        	for (int index = 0; index < lengthy; index +=1) { //finds out if an element in keys is null
            	if (keys[index] == null) {
                	return index; //returns index if match is found
            	}
        	}
    	}
    	else {
        	for (int index = 0; index < lengthy; index +=1) { //tries to find an element in keys equal to key
            	if (key.equals(keys[index])) {
                	return index; //returns index if match is found
            	}
        	}
    	}
    	return -1; // if never found, returns -1
	}
    
    
}

class Hogwart
{

//  MAIN. Make an instance of MAP and test it.

  public static void main(String [] args)
  {
	Map<String, String> map;

	try
	{
  	map = new Map<String, String>(-5);
	}
	catch (IllegalArgumentException ignore)
	{
  	System.out.println("No negatives");   	//  No negatives  2 points.
	}

	map = new Map<String, String>(5);

	map.put("Harry", 	"Ginny");
	map.put("Ron",   	"Lavender");
	map.put("Voldemort", null);
	map.put(null,    	"Wormtail");

	System.out.println(map.isIn("Harry"));  	//  true      	2 points.
	System.out.println(map.isIn("Ginny"));  	//  false     	2 points.
	System.out.println(map.isIn("Ron"));    	//  true      	2 points.
	System.out.println(map.isIn("Voldemort"));  //  true      	2 points.
	System.out.println(map.isIn(null));     	//  true      	2 points.
	System.out.println(map.isIn("Joanne")); 	//  false     	2 points.

	System.out.println(map.get("Harry"));   	//  Ginny     	2 points.
	System.out.println(map.get("Ron"));     	//  Lavender  	2 points.
	System.out.println(map.get("Voldemort"));   //  null      	2 points.
	System.out.println(map.get(null));      	//  Wormtail  	2 points.

	try
	{
  	System.out.println(map.get("Joanne"));
	}
	catch (IllegalArgumentException ignore)
	{
  	System.out.println("No Joanne");      	//  No Joanne 	2 points.
	}

	map.put("Ron",   "Hermione");
	map.put("Albus", "Gellert");
	map.put(null,	null);

	System.out.println(map.isIn(null));     	//  true      	2 points.
	System.out.println(map.isIn("Albus"));  	//  true      	2 points.

	System.out.println(map.get("Albus"));   	//  Gellert   	2 points.
	System.out.println(map.get("Harry"));   	//  Ginny     	2 points.
	System.out.println(map.get("Ron"));     	//  Hermione  	2 points.
	System.out.println(map.get("Voldemort"));   //  null      	2 points.
	System.out.println(map.get(null));      	//  null      	2 points.

	try
	{
  	map.put("Draco", "Pansy");
	}
	catch (IllegalStateException minnesota)
	{
  	System.out.println("No Draco");       	//  No Draco  	2 points.
	}
  }
}




