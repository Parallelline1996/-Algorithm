package Page19;

/*
* 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
* 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
* 你可以返回任何满足上述条件的数组作为答案。
*
*
* */
public class N922_SortArrayByParity2 {

    public static void main(String[] args) {
        int[] a = sortArrayByParityII(new int[]{3, 1, 2, 4});
        for (int a_ : a
                ) {
            System.out.print(a_ + "  ");
        }
        System.out.println();

        a = sortArrayByParityII(new int[]{3, 1, 8, 7, 2, 4});
        for (int a_ : a
                ) {
            System.out.print(a_ + "  ");
        }
        System.out.println();
    }

    private static int[] sortArrayByParityII(int[] A) {
        if (A == null) {
            return null;
        }
        int odd = 1, even = 0;
        while (odd <= A.length - 1 && even <= A.length - 2) {
            if (A[odd] % 2 == 0) {
                int temp = A[odd];
                while (even <= A.length - 2 && A[even] % 2 == 0) {
                    even += 2;
                }
                if (even > A.length - 2) {
                    break;
                }
                A[odd] = A[even];
                A[even] = temp;
                odd += 2;
                even += 2;
            } else {
                odd += 2;
            }
        }
        return A;
    }
}
