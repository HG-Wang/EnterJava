package testIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOTest {
    public static void main(String[] args) throws IOException {
        //第二个参数为true表示追加，false表示覆盖
        FileOutputStream fos = new FileOutputStream("src/tg.txt", true);
        String str = " abc\r\n another line";
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));
        fos.write(bytes);
        fos.write("apppnd".getBytes());
        fos.close();
    }
}
