package Multithreading.one_one;

public class P {

    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!lock.equals("")) {
                    lock.wait();
                }
                ValueObject.value = System.currentTimeMillis() + " ";
                System.out.println("P " + ValueObject.value);
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
