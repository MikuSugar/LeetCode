package JavaCode.contest.weekly.n201_300.n244;

import utils.Parse;


public class N1 {
    public static void main(String[] args) {
        System.out.println(new N1().findRotation(
                Parse.toIntTwoArr("[[0,1],[1,0]]"),
                Parse.toIntTwoArr("[[1,0],[0,1]]")
        ));
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int i=4;
        while (i-->0){
            mat=help(mat);
            if(check(mat,target))return true;
        }
        return false;
    }

    private boolean check(int[][] mat, int[][] target) {
       final int n=mat.length;
       for (int i=0;i<n;i++){
           for (int j=0;j<n;j++){
               if(mat[i][j]!=target[i][j])return false;
           }
       }
       return true;
    }

    private int[][] help(int[][] mat) {
        final int n= mat.length;
        int[][] res=new int[mat.length][mat.length];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                res[i][j]=mat[j][n-i-1];
            }
        }
        return res;
    }

}
/*
给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。



示例 1：


输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
输出：true
解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
示例 2：


输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
输出：false
解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
示例 3：


输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
输出：true
解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。


提示：

n == mat.length == target.length
n == mat[i].length == target[i].length
1 <= n <= 10
mat[i][j] 和 target[i][j] 不是 0 就是 1
 */
