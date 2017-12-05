package org.goskyer.base.staticserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zzqno on 2016-9-27.
 */
public class Response {
    private static final int BUFFER_SIZE = 1024;

    private Request request;
    private OutputStream output;

    public Response(OutputStream output) {

        this.output = output;

    }

    public void setRequest(Request request) {

        this.request = request;

    }

    /**
     * 输出页面
     * @throws IOException
     */
    public void sendStaticResource() throws IOException {

        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;

        File file = new File(HttpServer.WEB_ROOT, request.getUri());

        if (file.exists()) {

            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, BUFFER_SIZE);

            while (ch != -1) {

                output.write(bytes, 0, ch);
                ch = fis.read(bytes, 0, BUFFER_SIZE);
            }

        } else {

            // file not found
            String errorMessage = "HTTP/1.1 404 File NOT Fount\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            output.write(errorMessage.getBytes());
        }

        if (fis != null) {

            fis.close();

        }

    }
}
