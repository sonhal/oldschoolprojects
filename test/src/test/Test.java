/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author sonhal
 */
public class Test {


 public static void main( String[] args )
 {
 int y;
 int x = 1;
 int total = 0;

 while ( x <= 10 )
 {
 y = x * x;
 System.out.println( y );
 total += y;
 ++x;
 } // end while

 System.out.printf( "Total is %d\n", total );
 } // end main
 } // end class Mystery
    
    

