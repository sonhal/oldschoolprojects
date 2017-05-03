
package main;


public class Main {


    public static void main(String[] args) {
        
        Student student = new Student(21,22,"Sondre",2);
        Lecturer lecturer = new Lecturer(33,"Henrik",22,2);
        ChemicalElement atomicNmbr = new ChemicalElement(2,"d",3,3);

        student.setName("BesteSondre");
        student.setAge(21);
        student.setExamScore(100);
        student.setHeight(180);


        lecturer.setName("Mikkel");
        lecturer.setAge(55);
        lecturer.setSalary(350000);


        atomicNmbr.setAtomicNmbr(9);
        atomicNmbr.setSymbol("C");
        atomicNmbr.setGroup(2);
        atomicNmbr.setPeriod(1);

        
        System.out.print("\n");
        System.out.print(student.getInfo() + student.toString());
        System.out.print("\n");
        System.out.print(lecturer.getInfo() + lecturer.toString());
        System.out.print("\n");
        System.out.print(atomicNmbr.toString());
        System.out.print("\n");


    }
    
}
