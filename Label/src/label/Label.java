/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package label;

/**
 *
 * @author sonhal
 */
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;
        
public class Label {

    
    public static void main(String[] args) {
        
        JLabel ok = new JLabel();
        ok.setText("Hey, it works!");
        
        JFrame mas = new JFrame();
        
        mas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mas.add(ok,BorderLayout.NORTH);
        
        mas.setSize(200, 200);
        mas.setVisible(true);
    }
    
}
