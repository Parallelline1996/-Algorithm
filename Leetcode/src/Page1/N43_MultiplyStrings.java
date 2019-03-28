package Page1;

/*
* Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
* */
public class N43_MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(new N43_MultiplyStrings().multiply("123", "456"));
    }

    /*
    * 思路：
    * 将两个字符串分别拆成单个的 char互相相乘，并把结果进行记录
    * */
    public String multiply(String num1, String num2) {
        // 对输入进行判断
        if (num1 == null && num2 == null) return "0";
        if (num1 == null) return num2;
        if (num2 == null) return num1;

        // 由于 n位数乘 m位数，最大的长度为 m+n位数，因此用以下的数组来记录结果
        int[] pos = new int[num1.length() + num2.length()];

        // 从大到小遍历，实际上是从数字的低位向高位遍历的过程
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >=0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = temp + pos[i + j + 1];

                // 这里 pos[i+j]是高位，即使 sum/10与原有的 pos[i+j]相加大于 10
                // 也可以在下一位的乘法中，在第 i+j+1位的计算中被解决
                pos[i + j] += sum / 10;
                pos[i + j + 1] = sum % 10;
            }
        }

        // 清除高位无用的 “0”
        StringBuilder sb = new StringBuilder();
        for (int p : pos
             ) {
            // 将高位无需使用的 0去除
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0? "0": sb.toString();
    }
}
