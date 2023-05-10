package java_week2_classwork;

  class m1 implements DemoInterface  {
    @Override
    public void displayName() {
        System.out.println("Sujan");
    }
      @Override
      public void displayage() {
          System.out.println("22");
      }
  }
public class InterfaceDemo {
    public static void main(String[] args) {
 m1 m=new m1();
        m.displayName();
        m.displayage();

    }
}
