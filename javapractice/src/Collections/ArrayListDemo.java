package Collections;

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;

            }
        };
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(34);
        arrayList.add(1);
        arrayList.add(98);
        Collections.sort(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList, comp);
        System.out.println(arrayList);


    ListIterator<Integer> itr = arrayList.listIterator(arrayList.size());
        while(itr.hasPrevious())

    {
        System.out.println(itr.previous());
    }

}


//        int number[]={1,4,5,6,3,2,4,1};
//        ArrayList<Integer> arrayList=new ArrayList<>();
//        for(int i=0;i< number.length;i++)
//        {
//            arrayList.add(number[i]);
//        }
//        Collections.sort(arrayList,com);
//        Collections.reverse(arrayList);
//        System.out.println(arrayList);
//        ArrayList<Integer> intArr=new ArrayList<>(arrayList);
//
//        HashSet<Integer> inthashset=new HashSet<>(intArr);
//        System.out.println(inthashset);

    void city(){

    }
    }

