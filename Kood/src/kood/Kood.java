/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kood;


import java.util.Scanner;
public class Kood {

    
    public static void main(String[] args) {
        mas b = new mas(mas.kas.FAR);
        mas a = new mas(mas.kas.BARN){
          @Override  public void maas(){
                System.out.println("Type in what you want");
            }
        };
        
        b.maas();
        
        Scanner in = new Scanner(System.in);
        double valg = in.nextDouble();
        
        
        
        if(valg == 1){
        b.maas();
        }
        
        else {
        a.maas();
        
        Scanner in2 = new Scanner(System.in);
        double valg2 = in2.nextDouble();
        
       mas man;
       if(valg2 == 1){
         man = new mas(mas.kas.MOR);
         System.out.println(man.getType());
       }
       
       else{
         man = new mas(mas.kas.BARN);
         System.out.println(man.getType());
       }
       System.out.println(man.getType());
        }
        
    
}
}