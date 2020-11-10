import java.util.Properties;

class getPropertiesTest {

    public static void main(String[] args) {
        Properties p = new Properties(System.getProperties());
        //p.list(System.out);
        System.out.println(System.getProperty("java.io.tmpdir"));
    }
}