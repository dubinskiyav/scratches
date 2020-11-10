import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

class FileInputStreamUTF8Test {

    public static void main(String[] args) throws IOException {
        Properties properties;
        InputStream stream = null;
        InputStreamReader reader = null;
        try {
            properties = new Properties();
            stream = new FileInputStream(new File("D:\\WORK\\Programming\\SakhalinMonitor\\src\\test\\resources\\conf1.properties"));
            reader = new InputStreamReader(stream,"UTF-8");
            properties.load(reader);
            System.out.println("username: " + properties.getProperty("username"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
            if (reader != null) {
                reader.close();
            }
        }
    }
}