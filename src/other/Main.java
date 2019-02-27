package other;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(4);
//        list.add(3);
//        list.add(2);
//
//        list.replaceAll(t -> t);
//        for (Integer a : list
//             ) {
//            System.out.print(a + " ");
//        }
//        System.out.println();
//
//        list.replaceAll(t -> t + 3);
//        for (Integer a : list
//                ) {
//            System.out.print(a + " ");
//        }
//        System.out.println();

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        arrayList.add(1);
        arrayList1.add(1);

        System.out.println(arrayList == arrayList1);
        System.out.println(arrayList.equals(arrayList1));

    }
}
