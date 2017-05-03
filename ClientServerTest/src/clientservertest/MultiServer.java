
package clientservertest;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author sonhal
 */
public class MultiServer {
    
    
   ServerSocket socket;
   ArrayList<ServerConnection> connections = new ArrayList<ServerConnection>();
   boolean shouldRun = true;
   
   
      public static void main(String[] args){
       MultiServer s = new MultiServer();
       
        
       
}
      
   public MultiServer(){
       
       try{
           System.out.println("Hi, I am EchoUCase TCP server");
           socket = new ServerSocket(4400);
           while(shouldRun){
           Chat chat = new Chat();
           Socket clientSocket = socket.accept();
           ServerConnection sc = new ServerConnection(clientSocket, this, chat);
           sc.start();
           connections.add(sc);
           
           }
           
       }catch(IOException e){
           e.printStackTrace();
       }
   }
   
   
}
