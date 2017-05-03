
package sirkel;


public class SirkelTest {

    
    public static void main(String[] args) {
      Sirkel p = new Sirkel(5);
      Sirkel p2 = p;
      
      
      p2.getradius(4);
      
      System.out.println(p2.getradius());
      
      
      
    }
    
}
