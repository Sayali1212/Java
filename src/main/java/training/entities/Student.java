package training.entities;

public class Student {
    private int rollno;
    private String sname;
    private String email;

    public Student()
    {

    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", sname='" + sname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Student(int rollno, String sname, String email) {
        this.rollno = rollno;
        this.sname = sname;
        this.email = email;

    }



}
