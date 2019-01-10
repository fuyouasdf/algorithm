import java.util.HashMap;
import java.util.Map;

/**
 * @Author fuyou
 * @Date 2019/1/10 9:40
 */
public class Fibonacci {

    public static final int[] source = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 123};
    public static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < source.length; i++) {
                fn2(source[i]);
            }
        }
        System.out.println(System.currentTimeMillis());
    }

    public static int fn(int n) {
        int tem;
        if (n < 1 || n > 30) {
            return 0;
        }
        if (n == 1) return 1;
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            tem = fn(n - 1) + fn(n - 2);
            cache.put(n, tem);
            return tem;
        }
    }

    public static int fn2(int n) {
        int a = 0, b = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return n == 0 ? a : b;
    }
}
