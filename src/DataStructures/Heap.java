package DataStructures;

public class Heap {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        buildMaxHeap(array);
        for (Integer a: array
             ) {
            System.out.print(a + "   ");
        }
    }

    private static void buildMaxHeap(int[] array) {
        for (int i = (int)Math.floor((array.length - 1) / 2); i >= 0; i--) {
            sifdown(i, array.length, array);
        }
    }

    /*
    * n ：当前下标
    * total ：最大下标
    * */
    private static void sifdown(int n, int total, int[] array){
        // 判断如果到达叶子节点时，退出
        while (isLeaf(n, total)){
            // 获取两个子节点的大小，取其中最大值
            int leftValue = (2 * n + 1 <= total) ? array[2 * n + 1] : Integer.MIN_VALUE;
            int rightValue = (2 * n + 2 <= total) ? array[2 * n + 2] : Integer.MIN_VALUE;
            int maxValue = leftValue > rightValue ? leftValue : rightValue;
            int maxIndex = leftValue > rightValue ? 2 * n + 1 : 2 * n + 2;
            // 最大值与当前节点的值进行比较，如果当前值大，则退出循环
            if (array[n] > maxValue) {
                return;
            }

            // 当前值小，交换当前值跟最大值，再对最大值进一步进行递
            swap(maxIndex, n, array);
            n = maxIndex;
        }
    }

    // 判断是否为叶子节点，利用完全二叉树的性质
    private static boolean isLeaf(int n, int total) {
        return n <= total && n > Math.floor((total - 1) / 2);
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
