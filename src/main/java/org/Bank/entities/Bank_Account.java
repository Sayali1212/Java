package org.Bank.entities;

public class Bank_Account {
    private String acc_no;
    private int balance;
    private int cust_id;
    private  String acc_type;

    public Bank_Account() {
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public String getAcc_type() {
        return acc_type;
    }

    public void setAcc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public Bank_Account(String acc_no, int balance, int cust_id, String acc_type) {
        this.acc_no = acc_no;
        this.balance = balance;
        this.cust_id = cust_id;
        this.acc_type = acc_type;
    }

    @Override
    public String toString() {
        return "Bank_Account{" +
                "acc_no='" + acc_no + '\'' +
                ", balance=" + balance +
                ", cust_id=" + cust_id +
                ", acc_type='" + acc_type + '\'' +
                '}';
    }
}
