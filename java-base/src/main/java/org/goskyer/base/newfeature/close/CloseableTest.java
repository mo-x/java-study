package org.goskyer.base.newfeature.close;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by zhangzhiqin on 2017/6/13.
 * try with source
 *
 */
public class CloseableTest {

    public static void main(String[] args) {
        try (Resource res = new Resource();
             ResourceOther resOther = new ResourceOther();) {
            res.doSome();
            resOther.doSome();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //jdk7以前写法
    static String readFirstLingFromFile(String path) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                br.close();
        }
        return null;
    }

    //try-with-source
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static class Resource implements AutoCloseable {
        void doSome() {
            System.out.println("do something");
        }

        @Override
        public void close() throws Exception {
            System.out.println("resource closed");
        }
    }

    static class ResourceOther implements AutoCloseable {
        void doSome() {
            System.out.println("do something other");
        }

        @Override
        public void close() throws Exception {
            System.out.println("other resource closed");
        }
    }
}
