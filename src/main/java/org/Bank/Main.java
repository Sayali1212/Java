package org.Bank;
import org.Bank.entities.Bank_Account;
import org.Bank.entities.Bank_Customer;
import org.Bank.repositories.Acc_DAO;
import org.Bank.repositories.Cust_DAO;
import org.Bank.util.DBCon;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;
public class Main {
    public static void main(String[] args) throws SQLException
    {
        DBCon.getConnection();
        Acc_DAO acc = new Acc_DAO();
        Cust_DAO cust = new Cust_DAO();
        Scanner sc = new Scanner(System.in);
        int c;
        while(true) {
            System.out.println("1.Get all customers");
            System.out.println("2.Get customer by cust_ID");
            System.out.println("3.Add new Customer");
            System.out.println("4.Update existing customer");
            System.out.println("5.Delete customer by ID");
            System.out.println("6.Get all accounts ");
            System.out.println("7.Get customer by account no.");
            System.out.println("8.Update account details of existing customer");
            System.out.println("9.Delete customer's account");
            System.out.println("10.Exit");
            System.out.println("Enter your choice:");
            c = sc.nextInt();

            if(c == 1)
            {
                //get all cust
                ArrayList<Bank_Customer> custlist = cust.getAllCust();
                System.out.println(custlist);
            }
            if(c == 2)
            {
                //get by ID
                System.out.println("Enter customer ID(get by ID):");
                /*int id = sc.nextInt();
                Bank_Customer ct = cust.getByCustID(id);
                System.out.println(ct);
                */
                System.out.println(cust.getByCustID(sc.nextInt()));
            }
            if(c == 3)
            {
                System.out.println("\nAdd following deatils of customer:");
                System.out.println("Add customer id:");
                int id = sc.nextInt();
                System.out.println("Add first name:");
                String fname = sc.next();
                System.out.println("Add last name:");
                String lname = sc.next();
                System.out.println("Add branch name.");
                String br = sc.next();
                System.out.println("Add mobile no.:");
                String phn_no = sc.next();
                LocalDate today = LocalDate.now();
                cust.addNewCust(id, fname, lname, br, phn_no, today);
            }
            if(c == 4)
            {
                //update existing customer
                cust.updateCust();
            }
            if(c == 5)
            {
                //delete customer by id
                System.out.println("Enter customer ID to delete its entry:");
                int i = sc.nextInt();
                cust.deleteCust(i);
            }
            if(c == 6)
            {
                ArrayList<Bank_Account> acclist = acc.getAllAccounts();
                System.out.println(acclist);
            }
            if(c == 7)
            {
                //get by acc no.
                System.out.println("Enter account number(get by acc_no):");
                String ano = sc.next();
                Bank_Account ret = acc.getByAccNo(ano);
                if(Objects.isNull(ret))//ret == null
                {
                    System.out.println("No customer with "+"'"+ano+"'"+" account number!!");
                }
                else
                {
                    System.out.println(ret);
                }
            }
            if(c == 8)
            {
                //update acnt details
                acc.updateAccDetails();
            }
            if(c == 9)
            {
                //delete acnt
                System.out.println("Enter account no to delete its entry:");
                String acnt = sc.next();
                acc.deleteAcnt(acnt);
            }
            if(c==10)
            {
                System.exit(0);
            }
        }











    }
}