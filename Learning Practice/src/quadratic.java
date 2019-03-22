import java.util.Scanner;


public class quadratic {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Greetings! This is meant to give the answer using a quadratic equation!");
		System.out.println("To get started, print out an equation compatible with the basic quadratic formula.");
		System.out.println("Note - Only whole numbers are accepted.");
		boolean valid = false;
		String proposed = scan.nextLine();
		int i = 0;
		boolean superValid = false;
		boolean confirmed = false;
		int p = 0;
		
		
		
		while (superValid = false || p < proposed.length()) {
			
			
			
		if (confirmed = false) {
		while (valid = false || i < proposed.length()) {
			
			int subbed = proposed.charAt(i);
			if (subbed != 32 && subbed != 43 && subbed != 45 && subbed != 47 && subbed != 42 && subbed != 94 && 
					subbed != 120 && (subbed <= 48 || subbed >= 57)) {
				i = 0;
				System.out.println("That was an invalid equation");
				proposed = scan.nextLine();
				
			}
			else
				i++;
		
		}
		if (i == proposed.length() - 1) {
			confirmed = true;
		}
		}
		
		
		
		
		
		if ((proposed.charAt(p) < 48 || proposed.charAt(p) > 57) && proposed.charAt(p) != 120) {
			System.out.println("That was an invalid equation");
			p = 0;
			i = 0;
			confirmed = false;
			proposed = scan.nextLine();
			
		}
		else
			p++;
		
		
		if (proposed.charAt(p) >= 48 && proposed.charAt(p) <= 57) { //this needs to be separate from the other one I think
			while (proposed.charAt(p) >= 48 && proposed.charAt(p) <= 57) {
				p++;
			}
			if (proposed.charAt(p) != 120) {
				p = 0;
				i = 0;
				confirmed = false;
				proposed = scan.nextLine();
			}
		}
		if (proposed.charAt(p) == 120) { //this should be going well, not sure if I should use the execution class (look into)
			
		}
		
	}
}