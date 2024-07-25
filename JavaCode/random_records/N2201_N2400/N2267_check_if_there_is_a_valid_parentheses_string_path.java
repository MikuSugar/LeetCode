package JavaCode.random_records.N2201_N2400;

import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2024/7/25 下午4:42
 * @description N2267_check_if_there_is_a_valid_parentheses_string_path
 */
public class N2267_check_if_there_is_a_valid_parentheses_string_path {
    public static void main(String[] args) {
        CheckUtil.check(true, new N2267_check_if_there_is_a_valid_parentheses_string_path().hasValidPath(
                Parse.toCharTwoArr("[[\"(\",\"(\",\"(\"],[\")\",\"(\",\")\"],[\"(\",\"(\",\")\"],[\"(\",\"(\",\")\"]]")
        ));
    }

    private char[][] grid;
    private byte[][][] dp;
    private final static byte init = 0;
    private final static byte yes = 1;
    private final static byte no = 2;

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.dp = new byte[grid.length][grid[0].length][grid.length + grid[0].length];
        return dfs(0, 0, 0);
    }

    private boolean dfs(int i, int j, int leftCount) {
        if (i >= grid.length || j >= grid[0].length) return false;
        if (grid[i][j] == '(') {
            leftCount++;
            if (leftCount > grid.length - i + grid[0].length - j - 2) {
                return false;
            }
        } else {
            leftCount--;
            if (leftCount < 0) {
                return false;
            }
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return leftCount == 0;
        }
        if (dp[i][j][leftCount] != init) {
            return dp[i][j][leftCount] == yes;
        }
        final boolean result = dfs(i, j + 1, leftCount) || dfs(i + 1, j, leftCount);
        dp[i][j][leftCount] = result ? yes : no;
        return result;
    }
}
/*
一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。

字符串是 () 。
字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。
字符串可以表示为 (A) ，其中 A 是合法括号序列。
给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径：

路径开始于左上角格子 (0, 0) 。
路径结束于右下角格子 (m - 1, n - 1) 。
路径每次只会向 下 或者向 右 移动。
路径经过的格子组成的括号字符串是 合法 的。
如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。



示例 1：



输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
输出：true
解释：上图展示了两条路径，它们都是合法括号字符串路径。
第一条路径得到的合法字符串是 "()(())" 。
第二条路径得到的合法字符串是 "((()))" 。
注意可能有其他的合法括号字符串路径。
示例 2：



输入：grid = [[")",")"],["(","("]]
输出：false
解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。


提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j] 要么是 '(' ，要么是 ')' 。
 */
