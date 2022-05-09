public class RemoveDuplicates {

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();

        int[] nums = {1,1,2};

        int k = removeDuplicates.removeDuplicates(nums);

        System.out.println("k: " + k);

        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int counter = 1;
        int pos = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {

                if (pos != i) {
                    nums[pos] = nums[i];
                }

                counter ++;
                pos++;
            }
        }

        return counter;
    }
}
