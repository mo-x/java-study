package org.goskyer.base.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileHandle {

    public static void main(String[] args) throws IOException {
        int bufSize = 1200;

        File file = new File("/Users/zhiqin.zhang/Downloads/result.csv");

        FileInputStream fis = new FileInputStream(file);

        FileChannel fcin = fis.getChannel();

        ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);


        String enterStr = "\n";

        try {
            StringBuffer strBuf = new StringBuffer("");

            int lineNum = 0;

            while (fcin.read(rBuffer) != -1) {

                int rSize = rBuffer.position();

                rBuffer.clear();

                String tempString = new String(rBuffer.array(), 0, rSize);
                //最后一行，加入"\n分割符"
                if (fis.available() == 0) {
                    tempString += "\n";
                }

                int fromIndex = 0;

                int endIndex = 0;


                while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {

                    String line = tempString.substring(fromIndex, endIndex);

                    line = new String(strBuf.toString() + line);

                    System.out.println("lineNum =" + ++lineNum);

                    System.out.println(line);

                    strBuf.delete(0, strBuf.length());

                    fromIndex = endIndex + 1;

                }

                if (rSize > tempString.length()) {

                    strBuf.append(tempString.substring(fromIndex, tempString.length()));

                } else {

                    strBuf.append(tempString.substring(fromIndex, rSize));

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }


        System.out.print("OK!!!");

    }
}
