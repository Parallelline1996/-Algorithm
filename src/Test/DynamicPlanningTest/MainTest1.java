package Test.DynamicPlanningTest;

import DynamicPlanning.Main1;
import DynamicPlanning.Main2;
import org.junit.Test;

public class MainTest1 {

    @Test
    public void testMain1() {
        Main1 main = new Main1();
        System.out.println(main.minCut("aab"));
        System.out.println(main.minCut("aaba"));
        System.out.println(main.minCut("avavbab"));
    }

    @Test
    public void testMain2() {
        Main2 main = new Main2();
        System.out.println(main.partition("aab").toString());
        System.out.println(main.partition("abaa").toString());
        System.out.println(main.partition("a").toString());
        System.out.println(main.partition("ab").toString());
        System.out.println(main.partition("bb").toString());
        System.out.println(main.partition("aaa").toString());
        System.out.println(main.partition("").toString());
    }
}
