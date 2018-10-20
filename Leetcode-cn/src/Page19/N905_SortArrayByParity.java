package Page19;

/*
* 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
*
* 思路：
* 用两个下标，各自记录左边第一个非偶数，和右边第一个非奇数，进行交换并向中间靠拢
* */
public class N905_SortArrayByParity {

    public static void main(String[] args) {
        int[] a = sortArrayByParity(new int[]{3, 1, 2, 4});
        for (int a_ : a
             ) {
            System.out.print(a_ + "  ");
        }
        System.out.println();

        a = sortArrayByParity(new int[]{3, 1, 8, 7, 2, 4});
        for (int a_ : a
                ) {
            System.out.print(a_ + "  ");
        }
        System.out.println();
    }

    private static int[] sortArrayByParity(int[] A) {
        if (A == null) {
            return null;
        }
        int left = 0, right = A.length - 1;
        while (left <= right) {
            if (A[left] % 2 != 0) {
                int temp = A[left];
                while (left <= right && A[right] % 2 != 0) {
                    right--;
                }
                if (right <= left) {
                    break;
                }
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            } else {
                left++;
            }
        }
        return A;
    }
}
