package JavaCode.random_records.N501_600;

import java.util.HashMap;
import java.util.Map;

public class N593_valid_square {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] arr={getDis(p1,p2),getDis(p1,p3),getDis(p1,p4),getDis(p2,p3),getDis(p2,p4),getDis(p3,p4)};
        for (int i:arr)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return map.size()==2&&!map.containsKey(0);
    }

    private int getDis(int[] a,int[] b) {return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);}
}
/**
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 *
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 *
 * 示例:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 *  
 *
 * 注意:
 *
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
