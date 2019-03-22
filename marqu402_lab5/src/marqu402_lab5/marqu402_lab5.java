package marqu402_lab5;
class marqu402_lab5{
    
	boolean[] numbers;
    
	public marqu402_lab5 (int max) {
    	numbers = new boolean[max];
    	if (max < 2){
        	throw new IllegalArgumentException();
    	}
    	numbers[0] = false; 	//sets the indices 0 and 1 to false
    	numbers[1] = false;
    	for (int i = 2; i < max; i++) { 	//sets all other indices to true
        	numbers[i] = true;
    	}
	}
    
    
	public void findPrimes() {
    	for (int k = 0; k < numbers.length; k++) {  	//for each index of the array
        	if (numbers[k]) {
            	int n = 2;
            	while ((k * n) < numbers.length) {  	//while the multiples of a number are lower than max
                	numbers[k * n] = false;
                	n++;    	//multiple + 1
            	}
        	}
    	}
	}
    
    
	public String toString () {
    	String str = new String ("");
    	for (int i = 0; i < numbers.length; i++) {
        	if (numbers[i]) {   	//for each true element of numbers, if true add the index to str
            	str = str + " " + i;
        	}
    	}
    	return str;
	}
}



//
//  SIEVE. The Sieve of Eratosthenes.
//
//	James B. Moen
//	8 Oct 18
//
//  Test the SIEVE class, for 30 points total.
//

//  DRIVER. Run SIEVE on some examples.

public class Driver
{

//  MAIN. Find some primes.

  public static void main(String [] args)
  {
	marqu402_lab5 sieve = null;  //  We must initialize SIEVE or Java will cry.

//  5 points. This must print "Sieve size must be at least 2." but without the
//  quotes.

	try
	{
  	sieve = new marqu402_lab5(0);
	}
	catch (IllegalArgumentException oops)
	{
  	System.out.println("Sieve size must be at least 2.");
	}

//  5 points. This must print nothing.

	try
	{
  	sieve = new marqu402_lab5(100);
	}
	catch (IllegalArgumentException oops)
	{
  	System.out.println("Sieve size must be at least 2.");
	}

//  10 points. This must print integers from 2 to 99, separated by blanks.

	System.out.println(sieve);

//  10 points. This must print the prime numbers between 2 and 99, separated by
//  blanks. They are:
//
//  2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

	sieve.findPrimes();
	System.out.println(sieve);
  }
}


