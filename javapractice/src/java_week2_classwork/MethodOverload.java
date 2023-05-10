package java_week2_classwork;
 class Test{
     public void m1(int i){
         System.out.println("int");
     }
     public void m1(int... i){
         System.out.println("var agrs int");
     }

 }
public class MethodOverload {
    public static void main(String[] args) {
    Test test=new Test();
    test.m1(1);
    test.m1(2,3,4);
    test.m1();

    }
}
