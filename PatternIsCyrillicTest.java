import java.util.regex.Pattern;

class PatternIsCyrillicTest {

    public static void main(String[] args) {
        String s = "www";
        Pattern p = Pattern.compile("\\p{IsCyrillic}");
        System.out.println(p.matcher("www").find());
        System.out.println(p.matcher("ыыы").find());
        System.out.println(p.matcher("www ыыы").find());
        System.out.println(p.matcher("1234567890").find());
        System.out.println(p.matcher("ы11111").find());
        System.out.println(p.matcher("Приве  w тпри 1, ыыыыыы ввввв").find());
       // System.out.println(p.matcher(s.substring(0,Math.min(30, s.length()))).find());
    }
}