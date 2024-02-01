import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();

        int[] nums = { 1,0,-1,0,-2,2 };

        List<List<Integer>> lists = fourSum.fourSum(nums, 0);

        lists.forEach(System.out::println);
        System.out.println();

        int[] nums2 = { 2,2,2,2,2 };

        lists = fourSum.fourSum(nums2, 8);

        lists.forEach(System.out::println);
        System.out.println();

        int[] nums3 = { 2,0,3,0,1,2,4 };
        lists = fourSum.fourSum(nums3, 7);

        lists.forEach(System.out::println);
        System.out.println();


        int[] nums4 = { 1000000000,1000000000,1000000000,1000000000 };
        lists = fourSum.fourSum(nums4, -294967296);

        lists.forEach(System.out::println);
        System.out.println();
    }



    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) return Collections.emptyList();

        Map<String, List<Integer>> res = new HashMap<>();

        Arrays.sort(nums);

        int reserved = 0;

        while (reserved < nums.length - 3) {
            var threeSums = threeSum(nums, target - nums[reserved], reserved + 1);

            for (List<Integer> integers : threeSums) {

                res.putIfAbsent(
                        String.valueOf(nums[reserved]) + nums[integers.get(0)] + nums[integers.get(1)] + nums[integers.get(2)],
                        List.of(
                                nums[reserved],
                                nums[integers.get(0)],
                                nums[integers.get(1)],
                                nums[integers.get(2)]
                        )
                );
            }
            reserved ++;
        }

        return new ArrayList<>(res.values());
    }

    public List<List<Integer>> threeSum(int[] nums, long target, int border) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = border; i < nums.length-2; i++) {
            if (i == border || nums[i] != nums[i-1]) {
                long sum = target-nums[i];

                int min = i + 1;
                int max = nums.length-1;

                if (nums[max] + nums[max-1] < sum || nums[min] + nums[min+1] > sum) {
                    continue;
                }

                while (min < max) {
                    if (min > i + 1 && nums[min-1] == nums[min]) {
                        min++;
                    } else if (max < nums.length - 1 && nums[max+1] == nums[max]) {
                        max--;
                    } else if (nums[min] + nums[max] < sum) {
                        min++;
                    } else if (nums[min] + nums[max] > sum) {
                        max--;
                    } else {
                        res.add(List.of(i, min, max));
                        max--;
                        min++;
                    }
                }
            }
        }

        return res;
    }
}
