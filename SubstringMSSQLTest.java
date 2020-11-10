class SubstringMSSQLTest {

    public static void main(String[] args) {
        System.out.println("null = " + substringMSSQL(null,2,3));
        System.out.println("null = " + substringMSSQL("12",3,3));
        System.out.println("2 = " + substringMSSQL("12",2,3));
        System.out.println("234 = " + substringMSSQL("1234",2,4));
        System.out.println("2345 = " + substringMSSQL("12345",2,4));
        System.out.println("2345 = " + substringMSSQL("123456",2,4));
    }
    // Возвращает подстроку как SUBSTRING (Transact-SQL)
    // start начинается с 1, если длина превышает исходную - до конца исходной
    public static String substringMSSQL (String expression ,int start , int length) {
        if (expression == null || start < 1 || length < 1) {return null;}
        if (expression.length() < start) {return null;}
        if (expression.length() < start + length ) {
            return expression.substring(start - 1);
        } else {
            return expression.substring(start - 1, start - 1 + length);
        }
    }
}