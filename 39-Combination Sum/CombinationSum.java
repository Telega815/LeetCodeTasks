import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();


        int[] nums1 = {2,3,6,7};
        int target1 = 7;

        int[] nums2 = {2,3,5};
        int target2 = 8;

        int[] nums3 = {2};
        int target3 = 1;

        int[] nums4 = {7,3,2};
        int target4 = 18;

        int[] nums5 = {5,10,8,4,3,12,9};
        int target5 = 27;



        System.out.println(combinationSum.combinationSum(nums1, target1));
        System.out.println();
        System.out.println(combinationSum.combinationSum(nums2, target2));
        System.out.println();
        System.out.println(combinationSum.combinationSum(nums3, target3));
        System.out.println();
        System.out.println(combinationSum.combinationSum(nums4, target4));
        System.out.println();
        System.out.println(combinationSum.combinationSum(nums5, target5));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        var res = new ArrayList<List<Integer>>();

        var set = combinationSet2(candidates, target);

        for (var integers: set) {
            if (!contains(res, integers)) {
                res.add(integers);
            }
        }


        return res.stream()
                .map(integers -> integers.stream().toList())
                .toList();
    }

    public List<List<Integer>> combinationSet2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (target == 1) return Collections.emptyList();

        for (int candidate : candidates) {

            if (candidate == target) {
                List<Integer> solution = new ArrayList<>();
                solution.add(candidate);

                res.add(solution);
                continue;
            }

            int nextTarget =  target - candidate;
            if (nextTarget < 2) {
                continue;
            }

            var list = combinationSet2(candidates, nextTarget);

            for (var integers : list) {
                integers.add(candidate);

                res.add(integers);
            }

        }

        return res;
    }

    private boolean contains(List<List<Integer>> result, List<Integer> addable) {
        return result.stream().anyMatch(integers -> {
            if (integers.size() != addable.size()) {
                return false;
            }

            var list1 = integers.stream().sorted().toList();

            var list2 = addable.stream().sorted().toList();

            for (int i = 0; i < list1.size(); i++) {
                if (!Objects.equals(list1.get(i), list2.get(i))) {
                    return false;
                }
            }

            return true;
        });
    }
}
