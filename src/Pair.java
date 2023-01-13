public class Pair implements Comparable <Pair> {
    public String key;
    public Integer value;

    public Pair(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair pair) {
        return this.value.compareTo(pair.value);
        //pair.value - this.value;
    }
}
