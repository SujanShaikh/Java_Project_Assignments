package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {

        Comparator<String> comp=new Comparator<String>( ) {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        };
        List<String> stringList=new ArrayList<>();
        stringList.add("Sujan");
        stringList.add("mrunmai");
        stringList.add("Shreya");
        stringList.add("hii");


        Collections.sort(stringList,comp);
        System.out.println(stringList);
    }
}
