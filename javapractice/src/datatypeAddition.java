public class datatypeAddition {
    public static void main(String[] args) {

        //Note:  There is no instruction set to perform operation on a byte type.
        // The instruction set for int type is used for the operation on boolean, byte, char, and short types.
        // maximum value an integer can store is 214748364767
        int a=214748,b=2147;
        int int_sum=a+b;
        System.out.println(int_sum);


        // maximum value an integer can store is 32767
        // the sum of short + short should be stored in int . if we have to store it then we require typecasting.
        short as= 37,bs=34;
        //int sumshort=a+b;
        short shortSum= (short) (as+bs);
        System.out.println(shortSum);


        //maximum value of float is 340282346638528860000000000000000000000.000000f
        float af=1000.1f,bf=999.6f;
        float floatSum=a+b;
        System.out.println(floatSum);

        double ad=188888.06666, bd=44444444444.7777777777;
        double double_sum=ad+bd;
        System.out.println(double_sum);


         long la=1009999999,lb=677777777;
         long long_sum=la+lb;
         System.out.println(long_sum);


         // we can't store the sum of char in char datatype we have to use int
         char ca='y',cb='f';
         int char_sum=ca+cb;
        System.out.println(char_sum);

        // we cannot add two boolean in Java.
        // In Java,the boolean values true and false are not integers nor
        // will they be automatically converted to integers.

        //maximum value of byte  is 127
        byte ab=1,bb=6;
        int sum=  ab+bb;
        System.out.println(sum);

    }
}
