package JavaCode.random_records.N801_900;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/11
 */
public class N864_shortest_path_to_get_all_keys {
    public int shortestPathAllKeys(String[] grid) {
        char[][] graphs=getGraphs(grid);
        int[] start=new int[2];
        final int end=init(graphs,start);

        Queue<int[]> queue=new LinkedList<>();
        Set<String> set=new HashSet<>();
        set.add(getKey(start[0],start[1],0));
        queue.add(new int[]{start[0],start[1],0});
        int res=0;

        while (!queue.isEmpty())
        {
            int size=queue.size();
            while (size-->0)
            {
                int[] cur=queue.poll();
                for (int[] next:NEXTS)
                {
                    int i=cur[0]+next[0];
                    int j=cur[1]+next[1];
                    if(i<0||j<0||i>=graphs.length||j>=graphs[0].length||graphs[i][j]=='#')continue;
                    int status=cur[2];
                    if(Character.isLowerCase(graphs[i][j]))
                    {
                        status|=(1<<getKeyIdx(i,j,graphs));
                        if(status==end)return res+1;
                    }
                    else if(Character.isUpperCase(graphs[i][j]))
                    {
                        int idx=getKeyIdx(i,j,graphs);
                        int temp=status|(1<<idx);
                        if(temp!=status)continue;
                    }
                    String key=getKey(i, j, status);
                    if(set.contains(key))continue;
                    set.add(key);
                    queue.add(new int[]{i,j,status});
                }
            }
            res++;
        }
        return -1;

    }

    private int init(char[][] graphs, int[] start) {
        int end=0;
        for (int i=0;i<graphs.length;i++)
        {
            for (int j=0;j<graphs[0].length;j++)
            {
                if(Character.isLowerCase(graphs[i][j]))
                {
                    end|=(1<<getKeyIdx(i,j,graphs));
                }
                else if(graphs[i][j]=='@')
                {
                    start[0]=i;
                    start[1]=j;
                }
            }
        }
        return end;
    }

    private String getKey(int i,int j,int status) {
        return i+","+j+","+status;
    }

    private final static int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};

    private int getKeyIdx(int i,int j,char[][] graphs) {
        return Character.toLowerCase(graphs[i][j])-'a';
    }
    private char[][] getGraphs(String[] grid) {
        char[][] res=new char[grid.length][];
        for (int i=0;i<res.length;i++)
        {
            res[i]=grid[i].toCharArray();
        }
        return res;
    }
}
/*
给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A", "B", ...）代表锁。

我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。

假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。

返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
示例 1：

输入：["@.a.#","###.#","b.A.B"]
输出：8
示例 2：

输入：["@..aA","..B#.","....b"]
输出：6

提示：

1 <= grid.length <= 30
1 <= grid[0].length <= 30
grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
钥匙的数目范围是 [1, 6]，每个钥匙都对应一个不同的字母，正好打开一个对应的锁。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-path-to-get-all-keys
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
