package blog;



public class Final {

    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder("hello");
        sb.append(" java");
        System.out.println(sb.toString());
//        sb = new StringBuilder();


        count();
    }

    private static strictfp void count() {
        float f = 0.123f;
        double d = 0.356;
        System.out.println(f + d);
    }
}
