package Collections;

class printdemo implements Runnable {
    int n;

    printdemo(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
public class threadDemo {

    public static void main(String[] args) {
        printdemo pd=new printdemo(5);
        printdemo pd2=new printdemo(6);

        Thread t1=new Thread(pd);
        Thread t2=new Thread(pd2);
        t1.start();
        t2.start();


    }



}
