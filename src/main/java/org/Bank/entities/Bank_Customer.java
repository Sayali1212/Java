package org.Bank.entities;

import java.time.LocalDate;

public class Bank_Customer {
    private int cid;
    private String fname;
    private String lnmae;
    private String branch;
    private String phn_no;
    private LocalDate doj;

    public Bank_Customer() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLnmae() {
        return lnmae;
    }

    public void setLnmae(String lnmae) {
        this.lnmae = lnmae;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPhn_no() {
        return phn_no;
    }

    public void setPhn_no(String phn_no) {
        this.phn_no = phn_no;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    public Bank_Customer(int cid, String fname, String lnmae, String branch, String phn_no, LocalDate doj) {
        this.cid = cid;
        this.fname = fname;
        this.lnmae = lnmae;
        this.branch = branch;
        this.phn_no = phn_no;
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Bank_Customer{" +
                "cid=" + cid +
                ", fname='" + fname + '\'' +
                ", lnmae='" + lnmae + '\'' +
                ", branch='" + branch + '\'' +
                ", phn_no='" + phn_no + '\'' +
                ", doj=" + doj +
                '}';
    }
}
