/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

/**
 *
 * @author sonhal
 */
class A {
    public int x;
}

class B extends A {
    public int x;
}

class C extends B {

    public int x;

    public void test() {
        x = 100;
        this.x = 300;
        System.out.print("C:" + this.x + "\n");
        super.x = 600;
        System.out.print("B:" + super.x + "\n");
        ((A) this).x = 2;
        System.out.print("A:" + (((A)this).x)+" \n");
    }
}

   public class Tester {
    public static void main(String[] args) {

        C test = new C();
        test.test();

    }
}
    

