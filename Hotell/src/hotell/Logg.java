
package hotell;



import java.util.*;

public class Logg
{
  private String[] rapporter;
  private int antall;   
  public static final int ARRAYLENGDE = 100;
  public static final int UTVIDELSE = 10;

  public Logg(){
    antall = 0;
    rapporter = new String[ARRAYLENGDE];
  }

  public String toString()
  {
    String allerapportene = "";
    for(int i = 0; i < rapporter.length; i++){
      if( rapporter[i] != null ){
        allerapportene += rapporter[i] + "\n";
      }
    }
    return allerapportene;    

   
  }

  public void utvidArray()
  {
      String[] utvidetarray = new String[rapporter.length + UTVIDELSE];
      System.arraycopy(rapporter, 0, utvidetarray, 0, rapporter.length);
      rapporter = utvidetarray;
    
  }
  static Calendar calendar;
  public void nyRapport( String melding )
  {
    calendar = new GregorianCalendar(); 
    String rapport = "Dato: " + calendar+ "\n" + melding;
    boolean sjekkarray = (rapporter[rapporter.length - 1]) != null;
    if(sjekkarray){
      utvidArray();
    }
    
    
    for(int i = 0; i < rapporter.length; i++){
      if(rapporter[i] == null){
        rapporter[i] = rapport;
        return;
      }
    }
   
  }
} // end of class Logg
