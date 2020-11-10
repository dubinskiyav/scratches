import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

class FileInputStreamTest {

    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    public static void main(String[] args) {
        try {
            //указание пути до файла с настройками
            fileInputStream = new FileInputStream(
                    "D:\\WORK\\Programming\\SakhalinMonitor\\src\\test\\resources\\conf1.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
            //
            System.out.println(PROPERTIES.getProperty("username"));


        } catch (IOException e) {
            e.printStackTrace();
            //обработка возможного исключения (нет файла и т.п.)
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}