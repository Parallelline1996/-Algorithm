package blog;

public interface MyInterface {

    public static void test() {
        System.out.println("实现静态方法");
    }

    default void testDefault() {
        System.out.println("实现默认方法");
    }

    default void sayHello() {
        System.out.println("hello, this is MyInterface");
    }
}
