package Test.DynamicPlanningTest;

import DynamicPlanning.Main1;
import org.junit.Test;

public class MainTest1 {

    @Test
    public void testMain1() {
        Main1 main = new Main1();
        System.out.println(main.minCut("aab"));
        System.out.println(main.minCut("aaba"));
        System.out.println(main.minCut("avavbab"));
    }
}
