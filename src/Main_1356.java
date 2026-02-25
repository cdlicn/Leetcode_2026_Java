import java.util.stream.IntStream;

public class Main_1356 {
    public int[] sortByBits(int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted((a, b) -> {
                    int ca = Integer.bitCount(a);
                    int cb = Integer.bitCount(b);
                    return ca != cb ? ca - cb : a - b;
                })
                .mapToInt(a -> a)
                .toArray();
    }
}
