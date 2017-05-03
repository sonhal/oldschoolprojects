
package main;


public class Lecturer extends Person {

	
	    private int salary;

	    public Lecturer(int age, String name, double height,int salary){
                super(name, age, height);
	        this.salary = salary;
	    }

	   

	    public int getSalary(){
	        return salary;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }

            @Override
	    public String toString(){
	    return "\n" + "Salary: " + getSalary();
	    }
	}


