package bai5accessmodifier.ThuchanhStacticMethod;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();//calling change method

        //creating object
        Student s1 = new Student(111,"Tuan");
        Student s2 = new Student(222,"Tay");
        Student s3 = new Student(333,"Thang");

        s1.display();
        s2.display();
        s3.display();
    }
}
