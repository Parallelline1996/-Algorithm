package Page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a collection of numbers that might contain duplicates,
* return all possible unique permutations.
*
* Example:
* Input: [1,1,2]
* Output:
* [
*   [1,1,2],
*   [1,2,1],
*   [2,1,1]
* ]
* */
public class N47_Permutations2 {

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
//        for (List list : lists
//                ) {
//            for (Object a : list
//                    ) {
//                System.out.print(a + "  ");
//            }
//            System.out.println();
//        }
        System.out.println();

        lists = permute(new int[]{1, 1, 3});
        for (List list : lists
                ) {
            for (Object a : list
                    ) {
                System.out.print(a + "  ");
            }
            System.out.println();
        }
    }

    // 这种解法相对较慢，因为判断那个是否存在的过程中，要从头开始遍历
    private static List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        permute(nums, 0, list);
        return list;
    }

    private static void permute(int[] nums, int start, List<List<Integer>> output) {
        if (start == nums.length - 1) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int a : nums
                    ) {
                temp.add(a);
            }
            if (!output.contains(temp)) {
                output.add(temp);
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == nums[start] && i != start) {
                    continue;
                }
                swap(nums, start, i);
                permute(nums, start + 1, output);
                swap(nums, start, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 更高效的解法
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        helper(res, new ArrayList<Integer>(), nums, visit);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visit) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !visit[i-1]) {
                continue;
            }
            list.add(nums[i]);
            visit[i] = true;
            helper(res, list, nums, visit);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}
