package studentDataBaseApp;

import java.util.Scanner;

public class StudentDataBaseApp {

    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        //ask for how many students we want to add
        System.out.println("how many students do you want to enroll?");
        int numberOfStudent = input.nextInt();
        Student[] studentList = new Student[numberOfStudent];
        for (int i =0;i<studentList.length;i++){

            System.out.println("\nSTUDENT #" +i+"\n");
            Student st = new Student();
            studentList[i] = st;
            //show student information
            System.out.println(st.toString());
            st.payTuition();
        }
    }
}
