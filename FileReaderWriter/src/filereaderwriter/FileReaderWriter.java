/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderwriter;
import java.io.*;
/**
 *
 * @author sonhal
 */
public class FileReaderWriter {

    /**
     * @param args the command line arguments
     */
    
    static void reader(){
        try{
        String ln;
        BufferedReader read = new BufferedReader(new FileReader("C:\\Users\\sonhal\\Documents\\NetBeansProjects\\FileReaderWriter\\fil.txt"));
        
        while((ln = read.readLine()) != null){
        
        System.out.println(ln);
        }
        }catch (IOException e){
        			e.printStackTrace();
        }
        
        
    }
    
    
    
    public static void main(String[] args) {
        
        reader();
    }
    
}
