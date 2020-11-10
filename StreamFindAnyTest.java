import java.util.ArrayList;
import java.util.Arrays;

class StreamFindAnyTest {

    public static void main(String[] args) {
        ArrayList<Integer> companytype_oc = new ArrayList<>(Arrays.asList(1,2,3,5,6,8,9));
        ArrayList<Integer> companytype_dc = new ArrayList<>(Arrays.asList(1,7));
        // Найти companytype_oc которых нет в companytype_dc
        // не доделано!!!
        int i =companytype_oc.stream()
                .filter(oc -> !companytype_dc.contains(oc))
                .findAny().orElse(0);
        System.out.println(i);
    }
}