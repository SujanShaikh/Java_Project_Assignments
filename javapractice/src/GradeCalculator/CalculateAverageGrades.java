package GradeCalculator;

import java.util.Scanner;

class CalculateGrades{
    public void  calculateAverage(){
        Scanner sc=new Scanner(System.in);
        int marksSum=0;
        System.out.println("Enter the number of exams you appeared : ");
        int examsAppeared=sc.nextInt();
        int Scores[]=new int[examsAppeared];
        for(int i=0;i<examsAppeared;i++) {
            System.out.printf("Enter test score for %d : ", i + 1);
            Scores[i] = sc.nextInt();
            if (Scores[i] < 20) {
                try {
                    throw new lowMarksException();
                } catch (lowMarksException e) {
                    System.out.println(e.getMessage());
                    return; // exit the method if exception is thrown
                }
            } else {
                marksSum += Scores[i];
            }
        }
        double percentage = ((double) marksSum / examsAppeared) * 100;
        if (percentage >= 35) {
            System.out.println("Congratulations u passed with " + percentage + " %");
        } else {
            System.out.println("Study Hard ");
        }
    }
}

class lowMarksException extends Exception{
    lowMarksException(){
        super("Enter marks greater than 20");
    }
}

public class CalculateAverageGrades {
    public static void main(String[] args) {
        CalculateGrades calculateGrades=new CalculateGrades();
        calculateGrades.calculateAverage();
    }
}
