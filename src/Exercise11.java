import java.io.*;
import java.util.*;

public class Exercise11 {
    public static void main(String[] args) throws IOException {
        PrintWriter out = null;
        BufferedReader reader = null;
        Map<String, Integer> map = new HashMap<>();

        try {
            reader = new BufferedReader(new FileReader("LastnameFrequencies.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                Integer freq = Integer.parseInt(items[1]);
                map.put(items[0], freq);
            }

            out = new PrintWriter(new FileWriter("sorted.txt"));

            Set<String> keys = map.keySet();
            List<String> list = new ArrayList<String>(keys);
            Collections.sort(list);
            for (String lastname: list) {
                out.println(lastname+ "," + map.get(lastname));
            }

        }finally {
            if (reader != null) {
                reader.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
