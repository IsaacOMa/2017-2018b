public class PollyEsther  
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

