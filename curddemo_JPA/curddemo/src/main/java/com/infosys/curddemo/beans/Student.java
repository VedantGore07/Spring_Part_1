package com.infosys.curddemo.beans;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_stud")
@NamedQuery(
        name = "Student.findAllStudent",
        query = "select s from Student s"
)
//@NamedQuery(
//        name = "Student.findByEmail",
//        query = "select s from student s where s.studentEmail = :sEmail"
//)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sId;
    private String sName;
    private String sEmail;

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sEmail='" + sEmail + '\'' +
                '}';
    }


    public Student(int sId, String sName, String sEmail) {
        this.sId = sId;
        this.sName = sName;
        this.sEmail = sEmail;
    }


    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }




}
