
package main;


public class Student extends Person {


	    private int examScore;

	    public Student(int age, double height, String name,int examScore){
                super(name, age, height);
	        this.examScore = examScore;
	    }

	   

	    public int getExamScore(){
	        return examScore;
	    }

	    public void setExamScore(int examScore) {
	        this.examScore = examScore;
	    }

	    public void setAge(){
	        super.setAge(age);
	    }
            
            public void setHeight(){
	        super.setHeight(height);
	    }

            @Override
	    public String toString(){
	        return "\n" + "Examscore: " + getExamScore();
	    }
	}

