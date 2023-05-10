class Demo{
    public void display(){
        try{
            try {
                for (int i = 0; i < 10; i++) {
                    if (i == 5)
                        continue;
                    System.out.println(i);
                }
            }
            catch (ArithmeticException e) {
                e.printStackTrace();
            }
            finally{
                System.out.println("finally");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Last");
    }
}
public class exceptiondemo {
    public static void main(String[] args) {
        Demo demo=new Demo();
        demo.display();
    }
}
