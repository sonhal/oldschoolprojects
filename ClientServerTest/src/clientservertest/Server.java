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
public class Server {
    
 
       
 static void reciveMessage(ServerSocket socket, BufferedReader in)throws IOException {
     String textIn;
     
     textIn = in.readLine();
     
     if(textIn != null){
     System.out.println("Client [" + socket.getInetAddress() +  ":" + socket.getLocalPort() +"] > " + textIn); 
     }
    
 }
 
 static void sendMessage(BufferedReader stdIn,PrintWriter out ) throws IOException {
     String textOut;
     textOut = stdIn.readLine();
     if(textOut != null){
     System.out.println("Server - " + textOut);
     out.println(textOut);
     out.flush();
     }
 }
    
    
   static void user(ServerSocket ss, Socket cs, PrintWriter o, BufferedReader i, BufferedReader stdi){
   
        
         try(

                // Create server socket with the given port number
                ServerSocket serverSocket = ss;
                        
                // create connection socket, server begins listening
                // for incoming TCP requests
                Socket connectSocket = cs;

                // Stream writer to the connection socket
                PrintWriter out = o;
                        
                // Stream reader from the connection socket
                BufferedReader in = i;
                    // Keyboard input reader
                BufferedReader stdIn = stdi;
                
                 ){
                InetAddress clientAddr = connectSocket.getInetAddress();
                int clientPort = connectSocket.getPort();
                
                String ServerInput;
                  while (true)
            {
                // read from the socket and display
                reciveMessage(serverSocket, in);
                
                //send to socket and display
                sendMessage(stdIn, out);
  
            }
         }catch(IOException e) {
             System.out.println("ERROR");
         }        
    }
    
   static boolean reader(String user){
        String usr = user;
        String ln;
        boolean isEq = false;
        try(
                BufferedReader read = new BufferedReader(new FileReader("fil.txt"));
           )
        {
            
            while((ln = read.readLine()) != null){
        
               if(usr.equals(ln)){
                   
                   
                 isEq = true;
                 
                     }
               
        }
        }
        catch (IOException e){
        			e.printStackTrace();
        }
        
        
        return isEq;
        
        
    }
    
   public static void runServer(){
         int portNumber = 5655; // Default port to use

        

        System.out.println("Hi, I am EchoUCase TCP server");

        // try() with resource makes sure that all the resources are automatically
        // closed whether there is any exception or not!!!
        try (
                // Create server socket with the given port number
                ServerSocket serverSocket =
                        new ServerSocket(portNumber);
                // create connection socket, server begins listening
                // for incoming TCP requests
                Socket connectSocket = serverSocket.accept();

                // Stream writer to the connection socket
                PrintWriter out =
                        new PrintWriter(connectSocket.getOutputStream(), true);
                // Stream reader from the connection socket
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connectSocket.getInputStream()));
                    // Keyboard input reader
                BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
                
               ObjectInputStream objIn = new ObjectInputStream(connectSocket.getInputStream());
                        
                        
        
        )
      
            
            
            
            
          {
            InetAddress clientAddr = connectSocket.getInetAddress();
            int clientPort = connectSocket.getPort();
            String ServerInput;
            String receivedText;
            String usr;
            String pass;
            // Loop until null input string
            if(connectSocket.isConnected()){System.out.println("I (Server) [" + connectSocket.getLocalAddress().getHostAddress() + ":" + portNumber + "] > User Connected");}
          while(connectSocket.isConnected()){
              
          String login;
          login = (String) objIn.readObject();
          if(login != null)
             System.out.println(login);
              boolean isaUser = false;
             isaUser = reader(login);
              if(isaUser == true){
                  out.println("Logged In");
                  System.out.print("Logged In");
                  user(serverSocket,connectSocket,out,in,stdIn);
              }
              else {
                  out.println("Feil brukernavn eller passord");
                  System.out.print("Feil brukernavn eller passord");
              }
          }
          
          closeServer(serverSocket,out,in,stdIn);
        
          

          
          }
           catch (IOException | ClassNotFoundException e){
              System.out.println("ERROR");
          }
        
        
        
    }
   
  public static void closeServer(ServerSocket socket, PrintWriter out, BufferedReader in, BufferedReader stdIn){
      
      
      System.out.println("Connection with Client closing");
      try{
      in.close();
      out.close();
      stdIn.close();
      socket.close();
      }catch(IOException e){e.printStackTrace();}
      
  }
   
   
    public static void main(String[] args){
        
        runServer();
       
}
}
