package chapter2;
/*
 * 斐波那契数列
 * 
 * */
public class Main10 {

	public static void main(String[] args) {
		System.out.println(Fibonacci(1));
		System.out.println(Fibonacci(2));
		System.out.println(Fibonacci(3));
		System.out.println(Fibonacci(4));
		System.out.println(Fibonacci(5));
		System.out.println(Fibonacci(6));
	}
	
	private static int Fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		int number1 = 0, number2 = 1, totalNumber = 0;
		for (int i = 1; i < n; i++) {
			totalNumber = number1 + number2;
			number1 = number2;
			number2 = totalNumber;
		}
		return totalNumber;
	}
}
