package marqu402_lab6;



public class dividers {
	public static void main (String args[]) {
		int count = 0;
		for (int i = 1; i <= 2011; i +=1) {
			if ((i % 3 == 0 || i % 4 == 0) && (i%3 != 0 || (i%4 != 0)) && i% (3*5) != 0 && i% (4*5) != 0) {
				count +=1;
			}
		}
		
		System.out.println(count);
	}
}
