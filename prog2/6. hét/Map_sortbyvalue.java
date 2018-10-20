import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Map_sortbyvalue {

    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<String, Double>();    //hash táblával megvalósitott map, kulcs-érték párokat tartalmaz
        ValueComparator bvc = new ValueComparator(map);     //  összehasonlít két double típusú értéket, -1 ha a<b, 0 ha a=b és 1 ha a>b
        TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc); //kulcs szerint rendezett map, new ... (bvc)-vel megadjuk, hogy bvc komperátor szerint rendezze a mapet

        map.put("A", 80.0);
        map.put("B", 10.0);
        map.put("C", 22.5);
        map.put("D", 10.0);

        System.out.println("unsorted map: " + map);
        sorted_map.putAll(map);
        System.out.println("sorted map: " + sorted_map);
    }
}

class ValueComparator implements Comparator<String> {
    Map<String, Double> base;

    public ValueComparator(Map<String, Double> base) {  //konstruktor, ami egy mapet kap meg
        this.base = base;   //létrehoztunk egy map változót, amibe belerakjuk a konstruktornál megadottat
    }

    @Override
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {   //ha a>=b akkor 1 et ad vissza,ezt azért, h növekvő sorrendbe rakja
            return 1;                       //base.get(a) -> az a kulcshoz tartozó értéket adja vissza; tehát a compare két kulcsot kap meg, majd a kulcsok szerinti érték alapján rendez
        } else {
            return -1;
        }
    }
}