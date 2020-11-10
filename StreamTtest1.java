
import java.util.ArrayList;
import java.util.List;

class StreamTtest1 {

    static class Energyplanitemidmap {

        Integer id_source;
        Integer id_dest;

        Energyplanitemidmap(
                Integer id_source,
                Integer id_dest
        ) {
            this.id_source = id_source;
            this.id_dest = id_dest;
        }
    }

    public static void main(String[] args) {
        List<Energyplanitemidmap> energyplanitemidmap = new ArrayList<>();
        energyplanitemidmap.add(new Energyplanitemidmap(101, 201));
        energyplanitemidmap.add(new Energyplanitemidmap(102, 202));
        energyplanitemidmap.add(new Energyplanitemidmap(103, 203));
        energyplanitemidmap.add(new Energyplanitemidmap(104, 204));
        energyplanitemidmap.add(new Energyplanitemidmap(105, 205));
        Integer ownerenergyplanitem_id = 104;
        Integer id_dest = null;
        for (Energyplanitemidmap value : energyplanitemidmap) {
            if (value.id_source.equals(ownerenergyplanitem_id)) {
                id_dest = value.id_dest;
                break;
            }
        }
        System.out.println("id_dest=" + id_dest);
        energyplanitemidmap.stream()
                .filter(e -> e.id_source.equals(ownerenergyplanitem_id))
                .forEach(p -> System.out.println(p.id_dest));
        id_dest = energyplanitemidmap.stream()
                .filter(e -> e.id_source.equals(ownerenergyplanitem_id))
                .findAny()
                .orElse(new Energyplanitemidmap(null,null)).id_dest;
        System.out.println(id_dest);
        id_dest = energyplanitemidmap.stream()
                .filter(e -> e.id_source.equals(ownerenergyplanitem_id))
                .map(e->e.id_dest)
                .findAny()
                .orElse(null);
        System.out.println(id_dest);
    }
}