import com.sun.org.apache.xalan.internal.xsltc.runtime.Operators;

class ArithmeticOperations {
    int number1=26,number2= 4,result=0;

    public void addition(){
        result = number1  + number2;
         System.out.println("Addition is : " + result );
     }
    public void subtraction(){
        result = number1  - number2;
        System.out.println("Subtraction is : " + result );
    }
    public void multiply(){
        result = number1  * number2;
        System.out.println("Multiplication is : " + result );
    }
    public void division(){
        result = number1  / number2;
        System.out.println("Division is : " + result );
    }
    public void modulo(){
        result = number1  % number2;
        System.out.println("Modulo is : " + result );
    }
 }

class AssignmentOperations {
    int number1=20,result=0;

    public void equalTo(){
        result = number1  ;
        System.out.println(" = is : " + result );
    }
    public void addEqualTo(){
        result += number1  ;
        System.out.println("+= is : " + result );
    }
    public void minusEqualTo(){
        result -= number1  ;
        System.out.println("-= is : " + result );
    }
    public void multiplyEqualTo(){
        result *= number1  ;
        System.out.println("*= is : " + result );
    }
    public void divisionEqualTo(){
        result /= number1  ;
        System.out.println("/= is : " + result );
    }
    public void moduloEqualTo(){
        result /= number1  ;
        System.out.println("%= is : " + result );
    }
}

    class RelationalOperators {
        int number1 = 24, number2 = 56;

        public void isEqualTo() {
            System.out.println(number1 == number2);
        }

        public void notEqualto() {
            System.out.println(number1 != number2);
        }

        public void greaterThan() {
            System.out.println(number1 > number2);
        }

        public void lessThan() {
            System.out.println(number1 < number2);

        }

        public void greaterThanOrEqualTo() {
            System.out.println(number1 >= number2);

        }

        public void lessThanOrEqualTo() {
            System.out.println(number1 <= number2);

        }
    }


        class  LogicalOperators{
          public void and(){
              System.out.println(2>3 && 5>3);
          }
            public void or(){
                System.out.println(2>3 || 5>3);
            }
            public void not(){
                System.out.println(!(2>3 == 5>3));
            }

    }

    class UnaryOperators{
    int number3=54,number4= 3;
    public void increment(){
        System.out.println(++number3);
    }
    public void decrement(){
        System.out.println(--number4);
    }
    }

    class BitwiseOperators{
    int number1=6,number2=8;
    public void bitwiseand(){
        System.out.println( number1 & number2);
    }
        public void bitwiseor(){
            System.out.println( number1 | number2);
        }
        public void bitwisXor(){
            System.out.println( number1 ^ number2);
        }
        public void bitwisenot(){
            System.out.println( number1 & number2);
        }

    }

    class ShiftOperators{
    int number5=5;
    public void leftShift(){
        System.out.println( number5<<2);
    }
    public void rightShift(){
            System.out.println( number5>>2);
        }
    }

    class InstanceOperator{
    public void checkInstance(){
        String str="sujan";
        boolean result;
        result=str instanceof String;
        System.out.println("Is str object of String ? " + result );
    }
    }

     class TernaryOperator{
         public void ternary() {
             int number1=2,number2=5;
             boolean result=(number1>number2) ? true :false ;
             System.out.println(result);
         }
         }



public class JavaOperators {
    public static void main(String[] args) {
        ArithmeticOperations arithmeticOperations=new ArithmeticOperations();
        arithmeticOperations.addition();
        arithmeticOperations.subtraction();
        arithmeticOperations.multiply();
        arithmeticOperations.division();
        arithmeticOperations.modulo();

        AssignmentOperations assignmentOperations= new AssignmentOperations();
        assignmentOperations.equalTo();
        assignmentOperations.addEqualTo();;
        assignmentOperations.minusEqualTo();
        assignmentOperations.divisionEqualTo();
        assignmentOperations.multiplyEqualTo();
        assignmentOperations.divisionEqualTo();
        assignmentOperations.moduloEqualTo();

        RelationalOperators relationalOperators=new RelationalOperators();
        relationalOperators.isEqualTo();;
        relationalOperators.notEqualto();
        relationalOperators.greaterThan();
        relationalOperators.lessThan();
        relationalOperators.greaterThanOrEqualTo();
        relationalOperators.lessThanOrEqualTo();

        LogicalOperators logicalOperators=new LogicalOperators();
        logicalOperators.and();
        logicalOperators.or();
        logicalOperators.not();

        UnaryOperators unaryOperators=new UnaryOperators();
        unaryOperators.increment();
        unaryOperators.decrement();

        BitwiseOperators bitwiseOperators=new BitwiseOperators();
        bitwiseOperators.bitwiseand();
        bitwiseOperators.bitwisenot();
        bitwiseOperators.bitwiseor();
        bitwiseOperators.bitwisXor();

        ShiftOperators shiftOperators=new ShiftOperators();
        shiftOperators.leftShift();
        shiftOperators.rightShift();

        InstanceOperator instanceOperator=new InstanceOperator();
        instanceOperator.checkInstance();

        TernaryOperator ternaryOperator=new TernaryOperator();
        ternaryOperator.ternary();



    }
}
