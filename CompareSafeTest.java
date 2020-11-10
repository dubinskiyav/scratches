import java.util.Arrays;
import java.util.Date;

class CompareSafeTest {

    public static void main(String[] args) {
        System.out.println("true " + compareSafe(new Date(10), "<", new Date(20)));
        System.out.println("false " + compareSafe(new Date(10), ">", new Date(20)));
        System.out.println("true " + compareSafe(new Date(), "=", new Date()));
        System.out.println("false " + compareSafe(new Date(10), "=", new Date(20)));
        System.out.println("true " + compareSafe(new Date(123), "=", new Date(123)));
        System.out.println("true " + compareSafe(new Date(123), "<=", new Date(123)));
        System.out.println("false " + compareSafe(new Date(1234), "<=", new Date(123)));
        System.out.println("true " + compareSafe(new Date(123), ">=", new Date(123)));
        System.out.println("true " + compareSafe(new Date(1234), ">=", new Date(123)));
    }

    // проверяет утверждение по сравнению дат
    public static boolean compareSafe(Date d1, String sign, Date d2) {
        // Если что-то пустое - утверждение о сравнении не верное
        if (d1 == null || d2 == null || sign == null) {return false;}
        if (sign.equals("=")) {sign = "==";}
        switch (sign) {
            case "<":
                return d1.compareTo(d2) < 0;
            case "<=":
                return d1.compareTo(d2) <= 0;
            case ">":
                return d1.compareTo(d2) > 0;
            case ">=":
                return d1.compareTo(d2) >= 0;
            case "==":
                return d1.compareTo(d2) == 0;
            case "!=":
                return d1.compareTo(d2) != 0;
            default:
                return false;
        }
    }
    // проверяет утверждение по сравнению целых
    public static boolean compareSafe(Integer i1, String sign, Integer i2) {
        // Если что-то пустое - утверждение о сравнении не верное
        if (i1 == null || i2 == null || sign == null) {return false;}
        if (sign.equals("=")) {sign = "==";}
        switch (sign) {
            case "<":
                return i1 < i2;
            case "<=":
                return i1 <= i2;
            case ">":
                return i1 > i2;
            case ">=":
                return i1 >= i2;
            case "==":
                return i1.equals(i2);
            case "!=":
                return !i1.equals(i2);
            default:
                return false;
        }
    }
}