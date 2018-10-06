package niuke;

import java.util.HashMap;

/*
* Given n points on a 2D plane,
* find the maximum number of points that lie on the same straight line.
* 给 n 个点，求最多几个点共线
*
* 思路：
* 依次使所有的点成为起点进行斜率计算，记录重复的点的数目，将其他斜率用map保存，每遍历完一个点后，
* 比较 每种斜率对应的数目加上重复点数 与 最大值
 * */
public class Max_points_on_a_line {

    public static void main(String[] args) {
        Point[] points = {new Point(4, 1)};
        System.out.println(maxPoints(points));

        points = new Point[]{new Point(4, 1), new Point(4, 1)};
        System.out.println(maxPoints(points));

        points = new Point[]{new Point(1, 3), new Point(2, 3), new Point(4, 3), new Point(4, 1)};
        System.out.println(maxPoints(points));

        points = new Point[]{new Point(1, 1), new Point(0, 0), new Point(1, 1)};
        System.out.println(maxPoints(points));

        points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(2, 3)};
        System.out.println(maxPoints(points));

        points = new Point[]{new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2)};
        System.out.println(maxPoints(points));
    }

    private static int maxPoints(Point[] points) {
        // 对输入进行处理
        if (points == null) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            // dup 用于记录与当前点重复的点数
            int dup = 0;
            // map 用于记录各种斜率的数目
            HashMap<Double, Integer> map = new HashMap<>();
            // 斜率，注意，这里要使用 double 类型，不能使用 int 类型
            Double slope = null;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                double x = points[i].x - points[j].x;
                double y = points[i].y - points[j].y;
                // 重复的点
                if (x == 0 && y ==0) {
                    dup++;
                } else {
                    // 没有斜率的点
                    if (x == 0) {
                        slope = null;
                    } else {
                        // 普通斜率
                        slope = y / x;
                    }
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 1);
                    }
                }
            }
            // 对特殊情况，整个集合都是同一元素的情况进行处理
            if (map.keySet().isEmpty()) {
                if (max < dup) {
                    max = dup + 1;
                    continue;
                }
            }
            // 比较每种斜率对应的数目 + 重复点数 与 max 值的比较
            for (Object o : map.keySet()
                 ) {
                if (max < map.get(o) + dup + 1) {
                    max = map.get(o) + dup + 1;
                }
            }
        }
        return max;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}