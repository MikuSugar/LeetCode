package JavaCode.contest.lc_vscode;

public class N3 {
    public int largestArea(String[] grid) {
        boolean[][] book = new boolean[grid.length][];
        char[][] g = new char[grid.length][];
        for (int i=0;i<grid.length;i++){
            book[i]=new boolean[grid[i].length()];
            g[i]=grid[i].toCharArray();
        }
        for (int i=0;i<grid.length;i++){
            dfs(i,0,g,book);
            dfs(i,grid[i].length()-1,g,book);
        }
        for (int j=0;j<grid[0].length();j++){
            dfs(0,j,g,book);
        }
        for (int j=0;j<grid[grid.length-1].length();j++){
            dfs(grid.length-1,j,g,book);
        }

        for (int i=0;i<g.length;i++){
            for (int j=0;j<g[i].length;j++){
                if(book[i][j]||g[i][j]!='0')continue;
                dfs(i,j,g,book);
            }
        }

        int res=0;
        for (int i=0;i<g.length;i++){
            for (int j=0;j<g[i].length;j++){
                if(book[i][j])continue;
                res=Math.max(res,dfs(i,j,g,book));
            }
        }
        return res;
    }

    private int dfs(int i, int j, char[][] g, boolean[][] book) {
        if(book[i][j])return 0;
        int res=g[i][j]=='0'?0:1;
        book[i][j]=true;
        for (int[] next:NEXTS){
            int ii=i+next[0];
            int jj=j+next[1];
            if(ii<0||jj<0||ii>=g.length||jj>=g[i].length)continue;
            if(g[i][j]=='0')res+=dfs(ii,jj,g,book);
            else if(g[i][j]==g[ii][jj])res+=dfs(ii,jj,g,book);
        }
        return res;
    }



    private final int[][] NEXTS={{-1,0},{0,-1},{0,1},{1,0}};
}
/*
「以扣会友」线下活动所在场地由若干主题空间与走廊组成，场地的地图记作由一维字符串型数组 grid，字符串中仅包含 "0"～"5" 这 6 个字符。地图上每一个字符代表面积为 1 的区域，其中 "0" 表示走廊，其他字符表示主题空间。相同且连续（连续指上、下、左、右四个方向连接）的字符组成同一个主题空间。

假如整个 grid 区域的外侧均为走廊。请问，不与走廊直接相邻的主题空间的最大面积是多少？如果不存在这样的空间请返回 0。

示例 1:

输入：grid = ["110","231","221"]

输出：1

解释：4 个主题空间中，只有 1 个不与走廊相邻，面积为 1。
image.png

示例 2:

输入：grid = ["11111100000","21243101111","21224101221","11111101111"]

输出：3

解释：8 个主题空间中，有 5 个不与走廊相邻，面积分别为 3、1、1、1、2，最大面积为 3。
image.png

提示：

1 <= grid.length <= 500
1 <= grid[i].length <= 500
grid[i][j] 仅可能是 "0"～"5"

 */
