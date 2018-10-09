package chapter3;

/*
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方	
 * */
public class Main16 {

	public static void main(String[] args) {
		System.out.println(Power(1.4, 10) + "   " + checkPower(1.4, 10));
		System.out.println(Power(1.5, 10) + "   " + checkPower(1.5, 10));
		System.out.println(Power(1.6, 10) + "   " + checkPower(1.6, 10));
		System.out.println(Power(1.7, 10) + "   " + checkPower(1.7, 10));
		System.out.println(Power(1.8, 10) + "   " + checkPower(1.8, 10));
		System.out.println(Power(1.4, -10) + "   " + checkPower(1.4, -10));
		System.out.println(Power(1.5, -10) + "   " + checkPower(1.5, -10));
		System.out.println(Power(1.6, -10) + "   " + checkPower(1.6, -10));
		System.out.println(Power(1.7, -10) + "   " + checkPower(1.7, -10));
		System.out.println(Power(1.8, -10) + "   " + checkPower(1.8, -10));
		System.out.println(Power(4, -2) + "   " + checkPower(4, -2));
		//System.out.println(Power(4, -1) + "   " + checkPower(4, -1));
	}
	
	// 分成正指数跟负指数进行讨论
	private static double Power(double base, int exponent) {
		if (exponent >= 0) {
			return PowerPositive(base, exponent);
		}
		exponent = -exponent;
		return PowerNagetive(base, exponent);
	}
	
	// 当指数为正时，不断分为二分之一进行计算
	private static double PowerPositive(double base, int exponent) {
		if (exponent == 0) {
			return 1; 
		}
		if (exponent == 1) {
			return base;
		}
		double result = PowerPositive(base, exponent >> 1);
		result *= result;
		if (exponent % 2 != 0) {
			result *= base;
		}
		return result;
	}
	
	// 当指数为负时，也是分为二分之一进行计算，但指数1时情况不同
	private static double PowerNagetive(double base, int exponent) {
		if (exponent == 0) {
			return 1; 
		}
		if (exponent == 1) {
			return 1 / base;
		}
		double result = PowerNagetive(base, exponent >> 1);
		result *= result;
		if (exponent % 2 != 0) {
			result /= base;
		}
		return result;
	}
	
	private static double checkPower(double a, int exponent) {
		return Math.pow(a, exponent);
	}
}
