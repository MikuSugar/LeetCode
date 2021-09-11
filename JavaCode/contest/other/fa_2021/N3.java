package JavaCode.contest.other.fa_2021;

/**
 * @author mikusugar
 */
public class N3 {

    public int flipChess(String[] chessboard) {
        int[][] g = new int[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length(); j++) {
                if (chessboard[i].charAt(j) == 'X') g[i][j] = 1;
                else if (chessboard[i].charAt(j) == '.') g[i][j] = -1;
            }
        }
        int[][] tag = new int[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == 1) {
                    for (int k = 1; k <= 8; k++) {
                        int ii = i + NEXTS[k - 1][0];
                        int jj = j + NEXTS[k - 1][1];
                        if (ii < 0 || jj < 0 || ii >= g.length || jj >= g[0].length || g[ii][jj] != 0) continue;
                        dfs1(ii, jj, k, tag, g);
                    }
                }
            }
        }
        int res = 0;

        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] != -1) continue;
                res = Math.max(res, slove(i, j, g, tag));
            }
        }

        return res;


    }

    private int slove(int i, int j, int[][] g, int[][] tag) {
        int res = 0;
        final boolean[][] visit = new boolean[g.length][g[0].length];
        for (int k = 1; k <= 8; k++) {
            int ii = i + NEXTS[k - 1][0];
            int jj = j + NEXTS[k - 1][1];
            if (ii < 0 || jj < 0 || ii >= g.length || jj >= g[0].length || g[ii][jj] != 0) continue;
            res += dfs2(ii, jj, k, tag, g, visit);
        }
        return res;
    }

    private int dfs2(int i, int j, int kk, int[][] tag, int[][] g, boolean[][] visit) {
        if ((tag[i][j] & (1 << kk)) == 0 || visit[i][j]) return 0;
        visit[i][j] = true;
        int res = 1;
        for (int k = 1; k <= 8; k++) {
            int ii = i + NEXTS[k - 1][0];
            int jj = j + NEXTS[k - 1][1];
            if (ii < 0 || jj < 0 || ii >= g.length || jj >= g[0].length || g[ii][jj] != 0) continue;
            res += dfs2(ii, jj, k, tag, g, visit);
        }
        return res;
    }

    private void dfs1(int i, int j, int k, int[][] tag, int[][] g) {
        tag[i][j] |= 1 << BOOK[k - 1];
        int ii = i + NEXTS[k - 1][0];
        int jj = j + NEXTS[k - 1][1];
        if (ii < 0 || jj < 0 || ii >= g.length || jj >= g[0].length || g[ii][jj] != 0) return;
        dfs1(ii, jj, k, tag, g);
    }


    //                                      1        2         3       4       5        6       7      8
    private final static int[][] NEXTS = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    private final static int[] BOOK = {5, 6, 7, 8, 1, 2, 3, 4};
}
/*
在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，空余位置记作 "."。当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。

1.gif2.gif3.gif

「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 chessboard。若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。

注意：

若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
示例 1：

输入：chessboard = ["....X.","....X.","XOOO..","......","......"]

输出：3

解释：
可以选择下在 [2,4] 处，能够翻转白方三枚棋子。

示例 2：

输入：chessboard = [".X.",".O.","XO."]

输出：2

解释：
可以选择下在 [2,2] 处，能够翻转白方两枚棋子。
2126c1d21b1b9a9924c639d449cc6e65.gif

示例 3：

输入：chessboard = [".......",".......",".......","X......",".O.....","..O....","....OOX"]

输出：4

解释：
可以选择下在 [6,3] 处，能够翻转白方四枚棋子。
803f2f04098b6174397d6c696f54d709.gif

提示：

1 <= chessboard.length, chessboard[i].length <= 8
chessboard[i] 仅包含 "."、"O" 和 "X"

 */
