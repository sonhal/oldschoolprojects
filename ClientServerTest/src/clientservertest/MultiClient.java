/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservertest;

import java.io.BufferedReader;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonhal
 */
public class MultiClient {
    
   Socket clientSocket;
   BufferedReader stdIn;
   ObjectOutputStream objOut;
   ClientConnection cc;
   DataOutputStream out;
   DataInputStream in;
 
 public MultiClient() {
     
        
      String hostName = "127.0.0.1"; // Default host, localhost
      int port_number = 4400; // Default port to use
      
     

        
        try {
            
             clientSocket = new Socket(hostName,port_number);
             out = new DataOutputStream(clientSocket.getOutputStream());
             in = new DataInputStream(clientSocket.getInputStream());
             objOut = new ObjectOutputStream(clientSocket.getOutputStream());
             stdIn = new BufferedReader(new InputStreamReader(System.in));
             
           // ObjectOutputStream objOut = new ObjectOutputStream(clientSocket.getOutputStream());
            cc = new ClientConnection(clientSocket, this);
            
            System.out.println("I (Client) [" + InetAddress.getLocalHost()  + ":" + clientSocket.getLocalPort() + "] > Connected ");
        
            
          
           
        }catch( IOException e ){
            e.printStackTrace();
            System.err.println("Unknown host " + hostName);
            closeClient();
       
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
 
 
 public boolean login(){
     
         
         try{
              
                System.out.println("Type Username");
                String login;
                
                while(true){
                       
                
                if(stdIn.ready() != false) {
                    login = stdIn.readLine();
                    System.out.println("Password: ");
                    login += stdIn.readLine();
                    
                    objOut.writeObject(login);
                    
                    return true;
                }
                else{
                    
                          try {
                               Thread.sleep(1);
                           } catch (InterruptedException ex) {
                               Logger.getLogger(MultiClient.class.getName()).log(Level.SEVERE, null, ex);
                           }
                } 
                }
                
         
       }catch(IOException e){
           e.printStackTrace();
       }
            return false; 
}   
          
            
          
         
 
 
 public void listenForInput(boolean login){
        if(login == true){
            
              cc.start();  
                  
            try {
                boolean sleep = true;
             while(true){
                 
                if(stdIn.ready() == false){
                    if(sleep == true){
                    System.out.println("we sleep");
                    }
                    Thread.sleep(1);
                    
                    sleep = false;
                }
                else{
                 System.out.println("we sending message");
                 String s = stdIn.readLine();
                 sleep = true;
               //  sendMessage(s);
                }
            }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                 ex.printStackTrace();
            }
            
                 
              }
        else{
            System.out.println("Cant log in");
            closeClient();
        }
        
        
 }
 
 void closeClient(){
   
   try{ 

    out.close();
    stdIn.close();
    clientSocket.close();
   }catch(IOException e){
       e.printStackTrace();
   }
}


    public static void main(String[] args) throws IOException {
        
      MultiClient c = new MultiClient();
      
      boolean logged = true;
     // logged = c.login();
      
      c.listenForInput(logged);
      
    }
    
    
    
}
