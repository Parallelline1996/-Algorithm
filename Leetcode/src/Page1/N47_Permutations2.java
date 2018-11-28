package Page1;

import java.util.ArrayList;
import java.util.List;

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
}
