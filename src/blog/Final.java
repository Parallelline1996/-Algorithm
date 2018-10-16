package blog;

public class Final {

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ffff");
        System.out.println(sb.toString());

        // 下面这个语句不能实现，因为定义了final，final是指引用的不可变性，即它只能指向初始时指向的那个对象


//        sb = new StringBuilder();
    }
}
