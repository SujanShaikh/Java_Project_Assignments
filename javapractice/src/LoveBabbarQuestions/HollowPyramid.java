package LoveBabbarQuestions;

public class HollowPyramid {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= 5; i++) {
            int j = 1;
            for (; j <= i; j++) {
                if (j == 1 || i==n) {
                    System.out.print(j);
                } else if (j == i) {
                    System.out.print(j);
                }  else {
                    System.out.print(" ");
                }
            }
            System.out.println();


        }
    }
}

