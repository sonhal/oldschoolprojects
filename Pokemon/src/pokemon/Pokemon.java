
package pokemon;


public class Pokemon {
    
    public enum Type {FIRE, WATER, GRASS,ELECTRICITY,DARK }
    private int level;
    private double hp;
    private String name;
    private Type type;
    
    
    public Pokemon(int l,double h,String n,Type t){
        level = l;
        hp = h;
        name = n;
        type = t;               
    }
    
    public void setLevel(int l){
        level = l;
    }
    
    public void setName(String n){
        name = n;
    }
    
    public void setHp(int t){
        hp = t;
    }
    
    public int getLevel(){
        return level;
    }
    
    public double getHp(){
        return hp;
    }
    
    public String getName(){
        return name;
    }
    
    public double attack(Pokemon enemy){
        double hit = Math.random() * 10; // Generert random tall mellom 0-10 lagret i hit
        enemy.hp -= hit; 
        return enemy.hp;
    }
    
    public boolean run(){
        boolean b = Math.random() > 0.5;
        
        return b;
    }
}
