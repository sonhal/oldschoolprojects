/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservermultithreadexperimental;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author sonhal
 */
public class Client {
    
    
    
   Socket clientSocket;
   BufferedReader stdIn;
  
   ClientInput clientInput;
   ClientOutput clientOutput;
   DataOutputStream out;
   DataInputStream in;
    
     public Client() {
     
        
      String hostName = "127.0.0.1"; // Default host, localhost
      int port_number = 4444; // Default port to use
      
     

        
        try {
            
             clientSocket = new Socket(hostName,port_number);
             
           
             
           
            clientInput = new ClientInput(clientSocket);
            clientOutput = new ClientOutput(clientSocket);
            
            System.out.println("I (Client) [" + InetAddress.getLocalHost()  + ":" + clientSocket.getLocalPort() + "] > Connected ");
        
            
          
           
        }catch( IOException e ){
            e.printStackTrace();
            System.err.println("Unknown host " + hostName);
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
    
   
  
  public static void main(String[] args) {
      
        Client client = new Client();
        client.clientInput.start();
        client.clientOutput.start();
    }
    
}
