package org.xinyu.currency.pipedStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by zzqno on 2017-6-8.
 * 线程管道通信 字节流
 * PipedInputStream
 * PipedOutputStream
 */
public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                outputStream.write(outData.getBytes());
                System.out.println("outData:" + outData);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();

        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();
        try {
            //outputStream.connect(inputStream);
            inputStream.connect(outputStream);
            ReadThread readThread = new ReadThread(readData, inputStream);
            readThread.start();
            Thread.sleep(2000);
            WriteThread writeThread = new WriteThread(writeData, outputStream);
            writeThread.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class ReadData {
    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read :");
            byte[] bytes = new byte[20];
            //当没有数据写入时 线程会阻塞在此处
            int readLen = inputStream.read(bytes);
            while (readLen != -1) {
                String newData = new String(bytes, 0, readLen);
                System.out.println("readData:" + newData);
                readLen = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        } catch (IOException e) {

        }
    }
}

class WriteThread extends Thread {
    private WriteData writeData;
    private PipedOutputStream outputStream;

    public WriteThread(WriteData writeData, PipedOutputStream outputStream) {
        this.writeData = writeData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        writeData.writeMethod(outputStream);
    }
}

class ReadThread extends Thread {
    private ReadData readData;
    private PipedInputStream inputStream;

    public ReadThread(ReadData readData, PipedInputStream inputStream) {
        this.inputStream = inputStream;
        this.readData = readData;
    }

    @Override
    public void run() {
        readData.readMethod(inputStream);
    }
}