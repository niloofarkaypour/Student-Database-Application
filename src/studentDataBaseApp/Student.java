package studentDataBaseApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Student {

    private final String firstName;
    private final String lastName;
    private final String gradeYear;
    private String studentID;
    private ArrayList<String> courses;
    private int tuitionBalance = 0;
    private int costOfCourse = 600;
    private static int id = 1000;

    //constructor prompt user to enter name and year
    public Student(){
        Scanner input = new Scanner(System.in);
        System.out.println("enter first name:");
        this.firstName = input.nextLine();
        System.out.println("enter last name:");
        this.lastName = input.nextLine();
        System.out.println("enter class level as:\n1 for freshmen\n2 for sophomore\n3 for junior\n4 for senior");
        this.gradeYear = input.nextLine();
        //call a method to generate student ID
        this.studentID = setStudentID();
        this.courses = enrollCourses();
        this.tuitionBalance = CourseBalance();

    }

    //generate student ID
    private String setStudentID(){
        //grade level + id
        id++;
        String studentID =  this.gradeYear + id;
        return studentID;
    }
    //enroll for the courses
    private ArrayList<String> enrollCourses(){
        Scanner input = new Scanner(System.in);
        String course = "";
        ArrayList<String> listOfCourse = new ArrayList<String>();
        while (!course.equalsIgnoreCase("q")){
            System.out.println("enter the name of the course to enroll\n100 for history\n101 for english\n102 for chemistry\n103 for computer science\nQ for end of registration");
            course = input.nextLine();
            if (listOfCourse.contains(course))
                System.out.println("course "+ course +" is already added to your card\n");
            else if(course.equalsIgnoreCase("q"))
                System.out.println("Quit\n");
            else if(!course.equalsIgnoreCase("q") && !listOfCourse.contains(course)){
                listOfCourse.add(course);
                System.out.println("course "+ course + " is added to your card\n");
            }
            else
                System.out.println("course code is not valid...\n");
        }
        return listOfCourse;
    }


    //calculate balance
    private int CourseBalance(){
        int numberOfCourse = this.courses.size();
        tuitionBalance = numberOfCourse * costOfCourse;
        return tuitionBalance;
    }
    //pay tuition
    public void payTuition(){
        Scanner input = new Scanner(System.in);
        System.out.println("how much do yoy want to pay?");
        int tuition = input.nextInt();
        int newBalance = CourseBalance() - tuition;
        System.out.println("you paid "+ tuition +"\nyour new balance is " + newBalance);
    }


    //show student status - name, id, courses, balance
    @Override
    public String toString() {
        return ("New Student Information Is Defined as Below...\nFirst name = "+this.firstName + "\nLast name = "+ this.lastName + "\nclass level = " + this.gradeYear + "\nStudent ID = " + this.studentID + "\nList of course = " + this.courses + "\nTuition fee/course balance is = " + this.tuitionBalance);

    }
}
