package org.xinyu.thread.pipedStream;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by zzqno on 2017-6-8.
 * 线程间通信 管道字符流
 * PipedReader
 * PipedWriter
 */
public class BufferTest {

    public static void main(String[] args) {
        WriterBuffer writerBuffer = new WriterBuffer();
        ReadBuffer readBuffer = new ReadBuffer();

        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        try {
            pipedReader.connect(pipedWriter);
            ReadBufferThread readBufferThread = new ReadBufferThread(readBuffer, pipedReader);
            readBufferThread.start();
            Thread.sleep(2000);
            WriteBufferThread writeBufferThread = new WriteBufferThread(writerBuffer, pipedWriter);
            writeBufferThread.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WriterBuffer {

    public void writeMethod(PipedWriter writer) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                writer.write(outData);
                System.out.println("outData:" + outData);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadBuffer {
    public void readMethod(PipedReader pipedReader) {
        try {
            System.out.println("read :");
            char[] bytes = new char[3];
            //当没有数据写入时 线程会阻塞在此处
            int readLen = pipedReader.read(bytes);
            while (readLen != -1) {
                String newData = new String(bytes, 0, readLen);
                System.out.println("readData:" + newData);
                readLen = pipedReader.read(bytes);
            }
            System.out.println();
            pipedReader.close();
        } catch (IOException e) {

        }
    }
}

class WriteBufferThread extends Thread {
    private WriterBuffer ReadBuffer;
    private PipedWriter outputStream;

    public WriteBufferThread(WriterBuffer writeData, PipedWriter outputStream) {
        this.ReadBuffer = writeData;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        ReadBuffer.writeMethod(outputStream);
    }
}

class ReadBufferThread extends Thread {
    private ReadBuffer readData;
    private PipedReader pipedReader;

    public ReadBufferThread(ReadBuffer readData, PipedReader pipedReader) {
        this.pipedReader = pipedReader;
        this.readData = readData;
    }

    @Override
    public void run() {
        readData.readMethod(pipedReader);
    }
}