
package object;

public class Person {
   private int alder;
   private String navn;
   
   public static final String slogan = "what";
   
   public Person(int a){
       setalder(a);
   }
   
   
   public String getnavn(){
       return navn;
   }
   
   public String setnavn(String a){
       return navn;
   }
    
    public int getalder(){
        return alder;
    }
    
    public void setalder(int a){
        if(a < 0){
            alder = 0;
        }  
        else{
          alder = a;
        }
    }
}
