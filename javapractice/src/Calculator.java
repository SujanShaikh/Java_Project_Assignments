
 class Operations1{
    int number1=36, number2=12,result=0;
    public void addition(){
        result=number1+number2;
        System.out.println("Addition is : " + result);
    }
     public void subtraction(){
         result=number1-number2;
         System.out.println("subtraction is : " + result);
     }
     public void multiplication(){
         result=number1*number2;
         System.out.println("multiplication is : "+ result);
     }
     public void division(){
         result=number1/number2;
         System.out.println("division is : " + result);
     }
 }
public class Calculator {

    public static void main(String[] args) {
        Operations1 operations=new Operations1();
        operations.addition();
        operations.subtraction();
        operations.multiplication();
        operations.division();

    }
}
