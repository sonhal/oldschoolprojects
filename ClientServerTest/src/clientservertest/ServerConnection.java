



package clientservertest;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sonhal
 */
public class ServerConnection extends Thread {
    
    String name;
    boolean isaUser = false;
    boolean ReadyForConnection = true;
    Socket socket;
    MultiServer server;
    DataInputStream in;
    DataOutputStream out;
    ObjectInputStream objIn;
    ObjectOutputStream objOut;
    boolean shouldRun = true;
    String login;
    Chat chat;
    public ServerConnection(Socket socket, MultiServer server, Chat c){
        super("ServerConnectionThread");
        this.socket = socket;
        this.server = server;
        this.chat = c;
        System.out.println("Thread");
        
    }
    
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
    public void sendStringToAll(String a){
        for(int i = 0; i < server.connections.size(); i++){
            ServerConnection sc = server.connections.get(i);
            System.out.println("Sending string to all");
            sc.sendStringToClient(a);
        }
    }
    
    public String getUserName(){
        return login;
    }
    
  public void chatWithClient(ServerConnection client2) throws IOException {
      String input = this.in.readUTF();
      client2.out.writeUTF(input);
      
  } 
    
    public void run(){
        try{
              out = new DataOutputStream(socket.getOutputStream());
              objOut = new ObjectOutputStream(socket.getOutputStream());
              in = new DataInputStream(socket.getInputStream());
              
              objIn = new ObjectInputStream(socket.getInputStream());
              int  counter = 1;
              Thread.sleep(1000);
              
              //System.out.println("Her" );
           
              out.writeUTF("Hei fra server!!" + counter);
              out.writeUTF("Hei fra server!!" + counter);
              out.flush();
              counter++;
                    
              while(shouldRun){
                    System.out.println("inne i while");
                    String login1;       
                    login1 = (String) objIn.readObject();
                  if(login1 != null){
             System.out.println(login1);
              
             isaUser = reader(login1);
              if(isaUser == true){
                  
                 // sendStringToClient("Logged In");
                  String melding = "Logged in";
                  out.writeUTF(melding);
                  out.flush();
                  System.out.println("Logged In");
                  sendStringToClient("Type Username ");
                  name = in.readUTF();
                  
                  System.out.println(name + " is username ");
                  

                  
              }
              else {
                  sendStringToClient("Feil brukernavn eller passord");
                  System.out.print("Feil brukernavn eller passord");
                  break;
              }
          
                    }
                    
            }
              
            if(isaUser == true){
                //out = new DataOutputStream(socket.getOutputStream());
               
                while(true){
                    
                    
                    try {
                    out.writeUTF("Melding fra server" + counter);
                    out.flush();
                    counter++;
                        Thread.sleep(5);
                    } catch (InterruptedException | IOException ex) {
                        ex.printStackTrace();
                    }
                }  
              /*  boolean klar = false;
                while(shouldRun){
                    if(klar == false){
                    System.out.println("Vi er logget in og klar for sending og motakk");
                    sendStringToClient("Type @ + username of the person you want to talk to \n type list to list all users online ");
                   klar = true;
                    }
                    if(this.in.available() > 0){
                    String s = "";
                    s = in.readUTF(); 
                
                if(s.startsWith("@") == true){      
                  while(true){
                    System.out.println("Vi skal koble opp to klienter nå");
                    sendStringToClient("Skriv hvem du vil koble til");
                  ServerConnection client = chat.getClientToChatWith(this, server.connections);
                            klar = false;  
                  }
                  while(shouldRun){
                      
                  chatWithClient(client);
        
                                  }
                }
               }
               
               
                
                 
                
                }*/
                
            }
            else{
                sendStringToClient("Feil Brukernavn eller passord");
                
            }
            in.close();
            out.close();
            socket.close();
        }
            
            
            
        
        catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
    
    
   
    
  
}