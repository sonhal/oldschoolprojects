

package pokemon;

import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       
       System.out.println("velg Pokemon:\n");
       System.out.println("1.Charmander");
       System.out.println("2.Squirtle");
       System.out.println("3.Bulbasaur");
       System.out.println("4.Pikachu");
       
       int valg = in.nextInt();
       
       Pokemon player;
       Pokemon enemy = new Pokemon(1,20,"Zubat",Pokemon.Type.DARK);
       
       if (valg == 1){
           player = new Pokemon(1, 100, "Charmander", Pokemon.Type.FIRE);
       }
       else if(valg == 2){
           player = new Pokemon(1, 100, "Squirtle", Pokemon.Type.WATER);
       }
       
       else if(valg == 3){
           player = new Pokemon(1, 100, "Bulbasaur", Pokemon.Type.GRASS);
       }
       
       else {
           player = new Pokemon(1, 100, "Pikachu", Pokemon.Type.ELECTRICITY);
       }
       
    System.out.println("A wild " + enemy.getName() + " appears");
    
    double enemyHp = enemy.getHp();
    boolean kanStikkeAv = false;
    
    while(enemyHp > 0 && !kanStikkeAv){
        System.out.println("1.Angrip");
        System.out.println("2.Run");
        
        int battleValg = in.nextInt(); //int for å lagre valg
        
        if(battleValg == 1){
        enemyHp = player.attack(enemy);
        System.out.println("Attack was effective, remaining health " + enemyHp);
        }
        
        else{
            kanStikkeAv = player.run();
            if(kanStikkeAv == true){
                System.out.println("Player ran away");
            }
            else{
                System.out.println("Couldn't run away");
            }
        }
    }
    
    if(enemyHp <= 0){
        System.out.println("You win");
    }
    else{
        System.out.println("You lose");
    }
    }
    
}
