
package main;


public class ChemicalElement {
    private int atomicNmbr;
    private String symbol;
    private int group;
    private int period;
    
    public ChemicalElement(int atomicNmbr, String symbol, int group, int period){
        this.atomicNmbr = atomicNmbr;
        this.symbol = symbol;
        this.group = group;
        this.period = period;
    }
    
   @Override
    public String toString() {
	        return "" + atomicNmbr + ", " + symbol + ", " + group + ", " + period;
	    }
    
    public String getInfo(){
                
                String utskrift = "";
                
                utskrift = "atomicNmbr " + atomicNmbr + "symbol " + symbol + "group " + group + "period " + period;
                return utskrift;
	    }
	
    public void setAtomicNmbr(int atomicNmbr){
                this.atomicNmbr = atomicNmbr;
            }
            
            public void setGroup(int group){
                this.group = group;
            }
            
            public void setSymbol(String symbol){
                this.symbol = symbol;
            }
            
             public void setPeriod(int period){
                this.period = period;
            }
}

