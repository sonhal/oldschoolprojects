/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservertest;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author sonhal
 */
public class Chat {
    
    
    ArrayList<ServerConnection> connections;
    
    
   void Chat(ArrayList<ServerConnection> con){
       connections = con;
       
   }
   
   synchronized void DisplayConnections(ArrayList<ServerConnection> a){
        
       for(int i = 0; i < a.size(); i++){
          System.out.println(a.get(i).getUserName());
       }
       notify();
   }
    
   synchronized ServerConnection getClientToChatWith(ServerConnection client, ArrayList<ServerConnection> a) throws IOException {
      client.out.writeUTF("Type user to connect to: ");
      String userToConnectTo = client.in.readUTF();
      
      ServerConnection client2 = null;
      
      for(int i = 0; i < a.size(); i++){
         String user = a.get(i).getUserName();
         if(user == userToConnectTo){
            client2 = a.get(i);
             
             a.get(i).out.writeUTF(client.getUserName() + "Wants to Connect");
             String answere = a.get(i).in.readUTF();
             if(answere == "yes"){
                clientToClientChat( client, a.get(i));
             }
         }
          
       }
          
        
        
        return client2;
        
       
    }
    
   void clientToClientChat(ServerConnection client1, ServerConnection client2) throws IOException{
     String client1Input =  client1.in.readUTF();
     String client2Input =  client2.in.readUTF();
     
     client1.out.writeUTF(client2Input);
     client2.out.writeUTF(client1Input);
   }
    
   synchronized ServerConnection catchConnection(ServerConnection reciver, ArrayList<ServerConnection> a) throws IOException {
       boolean con = false;
       con = reciver.objIn.readBoolean();
       
       if(con != false){
            reciver.out.writeUTF("user wants to connect ");
            
           String accept;
           accept = reciver.in.readUTF();
           
           if(accept != "yes"){
               reciver.objOut.writeBoolean(false);
           }
           else{
               return reciver;
           }
           
       }

        
        return null;
       
    }
   
}
