public class ContainerMostWater {

    public static void main(String[] args) {
        ContainerMostWater containerMostWater = new ContainerMostWater();

        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int[] height2 = {1,1};

        System.out.println(containerMostWater.maxArea(height1));
        System.out.println(containerMostWater.maxArea(height2));
    }

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length -1;

        while (left < right) {
            int square = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(square, res);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return res;
    }
}
