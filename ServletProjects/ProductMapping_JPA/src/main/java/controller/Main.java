package controller;

import dao.DaoImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("sujan");
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        DaoImpl implement= new DaoImpl();
        boolean flag=true;
        while(flag){
            System.out.println("Enter your choice :");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Insert variety");
            System.out.println("5. map many to many ");
            System.out.println("6. Query ");
            System.out.println("7. Query1 ");




            System.out.println("0. EXIT");

            int choice= Integer.parseInt(bf.readLine());
            switch(choice) {
                case 1:
                    implement.insertData();
                    break;
                case 2:
                    implement.updateData();
                    break;
                case 3:
                    implement.deleteData();
                    break;
                case 4:
                    implement.insertVariety();
                    break;
                case 5:
                    implement.mapping();
                    break;
                case 6:
                    implement.criteria1();
                    break;
                case 7:
                    implement.criteria2();
                    break;
                case 0:
                    emf.close();
                    flag = false;
                    System.out.println("Exit !!");
                    break;
                default:
                    System.out.println("enter valid option !");
            }
        }


    }
}
