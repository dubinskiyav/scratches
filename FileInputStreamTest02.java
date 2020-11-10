import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

class FileInputStreamTest02 {

    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("conf.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert fileInputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,
                StandardCharsets.UTF_8);
        Properties PROPERTIES = new Properties();
        try {
            PROPERTIES.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}