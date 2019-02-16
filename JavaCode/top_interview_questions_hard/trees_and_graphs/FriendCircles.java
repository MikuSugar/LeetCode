package JavaCode.top_interview_questions_hard.trees_and_graphs;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        if(M.length==0) return 0;
        int cnt=0;
        int booki[]=new int[M.length];
        int bookj[]=new int[M[0].length];
        for (int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[i].length;j++)
            {
                if(M[i][j]==1&&booki[i]+bookj[j]==0)
                {
                    dfs(i,j,booki,bookj,M);
                    cnt++;
                }
            }
        }
        return cnt;
    }


    private void dfs(int i,int j,int[] booki,int[] bookj,int[][] map)
    {
        if(booki[i]+bookj[j]==2)return;
        if(bookj[j]==0) {
            bookj[j]=1;
            for (int k = 0; k < map.length; k++) {
                if (map[k][j] == 1) {
                    dfs(k, j, booki, bookj, map);
                }
            }
        }

        if(booki[i]==0) {
            booki[i]=1;
            for (int k = 0; k < map[0].length; k++) {
                if (map[i][k] == 1) {
                    dfs(i, k, booki, bookj, map);
                }
            }
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/141/
 * Friend Circles
 * 班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
 *
 * 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你必须输出所有学生中的已知的朋友圈总数。
 *
 * 示例 1:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,0],
 *  [0,0,1]]
 * 输出: 2
 * 说明：已知学生0和学生1互为朋友，他们在一个朋友圈。
 * 第2个学生自己在一个朋友圈。所以返回2。
 * 示例 2:
 *
 * 输入:
 * [[1,1,0],
 *  [1,1,1],
 *  [0,1,1]]
 * 输出: 1
 * 说明：已知学生0和学生1互为朋友，学生1和学生2互为朋友，所以学生0和学生2也是朋友，所以他们三个在一个朋友圈，返回1。
 * 注意：
 *
 * N 在[1,200]的范围内。
 * 对于所有学生，有M[i][i] = 1。
 * 如果有M[i][j] = 1，则有M[j][i] = 1。
 */
