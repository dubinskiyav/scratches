class ValueOfTest {

    public static void main(String[] args) {
        Integer i = null;
        //if (i == 1) ;
        //if (i.compareTo(1) == 0) ;
        if (Integer.valueOf(1).equals(i)) System.out.println("да");;
        if (Integer.valueOf(i).equals(1)) System.out.println("да");;
    }
}