import java.math.BigDecimal;
import java.math.RoundingMode;

class BigDecimalText {

    public static void main(String[] args) {
        double test = 1.23456;
        BigDecimal b = new BigDecimal(test);
        System.out.println(b);
        b = b.setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(b);


    }
}