package Page2;

/*
* 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
* 说明:
* 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
* 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
*
* 思路：
* 将 num1 中的元素后移，然后再进行取值比较
* */
public class N88_MergeSortedArray {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] nums2 = new int[]{2, 5, 6};
//        merge(nums1, 3, nums2, 3);
//        for (int i : nums1
//             ) {
//            System.out.print(i + " ");
//        }

        int[] nums1 = new int[]{1, 2, 4, 5, 6, 0};
        int[] nums2 = new int[]{3};
        merge(nums1, 5, nums2, 1);
        for (int i : nums1
             ) {
            System.out.print(i + " ");
        }
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 整个数组元素后移
        for (int i = m - 1; i >= 0; i--) {
            nums1[n + i] = nums1[i];
        }
        int n1 = n, n2 = 0;
        for (int i = 0; i < n + m; i++) {
            // 如果 num2 元素用完，说明后面的 nums1 元素已经完成排列了
            if (n2 >= n) {
                break;
            }
            // 如果 num1 元素用完，则将剩下的 nums2 中的元素复制到 nums1 的末尾
            if (n1 >= n + m) {
                for (int j = i; j < n + m; j++, n2++) {
                    nums1[j] = nums2[n2];
                }
                break;
            }
            if (nums1[n1] > nums2[n2]) {
                nums1[i] = nums2[n2];
                n2++;
            } else {
                nums1[i] = nums1[n1];
                n1++;
            }
        }
    }
}
