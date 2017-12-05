package org.goskyer.base.serializable;

import java.io.*;

/**
 * Created by zzqno on 2017-6-25.
 */
public class SerializeTester {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("d:\\out.ser");

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        SessionDTO dto = new SessionDTO(1);
        oos.writeObject(dto);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        dto = (SessionDTO) ois.readObject();
        System.out.println("data : " + dto.getData()
                + " activation time : " + dto.getActivationTime());
        ois.close();
    }
}


class SessionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private transient int data; // Stores session data

    //Session activation time (creation, deserialization)
    private transient long activationTime;

    public SessionDTO(int data) {
        this.data = data;
        this.activationTime = System.currentTimeMillis();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(data);
        System.out.println("session serialized");
    }

    private void readObject(ObjectInputStream ois) throws IOException,
            ClassNotFoundException {
        ois.defaultReadObject();
        data = ois.readInt();
      //  activationTime = System.currentTimeMillis();
        System.out.println("session deserialized");
    }

    public int getData() {
        return data;
    }

    public long getActivationTime() {
        return activationTime;
    }
}
