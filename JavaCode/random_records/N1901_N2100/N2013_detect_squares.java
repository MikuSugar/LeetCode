package JavaCode.random_records.N1901_N2100;

import java.util.*;

/**
 * @author mikusugar
 */
public class N2013_detect_squares {
    //["DetectSquares","add","add","add","count","count","add","count"]
    //[[],[[3,10]],[[11,2]],[[3,2]],[[11,10]],[[14,8]],[[11,2]],[[11,10]]]
    public static void main(String[] args) {
        final DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
        System.out.println(detectSquares.count(new int[]{14, 8}));
        detectSquares.add(new int[]{11, 2});
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }
}

class DetectSquares {

    static class Point {
        int x;
        int y;

        Point(int[] point) {
            x = point[0];
            y = point[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private final Map<Point, Integer> map;
    private final Map<Integer, Set<Point>> mapX;
    private final Map<Integer, Set<Point>> mapY;

    public DetectSquares() {
        this.map = new HashMap<>();
        this.mapX = new HashMap<>();
        this.mapY = new HashMap<>();
    }

    public void add(int[] point) {
        final Point p = new Point(point);
        map.put(p, map.getOrDefault(p, 0) + 1);

        if (!mapX.containsKey(point[0])) mapX.put(point[0], new HashSet<>());
        mapX.get(point[0]).add(p);

        if (!mapY.containsKey(point[1])) mapY.put(point[1], new HashSet<>());
        mapY.get(point[1]).add(p);
    }

    public int count(int[] point) {

        if (!mapX.containsKey(point[0]) || !mapY.containsKey(point[1])) return 0;

        List<Point> listX = new ArrayList<>(mapX.get(point[0]));
        List<Point> listY = new ArrayList<>(mapY.get(point[1]));


        int res = 0;

        for (Point x : listX) {
            for (Point y : listY) {
                if (!check1(point, x, y)) continue;
                Point other = new Point(new int[]{y.x, x.y});
                res += slove(x, y, other);
            }
        }
        return res;

    }

    private int slove(Point x, Point y, Point other) {
        if (map.containsKey(other)) {
            return map.get(x) * map.get(y) * map.get(other);
        }
        return 0;
    }

    private boolean check1(int[] cur, Point i, Point j) {
        if (i.x == j.x || i.y == j.y) return false;
        int ii = getDis(cur, i);
        int jj = getDis(cur, j);
        return ii == jj;
    }

    private int getDis(int[] a, Point b) {
        return (a[0] - b.x) * (a[0] - b.x) + (a[1] - b.y) * (a[1] - b.y);
    }

}

/*
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 * 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：

添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。

实现 DetectSquares 类：

DetectSquares() 使用空数据结构初始化对象
void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。
 

示例：


输入：
["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
[[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
输出：
[null, null, null, null, 1, 0, null, 2]

解释：
DetectSquares detectSquares = new DetectSquares();
detectSquares.add([3, 10]);
detectSquares.add([11, 2]);
detectSquares.add([3, 2]);
detectSquares.count([11, 10]); // 返回 1 。你可以选择：
                               //   - 第一个，第二个，和第三个点
detectSquares.count([14, 8]);  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
detectSquares.add([11, 2]);    // 允许添加重复的点。
detectSquares.count([11, 10]); // 返回 2 。你可以选择：
                               //   - 第一个，第二个，和第三个点
                               //   - 第一个，第三个，和第四个点
 

提示：

point.length == 2
0 <= x, y <= 1000
调用 add 和 count 的 总次数 最多为 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/detect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

