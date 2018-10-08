package chapter2;

import java.util.Hashtable;

/*
 * 数组中的重复数字：
 * n个数，范围0~n-1，找出数组中任意一个重复的数
 * */
public class Main3 {
	
	public static void main(String[] args) {
		int[] numbers = {2, 1, 3, 0, 4};//{5, 4, 4, 3, 0, 0};
		int length = 5;
		int[] duplication = {-1};
		//duplicate(numbers, length, duplication);
		//System.out.println(duplication[0]);
		
		duplicate_(numbers, length, duplication);
		System.out.println(duplication[0]);
	}
	
	// duplication[0] 用于记录重复的数字
	public static boolean duplicate(int numbers[],int length,int [] duplication) {
		
		// 对输入情况的判断，判断数组是否为空
		if (numbers == null) {
			return false;
		}
		
		// 判断数组内容是否符合要求
		for (int i : numbers) {
			if (i >= length || i < 0) {
				return false;
			}
		}
		
		// 采用哈希表的方式进行
		Hashtable<Integer, Integer> hashtable = new Hashtable<>();
		for (int i = 0; i < numbers.length; i++) {
			if (hashtable.containsValue(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				hashtable.put(i, numbers[i]);
			}
		}
	    return false;
    }
	
	// 下面采用不需要空间开销的解法：
	public static boolean duplicate_(int numbers[],int length,int [] duplication) {
		
		// 对输入情况的判断，判断数组是否为空
		if (numbers == null) {
			return false;
		}
		
		// 判断数组内容是否符合要求
		for (int i : numbers) {
			if (i >= length || i < 0) {
				return false;
			}
		}
		
		for (int i = 0; i < numbers.length; i++) {
			// 注意要有这一个判断
			while (numbers[i] != i) {			
				// 将数组每一个元素的值与其下标进行比较，如果不同，与元素值对应的下标进行交换
				// 元素与下标相对应。当重复元素存在时，会碰到，即停止
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				} else {
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			}
		}
	    return false;
    }
}
