package JavaCode.contest.weekly.n0_200.n108;

public class N3 {
    public int minFallingPathSum(int[][] A) {
        for (int i=1;i<A.length;i++)
        {
            A[i][0]=Math.min(A[i-1][0],A[i-1][1])+A[i][0];
            for (int j=1;j<A[i].length-1;j++)
            {
                A[i][j]=Math.min(Math.min(A[i-1][j-1],A[i-1][j]),A[i-1][j+1])+A[i][j];
            }
            if(A[i].length>1) A[i][A[i].length-1]=Math.min(A[i-1][A[i].length-1],A[i-1][A[i].length-2])+A[i][A[i].length-1];
        }
        int res=Integer.MAX_VALUE;
        for (int i:A[A.length-1])
        {
            res=Math.min(i,res);
        }
        return res;
    }
}
/**
 * 931. 下降路径最小和  显示英文描述
 * 用户通过次数 72
 * 用户尝试次数 109
 * 通过次数 74
 * 提交次数 202
 * 题目难度 Medium
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 *
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：12
 * 解释：
 * 可能的下降路径有：
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 和最小的下降路径是 [1,4,7]，所以答案是 12。
 *
 *
 *
 * 提示：
 *
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
