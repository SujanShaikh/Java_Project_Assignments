package java_week2_classwork;

class Mother{
    public  void display(){
        System.out.println("Mother");
    }
}
class Father extends  Mother{
    public  void display(){
        System.out.println("Father");
    }
}
class Child extends Father{
    @Override
    public void display() {
        System.out.println("Child");    }
}

public class MultipleInheritance   {
    public static void main(String[] args) {

    }

    }

