/*
 * @Description: This is for outputstream testing
 * @author: johnw;
 * @Created: 6/28/2020;
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
        OutputStream out = new FileOutputStream("test.txt");
        //byte[] bt = new byte[1024];
        out.write("hello world".getBytes());
        out.close();
    }
}
