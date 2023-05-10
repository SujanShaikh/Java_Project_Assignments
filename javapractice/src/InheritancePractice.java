class Parent{
    public void displayParent()
    {
        System.out.println("this is parent");
    }
}
class Child extends Parent{
    public void displayChild() {
        super.displayParent();
        System.out.println("this is child");
    }
}
public class InheritancePractice {
    public static void main(String[] args) {
        Child child= new Child();
        child.displayChild();
        Parent parent=new Child();// parent reference used to hold child object.

    }
}
