import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.BufferOverflowException;
import java.util.*;

public class Exercise12 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = null;
        Map<String, Integer> map = new HashMap<>();
        try {
            input = new BufferedReader(new FileReader("Colfuturo-Seleccionados.csv"));
            String line = input.readLine();
            while ((line = input.readLine()) != null) {
                String[] items = line.split(",");
                String country = items[6];
                Integer freq = map.get(country);
                map.put(country, freq == null ? 1 : freq + 1);
            }
            Set<String> keys = map.keySet();
            List<Pair> list = new ArrayList<>();
            for (String key : keys) {
                list.add(new Pair(key, map.get(key)));
            }
            Collections.sort(list);
            Collections.reverse(list);
            for (Pair pair : list) {
                System.out.println(pair.key + ": " + pair.value);
            }
        }finally {
            if (input != null)
                input.close();
        }

    }
}
