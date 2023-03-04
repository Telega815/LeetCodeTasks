import java.util.Arrays;

public class FindFirstLastSortedArray {

    public static void main(String[] args) {
        FindFirstLastSortedArray findFirstLastSortedArray = new FindFirstLastSortedArray();

        int [] arr = {8,8,8,8,8,8};
        int target = 8;

        System.out.println(Arrays.toString(findFirstLastSortedArray.searchRange(arr, target)));

    }

    private int breakPoint = 0;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int end = nums.length - 1;

        this.breakPoint = end;

        end = searchEnd(nums, target, 0, end);
        int start = searchStart(nums, target, 0, this.breakPoint);

        return new int[]{start, end};
    }

    private int searchEnd(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        boolean endCondition = (nums[end] == target) && (end + 1 >= nums.length || nums[end+1] > target);

        if (endCondition) {
            return end;
        }

        int center = (end - start) / 2 + start;

        if (nums[center] > target) {
            this.breakPoint = center;
            return searchEnd(nums, target, start, center - 1);
        }

        if (nums[center] == target && (center + 1 == nums.length || nums[center + 1] > target)) {
            this.breakPoint = center;
            return center;
        }

        return searchEnd(nums, target, center + 1, end);
    }

    private int searchStart(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        boolean startCondition = (nums[start] == target) && (start - 1 <= -1 || nums[start - 1] < target);

        if (startCondition) {
            return start;
        }

        int center = (end - start) / 2 + start;

        if (nums[center] < target) {
            return searchStart(nums, target, center + 1, end);
        }

        if (nums[center] == target && (center - 1 == -1 || nums[center - 1] < target)) {
            return center;
        }

        return searchStart(nums, target, start, center - 1);
    }
}
