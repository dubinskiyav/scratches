import java.util.Arrays;

class AssertTest {

    public static void main(String[] args) {
        for (int i : Arrays.asList(-1,1,2,3,15)) {
            System.out.println("i=" + i + " factorial(i)=" + factorial(i));
        }

    }

    // Считает факториал числа n.
    // Число n должно лежать в пределах от 0 до 10 включительно.
    static int factorial(int n) {
        // Факториал отрицательного числа не считается
        assert (n >= 0) : "Connection is null";

        // Если n превысит 10, то это может привести либо к целочисленному
        // переполнению результата, либо к переполнению стэка.
        assert (n <= 10);

        if (n < 2) {
            return 1;
        }

        return factorial(n - 1) * n;
    }
}