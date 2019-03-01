package JavaCode.random_records;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N947_removeStones
{
    private Map<Integer,Set<Integer>> rows;
    private Map<Integer,Set<Integer>> cols;
    private Set<String> books;

    public int removeStones(int[][] stones)
    {
        rows=new HashMap<>();
        cols=new HashMap<>();
        books=new HashSet<>();

        for (int[] stone:stones)
        {
            int row=stone[0];
            int col=stone[1];
            rows.putIfAbsent(row,new HashSet<>());
            cols.putIfAbsent(col,new HashSet<>());
            rows.get(row).add(col);
            cols.get(col).add(row);
        }

        int count=0;
        for (int[] stone:stones)
        {
            int row=stone[0];
            int col=stone[1];
            String key=row+","+col;
            if(books.contains(key))continue;
            count++;
            dfs(row,col);
        }
        return stones.length-count;

    }

    private void dfs(int row,int col)
    {
        String book=row+","+col;
        books.add(book);
        for(int t_col:rows.get(row))
        {
            String temp=row+","+t_col;
            if(books.contains(temp))continue;
            dfs(row,t_col);
        }
        for (int t_row:cols.get(col))
        {
            String temp=t_row+","+col;
            if(books.contains(temp))continue;
            dfs(t_row,col);
        }
    }

}
/**
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 *
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 *
 * 我们最多能执行多少次 move 操作？
 *
 * 示例 1：
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 示例 2：
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 示例 3：
 * 输入：stones = [[0,0]]
 * 输出：0
 *
 * 提示：
 * 1 <= stones.length <= 1000
 * 0 <= stones[i][j] < 10000
 */
