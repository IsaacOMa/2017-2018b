

class Poly {
    private class Term {
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
        first = last = new Term(0, Integer.MAX_VALUE, null);

    }
    
    public boolean isZero() {
        return first == last;
    }
    
    public Poly minus() {
        Term temp = this.first.next;
        Poly result = new Poly ();
        while(temp != null) {
            int coeff = temp.coef * -1;
            result.last.next = new Term(coeff, temp.expo, null);
            result.last = result.last.next;
            temp = temp.next;
        }
        return result;
    }
    
    public Poly plus (Poly that) {
        Poly result = new Poly();
        Term left = first.next;
        Term right = that.first.next;
        while (left != null && right != null) {
        	if (left.expo > right.expo) { 
        		result.last.next = new Term(left.coef, left.expo, null);
                result.last = result.last.next;
                left = left.next;
        	}
        	else if (right.expo > left.expo) {
                result.last.next = new Term(right.coef, right.expo, null);
                result.last = result.last.next;
                right = right.next;
            }
        	else {
                int newCoef = right.coef + left.coef;
                if (newCoef != 0 ) {
	                result.last.next = new Term(newCoef, left.expo, null);
	                result.last = result.last.next;
                }
                right = right.next;
                left = left.next;
            }
            
        }
	        while (left != null) {
	    		result.last.next = new Term(left.coef, left.expo, null);
	            result.last = result.last.next;
	            left = left.next;
	    	}
        	while (right != null) {
        		result.last.next = new Term(right.coef, right.expo, null);
                result.last = result.last.next;
                right = right.next;
        	}
        return result;
    }
    
    public Poly plus (int coef, int expo) {
        if (coef == 0 || expo >= last.expo || expo <= -1) {
            throw new IllegalArgumentException();
        }
        else {
            this.last.next = new Term(coef, expo, null);
            this.last = this.last.next;
        }
        return this;
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Term temp = this.first.next;
        if (first == last) {
        	builder.append(0);
        }
        else {
	        while(temp != null) {
	        	if (temp != null && temp.coef < 0 && temp == first.next) {
	            	builder.append("-");
	            }
	        	else if (temp != null && temp.coef < 0) {
	            	builder.append(" - ");
	            }
	        	if (temp != null && temp != first.next && temp.coef > 0) {
	            	builder.append(" + ");
	            }
	            builder.append(Math.abs(temp.coef));
	            builder.append("x");
	            builder.append(temp.expo);
	            temp = temp.next;
	            while (temp != null && temp.coef == 0) {
	            	temp = temp.next;
	            }
	        }
        }
        return builder.toString();
    }    
}




