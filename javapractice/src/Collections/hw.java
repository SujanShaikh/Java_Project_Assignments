package Collections;

class Homework{
    int demo(){

        //Q1
        int a=5;
        int b=3;

        System.out.println("updating a-> 5+3=8 :"+ (a =a+b));
        System.out.println("b= 8-5 =3 : "+(b=a-b));
        System.out.println("a=8-5 :"+(a=a-b));

        int sum=a+b;
        return sum ;

        //Q2:

        //System.out.println("After return Statement");
       // This will not execute
    }
}
public class hw {
    public static void main(String[] args) {

        Homework homework=new Homework();
        homework.demo();
    }
}
