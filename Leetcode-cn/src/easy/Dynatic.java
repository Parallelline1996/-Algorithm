package easy;

public class Dynatic {

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    /*
    * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    * */
    private static int climbStairs(int n) {
        if (n <= 2) {
             return n;
        }
        int num1 = 1;
        int num2 = 2;
        for (int i = 0; i < n - 2; i++) {
            num2 = num2 + num1;
            num1 = num2 - num1;
        }
        return num2;
    }
}
