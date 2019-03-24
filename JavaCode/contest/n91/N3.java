package JavaCode.contest.n91;

public class N3 {

    public static void main(String[] args) {
        System.out.println(new N3().matrixScore(new int[][]{{1,1},{0,0},{1,0},{1,0},{1,1}}));
    }

    public int matrixScore(int[][] A) {
        int res=0;
        boolean[] book=new boolean[A.length];
        for (int i=0;i<A.length;i++)
        {
            if(A[i][0]==0) book[i]=true;
        }
        res+=A.length*Math.pow(2,A[0].length-1);

        for (int i=1;i<A[0].length;i++)
        {
            int t=0;
            for (int j=0;j<A.length;j++)
            {
                if(book[j])t+=A[j][i]==0?1:0;
                else t+=A[j][i]==0?0:1;
            }
            res+=Math.max(t,A.length-t)*Math.pow(2,A[0].length-i-1);
        }
        return res;

    }
}
/**
 * 861. 翻转矩阵后的得分  显示英文描述
 * 用户通过次数 31
 * 用户尝试次数 38
 * 通过次数 31
 * 提交次数 49
 * 题目难度 Medium
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
