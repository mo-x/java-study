package org.xinyu.base.serializable;

import java.io.*;

/**
 * Created by zzqno on 2017-6-24.
 */
public class Test {
    public static void main(String[] args) {
        File file = new File("d:\\student.out");
        Student st = new Student("Tom", 'M', 20, 3.6);
        try{
            ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
            oout.writeObject(st);
            oout.close();

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
            Object readObject = oin.readObject(); // 没有强制转换到Person类型
            Student student;
            if(readObject instanceof Student){
                student = (Student) readObject;
                System.out.println(student.getSex());
            }
            oin.close();
            System.out.println(readObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
