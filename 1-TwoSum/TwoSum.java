import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public static void main(String[] args) {
        var twoSum = new TwoSum();

//        int[] nums = { 2, 7, 11, 15 };
        int[] nums = { 3,2,4 };
//        int[] nums = { 3,3 };
        int target = 6;

        var start = System.currentTimeMillis();

        var res = twoSum.twoSum(nums, target);

        System.out.println((System.currentTimeMillis() - (double)start)/1000 + " seconds");
        System.out.println();
        System.out.println(res[0] +" "+ res[1]);
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            var diff =  target - nums[i];
            if (map.containsKey(diff)) {
                res[0] = map.get(diff);
                res[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;
    }
}
