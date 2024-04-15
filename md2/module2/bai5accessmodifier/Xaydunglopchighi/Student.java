package bai5accessmodifier.Xaydunglopchighi;

public class Student {
    private String name = "John";
    private String className = "CO2";
    Student(){};

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
