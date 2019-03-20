package JavaCode.random_records.N801_900;

public class N861_matrixScore {

    public int matrixScore(int[][] A) {

        boolean[] book=new boolean[A.length];
        int res=0;
        for (int i=0;i<A.length;i++)
        {
            book[i]=A[i][0]==0;
        }
        res+=A.length*Math.pow(2,A[0].length-1);
        for (int j=1;j<A[0].length;j++)
        {
            int cnt=0;
            for (int i=0;i<A.length;i++)
            {
                if(book[i])cnt+=A[i][j]==1?1:0;
                else cnt+=A[i][j]==1?0:1;
            }
            cnt=Math.max(cnt,A.length-cnt);
            res+=cnt*Math.pow(2,A[0].length-1-j);
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/comments/
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 *
 *
 *
 * 示例：
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 */
