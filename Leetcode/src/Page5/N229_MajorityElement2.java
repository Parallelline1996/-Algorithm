package Page5;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
* 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
* */
public class N229_MajorityElement2 {

    // https://blog.csdn.net/magicbean2/article/details/73737526

    public static void main(String[] args) {
        List<Integer> list = majorityElement(new int[]{3, 2, 3});
        for (Integer a : list
                ) {
            System.out.print(a + "  ");
        }
        System.out.println();

        list = majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
        for (Integer a : list) {
            System.out.print(a + "  ");
        }
        System.out.println();

        list = majorityElement(new int[]{1, 2, 3, 4});
        for (Integer a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    // 这个解法遇到【1，2，3，4】这种就错了，注意看题。这道题不再是一定存在
    private static List<Integer> majorityElement(int[] nums) {
        List<Integer> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        if (nums.length == 1) {
            lists.add(nums[0]);
            return lists;
        }
        int n1 = nums[0], n2 = nums[0], n3 = nums[0];
        int num1 = 0, num2 = 0, num3 = 0;
        boolean moreThanThreeNumber = false;
        for (int a : nums
                ) {
            if (num1 == 0) {
                num1 = 1;
                n1 = a;
                continue;
            }
            if (n1 == a) {
                num1++;
                continue;
            }
            if (num2 == 0) {
                num2 = 1;
                n2 = a;
                continue;
            }
            if (n2 == a) {
                num2++;
                continue;
            }
            n3 = a;
            num3++;

            while (num1 > 0 && num2 > 0 && num3 > 0) {
                num1--;
                num2--;
                num3--;
                moreThanThreeNumber = true;
            }
            if (num1 == 0) {
                num1 = num2;
                n1 = n2;
                num2 = num3;
                n2 = n3;
                num3 = 0;
                continue;
            }
            if (num2 == 0) {
                num2 = num3;
                n2 = n3;
                num3 = 0;
            }
        }

        if (moreThanThreeNumber) {
            if (num1 > 0) {
                lists.add(n1);
            }
            if (num2 > 0) {
                lists.add(n2);
            }
        } else {
            double k = nums.length / 3.0;
            if ((double)num1 > k) {
                lists.add(n1);
            }
            if ((double)num2 > k) {
                lists.add(n2);
            }
        }
        return lists;
    }
}
