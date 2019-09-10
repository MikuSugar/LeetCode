package JavaCode.random_records.N1_100;

public class N52_n_queens_ii {
    
    public int totalNQueens(int n) {
        int[][] book=new int[3][];
        book[0]=new int[n];
        book[1]=new int[2*n];
        book[2]=new int[2*n];
        return dfs(0,n,book);
    }

    private int dfs(final int idx,final int n, final int[][] book) {
        if(idx==n)return 1;
        int res=0;
        for (int i=0;i<n;i++)
        {
            if(book[0][i]==0&&book[1][idx+i]==0&&book[2][idx-i+n]==0)
            {
                book[0][i]++;
                book[1][idx+i]++;
                book[2][idx-i+n]++;
                res+=dfs(idx+1,n,book);
                book[0][i]--;
                book[1][idx+i]--;
                book[2][idx-i+n]--;
            }
        }
        return res;
    }
}
/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
