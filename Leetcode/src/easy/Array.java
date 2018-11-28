package easy;

import java.util.HashSet;

public class Array {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int number = removeDuplicates(nums);
        for (int i = 0; i < number; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        int[] num1 = new int[]{1, 2, 3, 4};
        int[] num2 = new int[]{9, 9, 9, 9};
        int[] num3 = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
        num1 = plusOne(num1);
        num2 = plusOne(num2);
        num3 = plusOne(num3);
        for (int a : num1
             ) {
            System.out.print(a + "  ");
        }
        System.out.println();
        for (int a : num2
             ) {
            System.out.print(a + "  ");
        }
        System.out.println();
        for (int a : num3
                ) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }

    /*
    * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    * */
    private static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int number = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }
        return number + 1;
    }

    /*
    * 存在重复
    * 给定一个整数数组，判断是否存在重复元素。
    * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
    * */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int a : nums
                ) {
            if (set.contains(a)) {
                return true;
            }
            set.add(a);
        }
        return false;
    }

    /*
    * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
    * */
    private static int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int output = 0;
        for (int a : nums
             ) {
            output ^= a;
        }
        return output;
    }

    /*
    * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
    * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
    * 你可以假设除了整数 0 之外，这个整数不会以零开头。
    * */
    // 这里不能用转 string 然后再转 int 然后+1的方法，数字太大会爆
    private static int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        boolean allNine = true;
        for (int a : digits
             ) {
            if (a != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            return output;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        return digits;
    }
}
