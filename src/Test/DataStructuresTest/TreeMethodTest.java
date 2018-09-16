package Test.DataStructuresTest;

import DataStructures.TreeMethod;
import DataStructures.TreeNode;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class TreeMethodTest {

    private TreeMethod method = new TreeMethod();

    @Test
    public void test(){
        System.out.println(method.sumRootToLeafNumbers(init(), 0));
    }

    @Test
    public void testInorderTraversal() {
        ArrayList<Integer> arrayList = method.inorderTraversal(init());
        System.out.print(arrayList.toString());
    }

    @Test
    public void testLevelOrderBottom() {
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(20);
        TreeNode a4 = new TreeNode(15);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2; a1.right = a3;
        a3.left = a4; a3.right = a5;
        ArrayList<ArrayList<Integer>> arrayLists = method.levelOrderBottom(a1);
        System.out.println(arrayLists.toString());
    }

    @Test
    public void testIsBalanced() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        a1.left = a2; a2.left = a4;
        a1.right = a3; a3.right = a5;
//        System.out.println(method.isBalanced(a1));
//        System.out.println(method.isBalanced(init()));
        a5.right = new TreeNode(5);
        System.out.println(method.isBalanced(a1));
    }

    @Test
    public void testCountDepth() {
        System.out.println(TreeMethod.countDepth(init(), 0));
        System.out.println(TreeMethod.countDepth(init().left, 0));
        System.out.println(TreeMethod.countDepth(init().right, 0));
    }

    @Test
    public void testPathSum() {
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(5);
        TreeNode a10 = new TreeNode(1);
        a1.left = a2; a1.right = a3;
        a2.left = a4; a4.left = a7;
        a4.right = a8; a3.left = a5;
        a3.right = a6; a6.left = a9;
        a6.right = a10;
        ArrayList<ArrayList<Integer>> arrayLists = method.pathSum(a1, 22);
        System.out.println(arrayLists.toString());
    }

    @Test
    public void testSequenceTraversal() {
        Integer[] numbers = method.sequenceTraversal(init());
        for (Integer i: numbers) {
            System.out.print(i + " ");
        }
    }

    private static TreeNode init() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        e.right = g;
        return a;
        /*
        *         a(1)
        *     b(2)/   \c(3)
        *    d(4)/e(5)/\f(6)
        *             \g(7)
        * */
    }

}
