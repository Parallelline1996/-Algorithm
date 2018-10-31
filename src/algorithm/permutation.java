package algorithm;


import java.util.Arrays;

/*
* 全排序
* */
public class permutation {

    public static void main(String[] args) {
        permute(new int[]{1, 2, 3}, 0);
        permute(new int[]{1, 2, 3, 5}, 0);

    }

    private static void permute(int[] array, int start) {
        if (start == array.length - 1) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = start; i < array.length; i++) {
                swap(array, start, i);
                permute(array, start + 1);
                swap(array, start, i);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
