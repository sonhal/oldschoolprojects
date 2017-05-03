/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservermultithreadexperimental;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author sonhal
 */
public class ServerClientConnection extends Thread{
    
    Socket clientSocket;
    ObjectInputStream in;
    ObjectOutputStream out;
    Server server;
    ArrayList<ServerClientConnection> clientList; 
      
    public ServerClientConnection(Socket clientSocket, Server server){
    this.server = server;
    this.clientSocket = clientSocket;
    this.clientList = server.connections;
}
   
    
  public void run(){
        
        try {
            in = new ObjectInputStream(clientSocket.getInputStream());
            out = new ObjectOutputStream(clientSocket.getOutputStream());
          
            
            
          boolean isLoggedIn = false;
          boolean  sleep = false;
          out.writeUTF("Logg deg inn");
          out.flush();
          
          String cred;
          cred = login();
          isLoggedIn = reader(cred);
          
          
          
          if(isLoggedIn){
              out.writeUTF("Liste av påloggede brukere: ");
             
                    while(true){

                        out.writeUTF("Logged in");
                        out.flush();
                  }
          }
          else{
                   sendStringToClient("Wrong username or password \n You are disconnected");
                   clientSocket.close();
                    }
        } catch (IOException ex) {
           ex.printStackTrace();
        } 
        
    }
  
  
  
 String login() throws IOException{
      String username;
      String password;
      String loginUP = null;
      out.writeUTF("Type username: ");
      out.flush();
      username = in.readUTF();
      out.writeUTF("Type password: ");
      out.flush();
      password = in.readUTF();
      loginUP = username + password;
      return loginUP;
  }
 
 static boolean reader(String user){
        String usr = user;
        String ln;
        boolean isEq = false;
        try(
                BufferedReader read = new BufferedReader(new FileReader("usernamesPasswords.txt"));
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
 
  public void sendStringToClient(String a){
      
        try {
            out.writeUTF(a);
            out.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
 
 
}

