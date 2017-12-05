package org.goskyer.base.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by zzqno on 2017-6-23.
 */
public class Student implements Serializable {
    private String name;
    private char sex;
    private int year;
    private double gpa;


    public Student(String name, char sex, int year, double gpa) {
        this.name = name;
        this.sex = sex;
        this.year = year;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "[name:" + name + ",sex:" + sex + ",year:" + year + ",gpa:" + gpa + "]";
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       /* out.writeDouble(gpa);
        out.writeInt(year);
        out.writeChar(sex);*/
        out.writeChars(name);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    /*    year = in.readInt();
        gpa = in.readDouble();
        sex = in.readChar();*/
    }

}
