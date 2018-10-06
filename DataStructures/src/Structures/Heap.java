package Structures;

public class Heap {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        buildMaxHeap(array, array.length);
        for (Integer a: array
                ) {
            System.out.print(a + "   ");
        }

        System.out.println();
        heapSort(array);
        for (Integer a: array
                ) {
            System.out.print(a + "   ");
        }

    }

    // 对输入的数组进行建堆的操作
    private static void buildMaxHeap(int[] array, int length) {
        // 遍历所有的内部节点，每一个都进行siftdown操作
        for (int i = (int)Math.floor(length / 2 - 1); i >= 0; i--) {
            siftdown(array, length, i);
        }
    }

    private static void siftdown(int[] array, int length, int index) {
        // 1. 判断是否为叶子节点
        if (isLeaf(array, length, index)) {
            return;
        }

        // 2. 计算左右两个值的大小
        int max = Integer.MIN_VALUE;
        int maxIndex = index;
        // 判断该内部节点是否有两个子树
        if (2 * (index + 1) > length - 1) {
            max = array[2 * index + 1];
            maxIndex = 2 * index + 1;
        } else {
            // 对两个子树的值进行比较
            if (array[2 * index + 1] > array[2 * (index + 1)]) {
                max = array[2 * index + 1];
                maxIndex = 2 * index + 1;
            } else {
                max = array[2 * (index + 1)];
                maxIndex = 2 * (index + 1);
            }
        }

        // 3. 如需交换，交换后继续向下递归
        if (array[index] < array[maxIndex]) {
            array[maxIndex] = array[index];
            array[index] = max;
            siftdown(array, length, maxIndex);
        }
    }

    // 判断是否为叶子节点
    private static boolean isLeaf(int[] array, int length, int index) {
        return index > (int)Math.floor(length / 2 - 1);
    }

    private static void heapSort(int[] array) {
        buildMaxHeap(array, array.length);
        // 将堆顶的最大值每次都交换到最后，对剩余的数字进行新的建堆操作
        for (int i = 0; i < array.length; i++) {
            int temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[0];
            array[0] = temp;
            buildMaxHeap(array, array.length - i - 1);
        }
    }
}
