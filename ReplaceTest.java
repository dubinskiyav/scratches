class ReplaceTest {

    public static void main(String[] args) {
        String str = "12345678899";
        String substr = "00";
        System.out.println(str.replace("34",substr));
        substr = null;
        System.out.println(str.replace("56",substr != null ? substr : ""));
    }
}