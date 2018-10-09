package Structures;

public class Sort {

    public static void main(String[] args) {
        int[] temp = {1, 5, 6, 9, 3, 7};
//        insertSort(temp);
//        for (int a : temp
//             ) {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//
//        temp = new int[]{1, 5, 6, 9, 3, 7};
//        bubbleSort(temp);
//        for (int a : temp
//             ) {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//
//        temp = new int[]{1, 5, 6, 9, 3, 7};
//        selectSort(temp);
//        for (int a : temp
//                ) {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//
//        temp = new int[]{1, 5, 6, 9, 8, 3, 2, 33};
//        shellSort(temp);
//        for (int a : temp
//                ) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        temp = new int[]{50, 55, 2, 9, 8, 5, 58, 31,
                        77, 100, 96, 1, 4, 3, 22, 6};
        shellSort(temp);
        for (int a : temp
                ) {
            System.out.print(a + " ");
        }
        System.out.println();

    }

    /*
    * 插入排序
    * */
    private static void insertSort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            for (int j = i; j > 0; j--) {
                if (number > array[j - 1]) {
                    break;
                }
                int temp = array[j - 1];
                array[j - 1] = number;
                array[j] = temp;
            }
        }
    }

    /*
    * 冒泡排序
    * */
    private static void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // 可以在每一次冒泡排序结束之后，判断排序结果是否有序来加快效率
        }
    }

    /*
    * 选择排序 小 -> 大
    * */
    private static void selectSort(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int temp = i;
            // 选择出剩余元素中，符合条件的
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[temp]) {
                    temp = j;
                }
            }
            // 将选择出来的元素放置到对应的位置
            if (temp != i) {
                int temp_ = array[i];
                array[i] = array[temp];
                array[temp] = temp_;
            }
        }
    }

    /*
    * 希尔排序，输入数组为2的倍数
    * */
    private static void shellSort(int[] array) {
//        if (array == null) {
//            return;
//        }
//        int index = array.length / 2;
//        while (index > 0) {
//            for (int i = 0; i < index; i++) {
//                for (int j = i, k = 0; k < array.length / index - 1; j += index, k++) {
//                    if (array[j] > array[j + index]) {
//                        int temp = array[j];
//                        array[j] = array[j + index];
//                        array[j + index] = temp;
//                    }
//                }
//            }
//            index /= 2;
//        }
    }


}
