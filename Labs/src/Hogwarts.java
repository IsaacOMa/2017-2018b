
public class Hogwarts //CHANGE THIS BACK TO HOGWARTS WHEN DONE
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