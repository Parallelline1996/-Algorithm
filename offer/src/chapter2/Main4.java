package chapter2;

/*
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * */
public class Main4 {

	public static void main(String[] args) {
		
	}
	
	public static boolean Find(int target, int [][] array) {
		
		// 判断输入的合法
		if (array == null) {
			return false;
		}
		
		// 提取行列
        int row = array.length;
		int column = array[0].length;
		
		// 进行寻找
		for(int i = column - 1; i >= 0; i--) {
			for(int j = 0; j < row; j++) {
				if(array[j][i] == target) {
					return true;
				}else if (array[j][i] > target) {
					break;
				}
			}
		}
		return false;
    }
}
