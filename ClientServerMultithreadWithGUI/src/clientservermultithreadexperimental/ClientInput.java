/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservermultithreadexperimental;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonhal
 */
public class ClientInput extends Thread {
    ObjectOutputStream out;
    Socket clientSocket;
    BufferedReader stdIn;
    
    public ClientInput(Socket clientSocket){
    
    this.clientSocket = clientSocket;
}
   
    
  public void run(){
        
        try {
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            stdIn = new BufferedReader(new InputStreamReader(System.in));
            
            while(true){
                if(stdIn.ready() == false)
                {
                    Thread.sleep(10);
                }
                else{
                    String message = stdIn.readLine();
                    out.writeUTF(message);
                    out.flush();
                }
            }
            
        } catch (IOException ex) {
           ex.printStackTrace();
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        
    }
    
    
}
