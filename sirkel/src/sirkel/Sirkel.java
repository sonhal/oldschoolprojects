
package sirkel;


public class Sirkel {
    private double radius;
    
    
    public Sirkel(double a){
       setradius(a);
   }

    
    
    public double getradius(){
       return radius;
   }
    
    
    private void setradius(double a){
        if(a < 0){
            radius = 0;
        }  
        else{
          radius = a;
        }
        
        
    double diameter = radius * 2;
    double omkrets = diameter * Math.PI;
    double areal = radius * radius * Math.PI;
        
        
     System.out.println("Sirkelens radius er: " + radius);
     System.out.println("Sirkelens diameter er: " + diameter);   
     System.out.println("Sirkelens areal er: " + areal);
     System.out.println("Sirkelens omkrets er: " + omkrets);
    }
    
    
    
    
    
}
