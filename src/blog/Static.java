package blog;

public class Static {

    int b = 0;

    public static void main(String[] args) {
        Static s = new Static();
        s.sayHello();
    }

    public void sayHello() {
        System.out.println("Hello, this is Static");
        Static s = new a();
        System.out.println(s.b);
    }
}

class a extends Static {

    int b = 50;

    public void sayHello() {
        System.out.println("Hello, this is A");
    }
}
