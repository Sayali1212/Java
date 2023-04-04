package training.repositories;

import training.entities.Student;
import training.util.DBCon;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDAO {
    public ArrayList<Student> getAll() {
        ArrayList<Student> alist = new ArrayList<Student>();
        ResultSet rst;
        Student s = new Student();
        try {
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery("select * from student");
            while (rst.next()) {
                int rno = rst.getInt(1);
                String nm = rst.getString(2);
                String mail = rst.getString(3);
                s = new Student(rno, nm, mail);
                alist.add(s);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return alist;
    }//end of getAll()

    public Student getByRoll(int roll)
    {
        //get by ID
        Student s = null;
        try{
            String query = "SELECT * FROM student WHERE rollno = ?";
            PreparedStatement pstmt = DBCon.getConnection().prepareStatement(query);
            pstmt.setInt(1,roll);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                s = new Student();
                s.setRollno(rst.getInt(1));
                s.setSname(rst.getString(2));
                s.setEmail(rst.getString(3));
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return s;
    }
    public void addNewStud(int roll, String name, String email)
    {
        ResultSet rst ;
        try{
           // DBCon.getConnection();
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery("SELECT * FROM student WHERE rollno="+roll);
            if(rst.next())
            {
                System.out.println("The student with roll no. = "+roll+" is already exist!!");
            }
            else
            {
                String que = "INSERT INTO student VALUES ('" +roll+ "' , '" +name+ "' , '" +email+ "')";
                int ret = stmt.executeUpdate(que);
                if(ret>0)
                {
                    System.out.println("Successfully inserted!!");
                }
                else {
                    System.out.println("Something went wrong!!");
                }
            }


        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void updateStud()
    {
        Scanner sc = new Scanner(System.in);
        ResultSet rst;
        try{
            Statement stmt = DBCon.getConnection().createStatement();
            System.out.println("Provide student roll no. to update its details:");
            int roll = sc.nextInt();
            rst = stmt.executeQuery("SELECT * FROM student WHERE rollno="+roll);
            if(!rst.next())
            {
                System.out.println("This roll no.doesnot exist!!");
            }
            else
            {
                sc.nextLine();
                System.out.println("Enter student name: ");
                String sname = sc.next();
                System.out.println("Enter student email: ");
                String email = sc.next();
                String que = "UPDATE student set sname = '" + sname + "', email = '" + email + "'" +
                        " WHERE rollno= '" + roll + "' ";
                int ret = stmt.executeUpdate(que);
                if(ret > 0)
                {
                    System.out.println("Successfully updated!!");
                }
                else {
                    System.out.println("Something went wrong!!");
                }

            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(int rollno)
    {
        Scanner sc = new Scanner(System.in);
        ResultSet rst;
        try
        {
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery( "SELECT * FROM student WHERE rollno="+rollno);
            if(!rst.next())
            {
                System.out.println("This roll no.doesnot exist!!");
            }
            else
            {
                String que = "delete from student where rollno = '" +rollno+ "' ";
                int ret = stmt.executeUpdate(que);
                if(ret > 0)
                {
                    System.out.println("Successfully deleted!!");
                }
                else {
                    System.out.println("Something went wrong!!");
                }
            }

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}

