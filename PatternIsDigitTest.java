import java.util.regex.Pattern;

class PatternIsDigitTest {

    public static void main(String[] args) {
        Pattern digitPattern = Pattern.compile("\\p{IsDigit}"); // ".** \\d.** "
        System.out.println(digitPattern.matcher("123").find());
        System.out.println(digitPattern.matcher("aaa").find());
        System.out.println(digitPattern.matcher("qqq123ddd").find());

    }
}