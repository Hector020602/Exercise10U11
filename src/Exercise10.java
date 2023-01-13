import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Exercise10 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
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
            String lastname;
            while (true) {
                System.out.println("Enter lastname (empty to exit): ");
                lastname = input.nextLine().toUpperCase();
                if (lastname.equals("")) {
                    break;
                }
                Integer freq = map.get(lastname);
                if (freq == null) {
                    System.out.println("lastname not found");
                }else {
                    System.out.println("Frequency: " + freq);
                }
            }
        }finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}