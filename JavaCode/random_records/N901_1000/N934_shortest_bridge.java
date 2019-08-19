package JavaCode.random_records.N901_1000;

import java.util.*;

public class N934_shortest_bridge {

    private final static int[][] nexts={{-1,0},{0,-1},{0,1},{1,0}};
    public int shortestBridge(int[][] A) {
        Set<Integer> starts=new HashSet<>();

        boolean flag=false;
        for (int i=0;i<A.length;i++)
        {
            for (int j=0;j<A[0].length;j++)
            {
                if(A[i][j]==1)
                {
                    getStarts(starts,i,j,A);
                    flag=true;
                    break;
                }
            }
            if(flag)break;
        }

        int res=0;
        Queue<Integer> queue=new LinkedList<>();
        queue.addAll(starts);
        boolean[][] book=new boolean[A.length][A[0].length];
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size-->0)
            {
                Integer cur = queue.poll();
                int i=getI(cur);
                int j=getJ(cur);
                book[i][j]=true;
                if(A[i][j]==1&&!starts.contains(cur))
                {
                    return res-1;
                }
                for (int[] next:nexts)
                {
                    int ii=i+next[0];
                    int jj=j+next[1];
                    if(ii<0||jj<0||ii>=A.length||jj>=A[0].length||book[ii][jj]||A[ii][jj]==2)continue;
                    book[ii][jj]=true;
                    queue.add(getKey(ii,jj));
                }
            }
            res++;
        }
        return -1;
    }

    private void getStarts(Set<Integer> starts, int i1, int j1,int[][] a) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(getKey(i1,j1));
        boolean[][] book=new boolean[a.length][a[0].length];
        book[i1][j1]=true;
        a[i1][j1]=2;
        while (!queue.isEmpty())
        {
            int cur = queue.poll();
            int i=getI(cur);
            int j=getJ(cur);
            for (int[] next:nexts)
            {
                int ii=i+next[0];
                int jj=j+next[1];
                if(ii<0||jj<0||ii>=a.length||jj>=a[0].length||book[ii][jj])continue;
                if(a[ii][jj]==0)starts.add(cur);
                else if(a[ii][jj]==1)
                {
                    book[ii][jj]=true;
                    a[ii][jj]=2;
                    queue.add(getKey(ii,jj));
                }
            }
        }
    }

    private int getI(int i) { return i/1000; }
    private int getJ(int i) { return i%1000; }
    private int getKey(int i,int j) {return i*1000+j;}


}
/**
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 *
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 *
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 *
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
