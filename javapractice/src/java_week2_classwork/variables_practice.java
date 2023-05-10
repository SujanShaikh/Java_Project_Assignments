package java_week2_classwork;


class Variables{
    int number3 =24, number4 = 6;
            static int result ;

     public void local_variable(){
         int number1 =48, number2 = 6 ;
         result=number1+number2;
        System.out.println(" access local variables :  " + result);
    }
    public void global_variable(){
        result=number3+number4;
        System.out.println(" access global variables :  " + result);
    }
    public static void static_variable(){
       // result=number3+number4; can't access global variable (non static variable) in static method;
        System.out.println(" static variables " + result);
    }

}
public class variables_practice {
    public static void main(String[] args) {
        Variables variables =new Variables();
        variables.local_variable();
        variables.global_variable();
        Variables.static_variable();


    }
}
