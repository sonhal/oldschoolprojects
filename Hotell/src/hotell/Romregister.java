
package hotell;

/**
 *
 * @author sonhal
 */

public class Romregister
{
  private Rom[] alleRom;

  public Romregister( Rom[] r )
  {
    alleRom = r;
  }

  public String beboerLogg( long pnr )
  {
    for(int i = 0; i < alleRom.length; i++){
      if(alleRom[i].getBeboer().getPnr() == pnr){
        return alleRom[i].getBeboer().loggBok();
      }
    }
    return  "Ukjent personnummer";
    
  }

  public Rom finnRom( long pnr )
  {
    for(int i = 0; i < alleRom.length; i++){
    if(alleRom[i].getBeboer().getPnr() == pnr){
      return alleRom[i];
      }
    }
    return null;
  
  }

  //public Beboer finnBeboer( long pnr )
 // {

      //NB! Denne metoden skal IKKE programmeres. >
 // }

  public String nyBeboer( String navn, long pnr )
  {
    if(finnRom(pnr) != null){
      return "Personen eksisterer allerede og bor i: " + finnRom(pnr).getRomNr() + ".";
    }
    for(int i = 0; i < alleRom.length; i++){
      if(alleRom[i].getBeboer() == null){
       Beboer nyBeboer = new Beboer(navn, pnr, alleRom[i]);
       
        alleRom[i].flyttInn(nyBeboer);
        return "En ny beboer har blitt lagt han heter: " + nyBeboer.getNavn() + " og bor på rom nr: " + alleRom[i].getRomNr();
      }
    }
    return "Ingen rom ledige";
  }

 /* public String utflytting( long nr )
  {
    < Metoden skal IKKE programmeres. >
  }

  public String ut( long pnr, String s)
  {
   < Metoden skal IKKE programmeres. >
  }

  public String inn( long pnr, String s )
  {
    < Metoden skal IKKE programmeres. >
  }

  public String besøkInn( long pnr, String melding, String gjest )
  {
    < Metoden skal IKKE programmeres. >
  }

  public String besøkAvsluttet( long pnr, String melding )
  {
    < Metoden skal IKKE programmeres. >
  }

  public String visArkiv()
  {
    < Metoden skal IKKE programmeres. >
  }*/
  
} 
	  









