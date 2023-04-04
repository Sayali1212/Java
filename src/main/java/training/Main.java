package training;

import training.entities.Student;
import training.repositories.StudentDAO;
import training.util.DBCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws SQLException {

        DBCon.getConnection();
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> alist = dao.getAll();
        System.out.println(alist);

        //getby ID
        Student s = dao.getByRoll(11);
        System.out.println(s);

        //Add new student
        System.out.println("Add following deatils of student:");
        System.out.println("Add roll no.");
        int roll = sc.nextInt();
        System.out.println("Add name:");
        String name = sc.next();
        System.out.println("Add email:");
        String mail = sc.next();
        dao.addNewStud(roll,name,mail);

        //update student
        dao.updateStud();

        // delete student
        System.out.println("Enter roll number of student to delete its entry:");
        roll = sc.nextInt();
        dao.deleteStudent(roll);

    }

}

