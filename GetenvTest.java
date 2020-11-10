import java.util.Optional;

class GetenvTest {

    public static void main(String[] args) {
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println(javaHome);
        System.out.println(Optional.ofNullable(System.getenv("tel")).orElse("89058611060"));
        System.out.println(Optional.ofNullable(System.getenv("town")).orElse("Gelicon2020!"));
        System.out.println(System.getenv("town") != null ? System.getenv("town") : "Gelicon2020!");
    }
}