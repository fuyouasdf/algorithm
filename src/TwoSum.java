import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] result = {0};
        long start = System.currentTimeMillis();
        result = mapTwoSum(new int[]{1, 7, 11, 2}, 9);
        long costTime = System.currentTimeMillis() - start;
        System.out.println(Arrays.toString(result));
        System.out.println("cost " + costTime + " ms");
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }

            }
        }
        return result;
    }

    public static int[] mapTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return nums;
    }
}
