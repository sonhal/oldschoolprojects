
package Examen2014;

/**
 *
 * @author sonhal
 */
import java.util.Calendar;
public class Reperasjon {
    private Calendar OppdragsDato;
    private boolean utført;
    private boolean EUkrav;
    private String reparer;
    private int OppdragsNr;
    
    
    
    public Reperasjon(String a, boolean krav) {
    OppdragsDato = Calendar.getInstance();
    a = reparer;
    krav = EUkrav;
    
    }
    
    public String toString(){
        SimpleDateFormat df = new SimpleDateFormat( "dd.MM.yy");
      return = "Dato for oppdraget = " + df.format(OppdragsDato.getTime()) +
              "OppdragsNr = " + OppdragsNr + "/n" + "Beskrivelse = " + reparer +
    }
}
