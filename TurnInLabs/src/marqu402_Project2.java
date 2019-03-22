
class Poly {
    private class Term { //This will set up the nodes
        private int coef;
        private int expo;
        private Term next;
        public Term (int coef, int expo, Term next) {
            this.coef = coef;
            this.expo = expo;
            this.next = next;
        }
    }
    
    private Term first;
    private Term last;
    
    public Poly () {
        first = last = new Term(0, Integer.MAX_VALUE, null); //first and last point to the same instance

    }
    
    public boolean isZero() { //checks if there are any terms
        return first == last;
    }
    
    public Poly minus() {
        Term temp = this.first.next;
        Poly result = new Poly ();
        while(temp != null) {
            int coeff = temp.coef * -1; //multiplies the coefficient by -1
            result.last.next = new Term(coeff, temp.expo, null); //the next term points to the coefficient
            result.last = result.last.next; //the current term now points to the next term
            temp = temp.next; //temp now points to the next term
        }
        return result;
    }
    
    public Poly plus (Poly that) {
        Poly result = new Poly();
        Term left = first.next; //points to the poly that called the method
        Term right = that.first.next; //points to the poly in the parameter
        while (left != null && right != null) { //both are not null
        	if (left.expo > right.expo) { 
        		result.last.next = new Term(left.coef, left.expo, null); //if left expo is greater than right, then left is added to the poly 
                result.last = result.last.next;
                left = left.next; //left and result advance to the next term
        	}
        	else if (right.expo > left.expo) { //similar to if left is greater than right, but in this case right is greater than left
                result.last.next = new Term(right.coef, right.expo, null);
                result.last = result.last.next;
                right = right.next;
            }
        	else { //if the terms' expos are equal, then they are added together
                int newCoef = right.coef + left.coef;
                if (newCoef != 0 ) { //if coef is not 0, then a new term is appended to result
	                result.last.next = new Term(newCoef, left.expo, null);
	                result.last = result.last.next;
                }
                right = right.next;
                left = left.next; //both left and right now point to next terms
            }
            
        }
	        while (left != null) { //right is null, while left is not null, its terms are appended to result
	    		result.last.next = new Term(left.coef, left.expo, null);
	            result.last = result.last.next;
	            left = left.next;
	    	}
        	while (right != null) { //left is  null, while right is not null, its terms are appended to result
        		result.last.next = new Term(right.coef, right.expo, null);
                result.last = result.last.next;
                right = right.next;
        	}
        return result;
    }
    
    public Poly plus (int coef, int expo) {
        if (coef == 0 || expo >= last.expo || expo <= -1) { //if the term is invalid, an exception is thrown
            throw new IllegalArgumentException();
        }
        else {
            this.last.next = new Term(coef, expo, null); //otherwise the term is appended
            this.last = this.last.next;
        }
        return this;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Term temp = this.first.next;
        if (first == last) { //if there are no terms, returns 0
        	builder.append(0);
        }
        else {
	        while(temp != null) {
	        	if (temp != null && temp.coef < 0 && temp == first.next) { //If the first term is negative, has "-" with no spaces
	            	builder.append("-");
	            }
	        	else if (temp != null && temp.coef < 0) { //If any other term is negative, has " - " with spaces
	            	builder.append(" - ");
	            }
	        	if (temp != null && temp != first.next && temp.coef > 0) { //If any term except first is greater than 0, then " + "
	            	builder.append(" + ");
	            }
	            builder.append(Math.abs(temp.coef));
	            builder.append("x");
	            builder.append(temp.expo); //appends the other characteristics to the builder
	            temp = temp.next;
	        }
        }
        return builder.toString();
    }    
}


class PollyEsther  
{  
  public static void main(String[] args)  
  {  
    Poly p = new Poly().plus(3,5).plus(2,4).plus(2,3).plus(-1,2).plus(5,0);  
    Poly q = new Poly().plus(7,4).plus(1,2).plus(-4,1).plus(-3,0);  
    Poly z = new Poly();  
  
    System.out.println(p);  
    System.out.println(q);              
    System.out.println(z);               
  
    System.out.println(p.minus());         
    System.out.println(q.minus());         
    System.out.println(z.minus());         
  
    System.out.println(p.plus(q));          
    System.out.println(p.plus(z));         
    System.out.println(p.plus(q.minus())); 
  }  
}



