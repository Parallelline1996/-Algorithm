package chapter2;

/*
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 * 
 * 注意这里，必须从后往前进行，才可以减少移动，
 * 但对于java，可以直接用StringBuilder
 * 
 * 补充java基础：
 *  String字符串常量,StringBuilder、StringBuffer是字符串变量
 *  String：适用于少量的字符串操作的情况
 *  StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
 *  StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
 * 
 * */
public class Main5 {
	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer("We Are Happy");
		System.out.println(replaceSpace(sBuffer));
	}
	
	private static String replaceSpace(StringBuffer str) {
    	StringBuilder sBuilder = new StringBuilder();
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) != ' ') {
    			sBuilder.append(str.charAt(i));
    		} else {
				sBuilder.append("%20");
			}
    	}
		return sBuilder.toString();
    }
}
