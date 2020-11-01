package JavaCode.contest.n212;

import utils.Parse;
import utils.Show;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/10/25 10:00 上午
 */
public class N4 {
    public static void main(String[] args) {
        //in [[-2,-35,-32,-5,-30,33,-12],[7,2,-43,4,-49,14,17],[4,23,-6,-15,-24,-17,6],[-47,20,39,-26,9,-44,39],[-50,-47,44,43,-22,33,-36],[-13,34,49,24,23,-2,-35],[-40,43,-22,-19,-4,23,-18]]
        //out [[10,3,4,9,5,15,8],[12,4,2,10,1,13,14],[11,13,9,8,6,7,12],[2,10,15,4,9,3,15],[1,2,17,16,7,15,3],[5,14,18,11,10,8,4],[3,15,5,6,8,14,7]]
        Show.show(new N4().matrixRankTransform(Parse.parseToIntTwoArray("[[-2,-35,-32,-5,-30,33,-12],[7,2,-43,4,-49,14,17],[4,23,-6,-15,-24,-17,6],[-47,20,39,-26,9,-44,39],[-50,-47,44,43,-22,33,-36],[-13,34,49,24,23,-2,-35],[-40,43,-22,-19,-4,23,-18]]")));
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int[][] res=new int[matrix.length][matrix[0].length];

        int[][] iMin=new int[matrix.length][2];
        int[][] jMin=new int[matrix[0].length][2];
        for (int i=0;i<matrix.length;i++)
        {
            iMin[i][0]=Integer.MIN_VALUE;
            iMin[i][1]=0;
        }
        for (int i=0;i<matrix[0].length;i++)
        {
            jMin[i][0]=Integer.MIN_VALUE;
            jMin[i][1]=0;
        }

        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2],o2[2]);
            }
        });

        for (int i=0;i<matrix.length;i++)
        {
            for (int j=0;j<matrix[0].length;j++)
            {
                queue.add(new int[]{i,j,matrix[i][j]});
            }
        }

        while (!queue.isEmpty())
        {
            int[] cur=queue.poll();
            int value=-1;
            if(cur[2]==iMin[cur[0]][0])value=Math.max(value,iMin[cur[0]][1]);
            else
            {
                iMin[cur[0]][0]=cur[2];
                value=Math.max(value,iMin[cur[0]][1]+1);
            }

            if(cur[2]==jMin[cur[1]][0])value=Math.max(value,jMin[cur[1]][1]);
            else
            {
                jMin[cur[1]][0]=cur[2];
                value=Math.max(value,jMin[cur[1]][1]+1);
            }
            iMin[cur[0]][1]=value;
            jMin[cur[1]][1]=value;
            res[cur[0]][cur[1]]=value;
        }
        return res;
    }
}
/*
给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][col] 的秩。

每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算：

如果一个元素是它所在行和列的最小值，那么它的 秩 为 1。
如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么：
如果 p < q ，那么 rank(p) < rank(q)
如果 p == q ，那么 rank(p) == rank(q)
如果 p > q ，那么 rank(p) > rank(q)
秩 需要越 小 越好。
题目保证按照上面规则 answer 数组是唯一的。



示例 1：


输入：matrix = [[1,2],[3,4]]
输出：[[1,2],[2,3]]
解释：
matrix[0][0] 的秩为 1 ，因为它是所在行和列的最小整数。
matrix[0][1] 的秩为 2 ，因为 matrix[0][1] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
matrix[1][0] 的秩为 2 ，因为 matrix[1][0] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
matrix[1][1] 的秩为 3 ，因为 matrix[1][1] > matrix[0][1]， matrix[1][1] > matrix[1][0] 且 matrix[0][1] 和 matrix[1][0] 的秩都为 2 。
示例 2：


输入：matrix = [[7,7],[7,7]]
输出：[[1,1],[1,1]]
示例 3：


输入：matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
输出：[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
示例 4：


输入：matrix = [[7,3,6],[1,4,5],[9,8,2]]
输出：[[5,1,4],[1,2,3],[6,3,1]]


提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 500
-109 <= matrix[row][col] <= 109
 */
