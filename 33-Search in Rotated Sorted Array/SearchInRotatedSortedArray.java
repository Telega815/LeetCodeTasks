public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray search = new SearchInRotatedSortedArray();


        int[] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;

        int[] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;

        int[] nums3 = {1};
        int target3 = 0;

        int[] nums4 = {1, 3};
        int target4 = 2;

        System.out.println(search.search(nums1, target1));
        System.out.println(search.search(nums2, target2));
        System.out.println(search.search(nums3, target3));
        System.out.println(search.search(nums4, target4));

    }

    public int search(int[] nums, int target) {

        return this.search(nums, target, 0, nums.length - 1);

    }

    public int search(int[] nums, int target, int left, int right) {


        if (right - left < 2) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else {
                return -1;
            }
        }

        if (target < nums[left] && target > nums[right]) {
            return -1;
        } else {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            }
        }

        int middle = (right-left) / 2 + left;

        if (nums[middle] == target) {
            return middle;
        }

        if (target > nums[left]) {

            if (nums[middle] < nums[left]) {
                return this.search(nums, target, left, middle);
            } else {

                if (nums[middle] > target) {
                    return this.search(nums, target, left, middle);
                } else {
                    return this.search(nums, target, middle, right);
                }
            }

        } else {
            if (nums[middle] > nums[right]) {
                return this.search(nums, target, middle, right);
            } else {

                if (nums[middle] > target) {
                    return this.search(nums, target, left, middle);
                } else {
                    return this.search(nums, target, middle, right);
                }
            }
        }
    }
}
