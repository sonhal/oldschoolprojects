
package job;

/**
 *
 * @author sonhal
 */
public class Job {

    
    public static void main(String[] args) {
        CommissionEmployee mas = new CommissionEmployee("Jon", "Kok",999,1000.0,0.1);
        BasePlussCommision mas2 = new BasePlussCommision("Birk", "Ottesen",999,1000.0,0.2,1000);
        
        
        mas.setFirstName("Jon");
        mas.setLastName("Mas");
        
        System.out.println(mas.toString());
        System.out.println(mas2.toString());
        System.out.println(mas2.equals(mas));
                
    }
    
}
