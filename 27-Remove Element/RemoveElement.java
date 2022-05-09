public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();

        int[] nums = {0,1,2,2,3,0,4,2};

        int k = removeElement.removeElement(nums, 2);

        System.out.println("k: " + k);

        System.out.println();
        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int counter = 0;
        int pos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (pos != i) {
                    nums[pos] = nums[i];
                }
                pos ++;
                counter ++;
            }
        }

        return counter;
    }
}
