package hotell;

public class Rom {

    private int romNr;
    private int status;
    private Beboer beboer; // hvis beboer == null er rommet ledig
    private JTextArea display;
    private String arkiv = "";
    public static final int LEDIG = 0, INNE = 1, UTE = 2, BESØK = 3;

    

  
   public int getRomNr() {
        return romNr;
    }
   
   public String getArkiv() {
        return arkiv;
    }
   
   public Beboer getBeboer() {
        return beboer;
    }

   
    public String status() {
        switch (status){
      case LEDIG : return "LEDIG";
      case INNE : return "INNE";
      case UTE : return "UTE";
      case BESØK : return "BESØK";
      default : return "????";
        }
            }

  public boolean ledig() {
      if(beboer == null){
        return true;
       }
      else return false;
      
          
  }

  public void oppdaterRomStatus(String melding, int st) {
       status = st;
    if(beboer != null){
      beboer.nyRapport( "\nStatus: " + status() + "\n" + melding);
      if(ledig()){
        display.setText("LEDIG");
      }
      else{
        display.setText("Beboer: " + beboer.getNavn() + "\nPersonnummer: " + beboer.getPnr() + "Romstatus: " + status() + "");
      }
    } 

   
  }

  public boolean flyttInn(Beboer ny) {
         if(ledig()){
      beboer = ny;
      oppdaterRomStatus((ny.getNavn() + " har flyttet inn i rom:" + romNr + "."), INNE);
      return true;
    }
    return false;
  }

  public void flyttUt() {
      arkiv += beboer.loggBok();
    oppdaterRomStatus((beboer.getNavn() + "har flyttet ut av rom: " + romNr + "."), LEDIG);
    beboer = null;
    display.setText("LEDIG");
    }

  /*  public String gårUt(String s) {
         Metoden  skal IKKE programmeres
  }
*/
  /*public String gårInn(String s) {
        Metoden  skal IKKE programmeres
    
  }*/

  public String fårBesøk(String melding, String g) {
         if(status == INNE){
      status = BESØK;
      beboer.setGjest(g);
      beboer.nyRapport(beboer.toString() + "Rom: " + romNr + "\nStatus: BESØK\n" + melding);
      display.setText("BESØK");
      return (beboer.getNavn() + " har fått besøk av " + g + " på rom " + romNr + ". Besøket er registrert.");
    }
    else{
      switch(status){
        case LEDIG : return "Besøket har ikke blitt registrert fordi: Rommet er ledig.";
        case UTE : return ("Besøket har ikke blitt registrert fordi: " + beboer.getNavn() + " er ute.");
        case BESØK : return ("Besøket har ikke blitt registrert fordi: " + beboer.getNavn() + " har allerede besøk.");
        default : return "Besøket har ikke blitt registrert fordi: Ukjent grunn.";
      }
    }
    }

    public String besøkSlutt(String melding) {
       if(status == BESØK){
      status = INNE;
      beboer.slettGjest();
      beboer.nyRapport(beboer.toString() + "Rom: " + romNr + "\nStatus: INNE\n" + melding);
      display.setText("INNE");
      return (beboer.getNavn() + " har avsluttet sitt besøk på rom " + romNr + ". Hendelsen har blitt registrert.");
    }
    else{
      switch(status){
        case LEDIG : return ("Besøket har ikke blitt registrert fordi: Rommet er ledig.");
        case UTE : return ("Besøket har ikke blitt registrert fordi: " + beboer.getNavn() + " er ute.");
        case INNE : return ("Besøket har ikke blitt registrert fordi: " + beboer.getNavn() + " ikke har et besøk.");
        default : return "Besøket har ikke blitt registrert fordi: Ukjent grunn.";
      }
    }
    
    }
} // end of class Rom


