
package main;


abstract class Person {

	    protected String name;
	    protected int age;
	    protected double height;
            
            public Person(String name, int age, double height){
                this.age = age;
                this.name = name;
                this.height = height;
            }
                   

	    public String getInfo(){
                
                String utskrift = "";
                
                utskrift = "Navn: " + name + "\n" + "alder: " + age + "\n" + "høyde: " + height;
                return utskrift;
	    }
            
            public void setAge(int age){
                this.age = age;
            }
            
            public void setHeight(double height){
                this.height = height;
            }
            
            public void setName(String name){
                this.name = name;
            }
            
	}
