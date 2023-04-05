package org.Bank.repositories;

import org.Bank.entities.Bank_Customer;
import org.Bank.util.DBCon;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;

import java.sql.Date;
import java.util.Scanner;


public class Cust_DAO {

    public ArrayList<Bank_Customer> getAllCust()
    {
        ArrayList<Bank_Customer> custlist = new ArrayList<>();
        ResultSet rst;
        Bank_Customer ct = new Bank_Customer();
        try {
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery("select * from customer");
            System.out.println(rst.next());
            while (rst.next())
            {
                int id = rst.getInt(1);
                String fname = rst.getString(2);
                String lname = rst.getString(3);
                String br = rst.getString(4);
                String mob = rst.getString(5);
                Date date = rst.getDate(6);
                LocalDate ld = ((java.sql.Date) date).toLocalDate();
                ct = new Bank_Customer(id,fname,lname,br,mob,ld);
                custlist.add(ct);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return custlist;
    }

    public Bank_Customer getByCustID(int cid)
    {
        //get by ID
        Bank_Customer cust = null;
        try{
            String query = "SELECT * FROM customer WHERE cust_id = ?";
            PreparedStatement pstmt = DBCon.getConnection().prepareStatement(query);
            pstmt.setInt(1,cid);
            ResultSet rst = pstmt.executeQuery();
            while (rst.next())
            {
                cust = new Bank_Customer();
                cust.setCid(rst.getInt(1));
                cust.setFname(rst.getString(2));
                cust.setLnmae(rst.getString(3));
                cust.setBranch(rst.getString(4));
                cust.setPhn_no(rst.getString(5));
                Date date = rst.getDate(6);
                LocalDate ld = ((java.sql.Date) date).toLocalDate();
                cust.setDoj(ld);
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return cust;
    }

    //add new customer
    public void addNewCust(int id, String fname, String lname,
                           String br, String mob, LocalDate dt)
    {
        ResultSet rst ;
        try{
            // DBCon.getConnection();
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery("SELECT * FROM customer WHERE cust_id="+ id);
            if(rst.next())
            {
                System.out.println("The customer with cust_id. = "+id+" is already exist!!");
            }
            else
            {
                Date dt1 = Date.valueOf(dt);
                String que = "INSERT INTO customer VALUES ('" +id+ "' , '" +fname+ "' , '" +lname+ "'" +
                        ",'" +br+ "','"+mob+"','"+dt1+"')";
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

    public void updateCust()
    {
        Scanner sc = new Scanner(System.in);
        ResultSet rst;
        int cust_id;
        try{
            System.out.println("Provide customer ID update its details:");
            cust_id = sc.nextInt();
            String query = "SELECT * FROM customer WHERE cust_id = ?";
            PreparedStatement pstmt = DBCon.getConnection().prepareStatement(query);
            pstmt.setInt(1, cust_id);
            rst = pstmt.executeQuery();
            if(!rst.next())
            {
                System.out.println("This cust_id no.doesnot exist!!");
            }
            else
            {
                sc.nextLine();
                System.out.println("Enter first name: ");
                String fname = sc.next();
                System.out.println("Enter last name: ");
                String lname = sc.next();
                System.out.println("Enter branch name: ");
                String br = sc.next();
                System.out.println("Enter mobile no: ");
                String mob = sc.next();

                String que = "UPDATE customer set fname =?,lname=?,branch=?,mob_no=? where cust_id=? ";
                pstmt = DBCon.getConnection().prepareStatement(que);
                pstmt.setString(1,fname);
                pstmt.setString(2,lname);
                pstmt.setString(3,br);
                pstmt.setString(4,mob);
                pstmt.setInt(5,cust_id);
                int ret= pstmt.executeUpdate();
                if(ret > 0)
                {
                    System.out.println("Successfully updated!!");
                }
                else
                {
                    System.out.println("Something went wrong!!");
                }

            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    //delete customer
    public void deleteCust(int id)
    {
        Scanner sc = new Scanner(System.in);
        ResultSet rst;
        try
        {
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery( "SELECT * FROM customer WHERE cust_id="+id);
            if(!rst.next())
            {
                System.out.println("This customer id no. doesnot exist!!");
            }
            else
            {
                String que = "delete from customer where cust_id = '" +id+ "' ";
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
