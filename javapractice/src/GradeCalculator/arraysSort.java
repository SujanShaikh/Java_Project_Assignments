package GradeCalculator;

import java.util.*;


public  class arraysSort {
    public static void main(String[] args) {
        int num[] = {1, 4, 2, 89, 65, 3};
        int num2[] = {7, 3, 4, 1, 67, 9};

        List<Integer> list = new ArrayList<>();
        for (int n : num) {
            list.add(n);
        }
        for (int n : num2) {
            list.add(n);
        }
        Collections.sort(list);

    }

}
