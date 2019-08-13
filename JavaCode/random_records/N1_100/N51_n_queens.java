package JavaCode.random_records.N1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N51_n_queens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] map=new char[n][n];
        int[][] book=new int[3][];
        book[0]=new int[n];
        book[1]=new int[2*n];
        book[2]=new int[2*n];
        for (int i=0;i<map.length;i++)
        {
            Arrays.fill(map[i],'.');
        }
        dfs(0,n,map,book,res);
        return res;
    }

    private void dfs(int start,int idx, char[][] map,int[][] book,List<List<String>> res) {
        if(idx==0)
        {
            List<String> list=new ArrayList<>(map.length);
            for (char[] m:map)
            {
                list.add(new String(m));
            }
            res.add(list);
            return;
        }
        int n=map.length;
        if(n-start<idx)return;
        for (int i=start;i<n;i++)
        {
            for (int j=0;j<n;j++)
            {
                if(map[i][j]=='.'&&book[0][j]==0&&book[1][i+j]==0&&book[2][i-j+n]==0)
                {
                    map[i][j]='Q';
                    book[0][j]++;
                    book[1][i+j]++;
                    book[2][i-j+n]++;
                    dfs(i+1, idx-1, map, book, res);
                    map[i][j]='.';
                    book[0][j]--;
                    book[1][i+j]--;
                    book[2][i-j+n]--;
                }
            }
        }
    }


}
/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

