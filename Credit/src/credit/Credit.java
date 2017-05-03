/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package credit;

/**
 *
 * @author sonhal
 */
public class Credit {

    
    public static void main(String[] args) {
       int accNr= 20202;
       int balance = 25000;
       int charged= 250000;
       int credits= 300;
       int limit = 200000;
       
       int endBlnc =  balance + charged - credits;
       
       
       if(endBlnc > limit){
           System.out.println("Credit limit exceeded");
       }
       else
           System.out.println("Credit OK");
    }
    
}
