package blog;

public interface MyInterface1 {

    default void sayHello() {
        System.out.println("hello, this is MyInterface");
    }
}
