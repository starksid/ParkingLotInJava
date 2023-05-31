// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press
//
// Enter. You can now see whitespace characters in your code.
import java.util.HashMap;
import java.util.Map;

class Mate {
    public int id;

    public Mate(int id) {
        this.id = id;
    }
}

public class Main {
    public static void main(String[] args) {

        Map<Integer, Mate> entryMateMap = new HashMap<>();
        Mate mate = new Mate(1);
        entryMateMap.put(mate.id, mate);
        System.out.println(entryMateMap);


    }
}