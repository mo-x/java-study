package org.xinyu.base.serializable;

import java.io.*;

/**
 * Created by zzqno on 2017-6-23.
 */
public class UseStudent {

    public static void main(String[] args) {
        writeObj();
        readObj();

    }

    public static void writeObj() {
        Student st = new Student("Tom", 'M', 20, 3.6);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\student.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectOutputStream);
            objectOutputStream.writeObject(st);
            objectOutputStream.flush();
            objectOutputStream.close();
            objectOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  static Student readObj(){
        FileInputStream fileIn;
        Student student = null;
        try {
            fileIn = new FileInputStream("D:\\student.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            student = (Student) in.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

}
