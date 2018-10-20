package Page1;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个没有重复数字的序列，返回其所有可能的全排列
* */
public class N46_Permutations {

    public static void main(String[] args) {
        List<List<Integer>> lists = permute(new int[]{1, 2, 3});
        for (List list : lists
             ) {
            for (Object a : list
                 ) {
                System.out.print(a + "  ");
            }
            System.out.println();
        }
    }

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
            List temp = new ArrayList(nums.length);

            for (int a : nums
                 ) {
                temp.add(a);
            }
            output.add(temp);
            System.out.println(temp.toString());
        } else {
            for (int i = start; i < nums.length; i++) {
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
}
