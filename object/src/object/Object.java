
package object;


public class Object {

    
    public static void main(String[] args) {
        Person p = new Person(-8);
        
       Person p2 = new Person(0);
        //Person p3 = p;
      Person.slogan ="hehehe";
      //p.alder = 8;
      System.out.println(Person.slogan);
      System.out.println(Person.slogan);
      System.out.println(p.getalder());
       
      
      System.out.println(p.getnavn());
       
    }
    
}
