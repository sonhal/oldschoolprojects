
package hotell;


public class Beboer {
    
    private String navn;
    private long pNr;
    private Rom rom;
    private Logg logg;
    private String gjest;
    
    
    public Beboer(String n, long p, Rom r){
        navn = n;
       pNr = p;
       rom = r;
        
    }
   
    public String getNavn() {
        return navn;
    }
    
    public long getPnr() {
        return pNr;
    }
    
    public Rom getRom() {
        return rom;
    }
    
    public void setGjest(String guest){
        gjest = navn;
    }
    
    public void slettGjest(){
        gjest = null;
    }
    
    public void nyRapport(String rapport){
        logg.nyRapport(rapport);
    }
    
    public String toString(){
        String beboerinfo = "Navn: " + getNavn() + "\nPersonnummer: " + getPnr();
    return beboerinfo;
    }
    
    public String loggBok(){
        String loggRom = toString() + "\nRom: " + getRom() + logg.toString();
    return loggRom;
    }
    
    
}

