import java.util.ArrayList;
import java.util.List;

public class MedianofTwoSortedArrays {

    static int[] x = {3};
    static int[] y = {-2, -1};
    public static void main(String[] args) {
        var A = new MedianofTwoSortedArrays();

        System.out.println(A.findMedianSortedArrays(x, y));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return find(nums2);
        } else if (nums2.length == 0){
            return find(nums1);
        }

        if (nums1.length < nums2.length)
            return findMedian(nums1, nums2);
        else
            return findMedian(nums2, nums1);
    }

    public double find(int[] nums1) {
        if (nums1.length % 2 == 1) {
            return nums1[nums1.length/2];
        } else {
            return 0.5 * (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]);
        }
    }

    public double findMedian(int[] smaller, int[] larger) {
        int total = smaller.length + larger.length;
        int half = total / 2;

        int left = 0;
        int right = smaller.length - 1;

        while (true) {
            int sPointer = left > right ? -1 : (left + right) / 2;
            int lPointer = half - 2 - sPointer;


            int sA = sPointer >= 0 ? smaller[sPointer] : Integer.MIN_VALUE;
            int sB = (sPointer + 1) < smaller.length ? smaller[sPointer + 1] : Integer.MAX_VALUE;

            int lA = lPointer >= 0 ? larger[lPointer] : Integer.MIN_VALUE;
            int lB = (lPointer + 1) < larger.length ? larger[lPointer + 1] : Integer.MAX_VALUE;

            if (sA <= lB && lA <= sB) {
                if (total % 2 == 1) {
                    return Integer.min(sB, lB);
                } else {
                    return (Integer.max(sA, lA) + Integer.min(sB, lB)) / 2.0;
                }

            } else if (sA > lB){
                right = sPointer - 1;
            } else {
                left = sPointer + 1;
            }
        }
    }
}
