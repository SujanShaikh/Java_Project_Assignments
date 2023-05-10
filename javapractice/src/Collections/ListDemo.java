package Collections;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
    public static void main(String[] args) {

        List list= new ArrayList();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(null);
        list.add(null);
        Iterator iterator= list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        ListIterator listIterator= list.listIterator();
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.hasPrevious());
        }



       // System.out.println(list);
    }
}
