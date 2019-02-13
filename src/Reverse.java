/**
 * @Author fuyou
 * @Date 2019/2/13 14:23
 */
public class Reverse {
    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
//        for (int m = 0; m < 10000; m++) {
        System.out.println(solution(1234558888));
//        }
//        System.out.println(System.currentTimeMillis());
    }

    public static int solution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
