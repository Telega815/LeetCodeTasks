import java.util.Arrays;

public class SingleElementSortedArray {

    public static void main(String[] args) {
        SingleElementSortedArray singleElementSortedArray = new SingleElementSortedArray();

        int [] arr = {1,1,2,2,3,3,4,4,8};

        System.out.println(singleElementSortedArray.singleNonDuplicate(arr));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return singleNonDuplicate(nums, 0, nums.length - 1);
    }

    private int singleNonDuplicate(int[] nums, int start, int end) {
        if (start == end) return nums[start];

        if (end - start + 1 == 3) {
            if (nums[start + 1] == nums[start]) {
                return nums[end];
            }

            if (nums[start + 1] == nums[end]) {
                return nums[start];
            }
        }

        int center = (end - start) / 2 + start;

        if (nums[center] != nums[center + 1] && nums[center] != nums[center - 1]) {
            return nums[center];
        }

        if (nums[center] == nums[center - 1]) {
            return singleNonDuplicate(nums, start, center - 2);
        }

        return singleNonDuplicate(nums, start + 2, end);
    }
}
