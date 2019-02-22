package JavaCode.top_interview_questions_hard.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPoints {
    public int maxPoints(Point[] points) {

        int ans=0;
        for (int i=0;i<points.length;i++)
        {
            int cnt=1;//重合点
            int x_cnt=0;//斜率无穷大
            Map<String,Integer> map=new HashMap<>();
            Point a=points[i];
            for (int j=0;j<points.length;j++)
            {
                if(i==j)continue;
                Point b=points[j];
                if(a.x==b.x)
                {
                    if(a.y==b.y)cnt++;
                    else x_cnt++;
                }
                else
                {
                    String k=getK(a,b);
                    if(map.containsKey(k))
                    {
                        map.put(k,map.get(k)+1);
                    }
                    else
                    {
                        map.put(k,1);
                    }
                }
            }
            int max=x_cnt;
            for (int t:map.values())
            {
                max=Math.max(max,t);
            }
            ans=Math.max(ans,max+cnt);
        }
        return ans;

    }

    //用最简分数表示斜率避免精度问题
    private String getK(Point a,Point b)
    {
        int x=a.x-b.x;
        int y=a.y-b.y;
        String sign=(long)x*y>=0?"+":"-";
        int gcd=gcd(Math.abs(x),Math.abs(y));
        return sign+(Math.abs(x)/gcd)+"/"+(Math.abs(y)/gcd);
    }
    private int  gcd(int a,int b)
    {
        if(a==0)return b;
        return gcd(b,a%b);
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/62/math/165/
 * 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
