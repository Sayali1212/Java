package org.Bank.repositories;

import org.Bank.entities.Bank_Account;
import org.Bank.util.DBCon;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Acc_DAO {
    public ArrayList<Bank_Account> getAllAccounts() {
        ArrayList<Bank_Account> acclist = new ArrayList<>();
        ResultSet rst;
        Bank_Account at = new Bank_Account();
        try {
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery("select * from account");
            System.out.println(rst.next());
            while (rst.next()) {
                String acc_no = rst.getString(1);
                int bal = rst.getInt(2);
                int cid = rst.getInt(3);
                String acc_type = rst.getString(4);
                at = new Bank_Account(acc_no, bal, cid, acc_type);
                acclist.add(at);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return acclist;
    }

    public Bank_Account getByAccNo(String acc) {
        //get by acc_no
        Bank_Account act = null;
        try {
            String query = "SELECT * FROM account WHERE acc_no = ?";
            PreparedStatement pstmt = DBCon.getConnection().prepareStatement(query);
            pstmt.setString(1, acc);
            ResultSet rst = pstmt.executeQuery();

            while (rst.next()) {
                act = new Bank_Account();
                act.setAcc_no(rst.getString(1));
                act.setBalance(rst.getInt(2));
                act.setCust_id(rst.getInt(3));
                act.setAcc_type(rst.getString(4));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return act;
    }
    //update account
    public void updateAccDetails()
    {
        Scanner sc = new Scanner(System.in);
        ResultSet rst;
        String acc_no;
        try{
            System.out.println("Provide account no. to update its details:");
            acc_no = sc.next();
            String query = "SELECT * FROM account WHERE acc_no = ?";
            PreparedStatement pstmt = DBCon.getConnection().prepareStatement(query);
            pstmt.setString(1, acc_no);
            rst = pstmt.executeQuery();
            if(!rst.next())
            {
                System.out.println("This "+"'"+acc_no+"'"+" no.doesnot exist!!");
            }
            else
            {
                sc.nextLine();
                System.out.println("Enter balance: ");
                int bal = sc.nextInt();
//                System.out.println("Enter cust_id: ");
//                int cid = sc.nextInt();
                System.out.println("Enter account type: ");
                String acc_type = sc.next();

                String que = "UPDATE account set balance =?,acc_type=? where acc_no=? ";
                pstmt = DBCon.getConnection().prepareStatement(que);
                pstmt.setInt(1,bal);
                pstmt.setString(2,acc_type);
                pstmt.setString(3,acc_no);
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

    //delete Acnt
    public void deleteAcnt(String ano)
    {
        //Scanner sc = new Scanner(System.in);
        ResultSet rst;
        try
        {
            Statement stmt = DBCon.getConnection().createStatement();
            rst = stmt.executeQuery( "SELECT * FROM account WHERE acc_no = " +ano);
            if(!rst.next())
            {
                System.out.println("This customer id no. doesnot exist!!");
            }
            else
            {
                String que = "delete from account where acc_no = '" +ano+ "' ";
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