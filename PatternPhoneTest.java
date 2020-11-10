import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class PatternPhoneTest {

    public static void main(String[] args) {
        Pattern digitPattern = Pattern.compile("^(\\d|\\+|\\()([0-9]|[-)])*");
        String s = "(424 31) 5-09-12, (424 31) 5-09-12,8 (424 31) 5-09-12, +79261234567, 3-45678, s3323354543, 3s333333";
        Arrays.stream(s.replaceAll("\\s+", "").split(",")).forEach(p -> {
            System.out.print(p + "     ");
            System.out.println(digitPattern.matcher(p).find());
        });
        for (String number : s.replaceAll("\\s+", "").split(",")) {
            System.out.println(number);
        }
    }
    // Самолет который пролетел сильно шумел


}