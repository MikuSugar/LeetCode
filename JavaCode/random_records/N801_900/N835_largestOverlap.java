package JavaCode.random_records.N801_900;

import java.util.*;

public class N835_largestOverlap {
    
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> la=new ArrayList<>();
        List<int[]> lb=new ArrayList<>();
        for (int i=0;i<A.length;i++)
        {
            for (int j=0;j<A[0].length;j++)
            {
                if(A[i][j]==1)la.add(new int[]{i,j});
                if(B[i][j]==1)lb.add(new int[]{i,j});
            }
        }

        int res=0;
        Map<String,Integer> map=new HashMap<>();
        for (int[] a:la)
        {
            for (int[] b:lb)
            {
                String s=help(a,b);
                int cnt=map.getOrDefault(s,0)+1;
                res=Math.max(res,cnt);
                map.put(s,cnt);
            }
        }
        return res;
    }
    private String help(int[] a, int[] b) {
        return (a[0]-b[0])+","+(a[1]-b[1]);
    }


}
/**
 * https://leetcode-cn.com/problems/image-overlap/
 * 给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。
 *
 * 我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。
 *
 * （请注意，转换不包括向任何方向旋转。）
 *
 * 最大可能的重叠是什么？
 *
 * 示例 1:
 *
 * 输入：A = [[1,1,0],
 *           [0,1,0],
 *           [0,1,0]]
 *      B = [[0,0,0],
 *           [0,1,1],
 *           [0,0,1]]
 * 输出：3
 * 解释: 将 A 向右移动一个单位，然后向下移动一个单位。
 * 注意:
 *
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 */

