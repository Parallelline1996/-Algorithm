package DataStructures;

public class Sort {

    public static void main(String[] args) {
        int[] temp = {1, 5, 6, 9, 3, 7};
        insertSort(temp);
        System.out.println();
        for (int a : temp
             ) {
            System.out.print(a + "  ");
        }
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
}
