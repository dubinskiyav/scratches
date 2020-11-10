import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class JoinTest02 {

    public static void main(String[] args) {
        class Towntype {

            Integer towntypeId;
            String towntypeCode;
            String towntypeName;

            public Towntype(
                    Integer towntypeId,
                    String towntypeCode,
                    String towntypeName
            ) {
                this.towntypeId = towntypeId;
                this.towntypeCode = towntypeCode;
                this.towntypeName = towntypeName;
            }

            public String toString() {
                return towntypeId + " " + towntypeCode + " " + towntypeName;
            }
        }
        List<Towntype> towntypeList = new ArrayList<>();
        towntypeList.add(new Towntype(1, "г.", "Город"));
        towntypeList.add(new Towntype(2, "п.", "Поселок"));
        towntypeList.add(new Towntype(3, "д.", "Деревня"));
        System.out.println("Типы населенных пунктов");
        towntypeList.stream()
                .forEach(tt -> System.out.println(tt));
        class Town {

            Integer townId;
            Integer towntypeId;
            String townName;

            public Town(
                    Integer townId,
                    Integer towntypeId,
                    String townName
            ) {
                this.townId = townId;
                this.towntypeId = towntypeId;
                this.townName = townName;
            }

            public String toString() {
                return townId + " " + towntypeId + " " + townName;
            }
        }
        List<Town> townList = new ArrayList<>();
        townList.add(new Town(1, 1, "Пермь"));
        townList.add(new Town(2, 1, "Екатеринбург"));
        townList.add(new Town(3, 4, "Новоуткинск"));
        townList.add(new Town(4, 3, "Чебаркуль"));
        System.out.println("Населенные пункты");
        townList.stream()
                .forEach(t -> System.out.println(t));
        class TownTowntype {

            Integer townId;
            Integer towntypeId;
            String townName;
            String towntypeCode;
            String towntypeName;

            public TownTowntype(
                    Integer townId,
                    Integer towntypeId,
                    String townName,
                    String towntypeCode,
                    String towntypeName
            ) {
                this.townId = townId;
                this.towntypeId = towntypeId;
                this.townName = townName;
                this.towntypeCode = towntypeCode;
                this.towntypeName = towntypeName;
            }

            public String toString() {
                return townId + " " + towntypeId + " " + townName + " " + towntypeCode + " "
                        + towntypeName;
            }
        }
        System.out.println("Соединение населенных пунктов с типами");
        townList.stream()
                .flatMap(town -> {
                    return towntypeList
                            .stream()
                            .filter(tt -> tt.towntypeId.equals(town.towntypeId))
                            .map(tt -> new TownTowntype(town.townId, town.towntypeId, town.townName, tt.towntypeCode, tt.towntypeName));
                })
                .forEach(t -> System.out.println(t));
        System.out.println("Левое Соединение населенных пунктов с типами");
        townList.stream()
                .flatMap(town -> {
                    return towntypeList
                            .stream()
                            .filter(tt -> tt.towntypeId.equals(town.towntypeId))
                            .map(tt -> new TownTowntype(town.townId, town.towntypeId, town.townName, tt.towntypeCode, tt.towntypeName));
                })
                .forEach(t -> System.out.println(t));
    }
}