package Official_website;


import java.util.HashMap;

/*
* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given numbers = [2, 7, 11, 15], target = 9,

Because numbers[0] + numbers[1] = 2 + 7 = 9,
return [0, 1].
* */
public class Two_sum {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 2, 4};
        int[] output = twoSum(numbers, 6);
        for (int a : output
                ) {
            System.out.print(a + " ");
        }

        int[] output1 = twoSum1(numbers, 6);
        for (int a : output1
                ) {
            System.out.print(a + " ");
        }

    }

    // 直接两个循环进行计算
    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        int[] output = new int[2];
        int i = 0, j = 0;
        for (i = 0; i < numbers.length; i++) {
            for (j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    output[0] = i + 1;
                    output[1] = j + 1;
                    return output;
                }
            }
        }
        return output;
    }

    //
    private static int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] output = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int remainValue = target - numbers[i];
            if (map.containsKey(remainValue)) {
                output[0] = map.get(remainValue) + 1;
                output[1] = i + 1;
                return output;
            } else {
                map.put(numbers[i], i);
            }
        }
        return output;
    }
}
