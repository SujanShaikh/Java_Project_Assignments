package Collections;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> hashSetdemo=new HashSet<>();
        hashSetdemo.add(1);
        hashSetdemo.add(2);
        hashSetdemo.add(3);
        hashSetdemo.add(null);
        hashSetdemo.add(null);


        System.out.println(hashSetdemo);
    }
}
