/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservertest;

import java.io.*;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonhal
 */
public class ClientConnection extends Thread {
    
    Socket socket;
    MultiClient client;
    DataInputStream in;
    DataOutputStream out;
    BufferedReader stdIn;
    ObjectInputStream objIn;
    
    public ClientConnection (Socket socket, MultiClient client){
        this.socket = socket;
        this.client = client;
    }
    
    
    void reciveMessage()throws IOException {
     String textIn = "";
     
     
     textIn = in.readUTF();
     
     if(textIn != null){
     
    System.out.println("Server [" + socket.getInetAddress() +  ":" + socket.getPort() +"] > " + textIn); 
     }
                
 }
    
    void sendMessage(String a){
     
     
     if(a != null){
         try {
             out.writeUTF(a);
             out.flush();
          System.out.println("Message from client sent");   
         } catch (IOException ex) {
             ex.printStackTrace();
         }
     
     a = null;
     }
 }
    
    
    public void run(){
        
        try {
            in = new DataInputStream(socket.getInputStream());
           // out = new DataOutputStream(socket.getOutputStream());
         //    objIn = new ObjectInputStream(socket.getInputStream());
            //stdIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("run");
            
            while(true){
                System.out.println("run while");
               String input;   
               input = in.readUTF();
               System.out.println(input);
            if(input == null ){
                 System.out.println("No message");
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
            }   
            
            else{
              System.out.println(input);
             /* System.out.println("we got some message");
              String input = "";
              input =  in.readUTF();
              System.out.println(input);
               */ 
            } 
            
            
            }
        } catch (IOException ex) {
            
            ex.printStackTrace();
            closeClient();
        }

    }
     void closeClient(){
   
   try{ 
    
    in.close();
    out.close();
  
    socket.close();
   }catch(IOException e){
       e.printStackTrace();
   }
}

}