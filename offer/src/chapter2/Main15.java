package chapter2;

/*
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 * */
public class Main15 {
	
	public static void main(String[] args) {
		System.out.println(NumberOf1(8));   // 100 -> 1
		System.out.println(NumberOf1(9));   // 101 -> 2
		System.out.println(NumberOf1(10));  // 110 -> 2
		System.out.println(NumberOf1(11));  // 111 -> 3 
	}

	// 思路：n & (n - 1)，每一次都会消去一个二进制的 1
	private static int NumberOf1(int n) {
		int number = 0;
		// 计算一共有多少次 n & (n - 1) 的操作，就有多少个 1 
		while (n != 0) {
			number++;
			n = n & (n - 1);
		}
		return number;
    }
}

