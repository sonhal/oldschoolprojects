/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservertest;

/**
 *
 * @author sonhal
 */


import java.net.*;
import java.io.*;

public class Client {
    
  
    
 static void reciveMessage(Socket socket, BufferedReader in)throws IOException {
     String textIn;
     
     textIn = in.readLine();
     
     if(textIn != null){  
    System.out.println("Server [" + socket.getInetAddress() +  ":" + socket.getPort() +"] > " + textIn); 
    
       }          
 }
 
 static void sendMessage(BufferedReader stdIn,PrintWriter out ) throws IOException {
     String textOut;
     textOut = stdIn.readLine();
     
     if(textOut != null){
     out.println(textOut);
     out.flush();
     }
 }
    
    
static void chat(Socket cs,PrintWriter ot,BufferedReader i,BufferedReader stdI){
        
        
        
        try{Socket socket = cs;
            
            PrintWriter out = ot;
            
            BufferedReader in = i;
            
            BufferedReader stdIn = stdI;
               
                
                
            while (true)
                          {
                
                // read from the socket and display
                reciveMessage(socket, in);
                
                // write keyboard input to the socket
                sendMessage(stdIn, out);
 
                           }
            
            
        
                }catch(IOException e){
                 System.out.println("ERROR");
                }
    }
    
 
static void runClient() {
     
        
      String hostName = "127.0.0.1"; // Default host, localhost
      int port_number = 5655; // Default port to use
      boolean loggedIn = false;

        
        try {
            
            Socket clientSocket = new Socket(hostName,port_number);
            
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            ObjectOutputStream objOut = new ObjectOutputStream(clientSocket.getOutputStream());
        
        
            String userInput;
            String receivedText;
            
            if(clientSocket.isConnected() != false){
                 System.out.println("I (Client) [" + InetAddress.getLocalHost()  + ":" + clientSocket.getLocalPort() + "] > Connected ");
            
                 
                 System.out.println("Type Username");
                String login = stdIn.readLine();
                
                if(login != null) {
                    
                    System.out.println("Password: ");
                    login += stdIn.readLine();
                    
                    objOut.writeObject(login);
                    loggedIn = true;
                }
            }
            
            
            
              while(loggedIn){
                  chat(clientSocket, out, in, stdIn);
              }
              
             closeClient(clientSocket, out, in, stdIn);
                    
                    
                
           
            
            
            
            
            
            
        }catch( IOException e ){
            e.printStackTrace();
            System.err.println("Unknown host " + hostName);
            System.exit(1);
        }
        
        
        
}
    
    
static void closeClient(Socket socket,PrintWriter out,BufferedReader in,BufferedReader stdIn){
   
   try{ 
    
    in.close();
    out.close();
    stdIn.close();
    socket.close();
   }catch(IOException e){
       e.printStackTrace();
   }
}


    public static void main(String[] args) throws IOException {
        
       runClient();
    }
    
    
    
}
