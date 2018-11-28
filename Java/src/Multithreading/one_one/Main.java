package Multithreading.one_one;

public class Main {

    public static void main(String[] args) {
        String lock = "";
        C c = new C(lock);
        P p = new P(lock);
        ThreadC c1 = new ThreadC(c);
        ThreadP p1 = new ThreadP(p);
        c1.start();
        p1.start();
    }
}
