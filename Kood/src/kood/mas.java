
package kood;


public class mas {
    public enum kas{MOR,FAR,BARN};
    private kas type;
    
    
    public void maas(){
        System.out.println("Tast 1 eller noe annet");
    }
    
    public mas(kas t){
        t = type;
    }
    
    public kas getType(){
      
      return type;
          
    }
}
