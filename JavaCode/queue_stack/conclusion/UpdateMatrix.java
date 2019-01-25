package JavaCode.queue_stack.conclusion;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {
    int[][] matrix;
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length==0) return matrix;

        this.matrix=matrix;
        int[][] result=new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                result[i][j]=bfs(i,j);
            }
        }
        return result;

    }

    int bfs(int i,int j)
    {
        int cnt=0;
        Queue<Point> queue=new LinkedList<>();

        int[][] book=new int[matrix.length][matrix[0].length];
        queue.add(new Point(i,j,0));
        book[i][j]=1;
        while (!queue.isEmpty())
        {
            Point p=queue.poll();
            int ii=p.i;
            int jj=p.j;
            int step=p.step;
            if(matrix[ii][jj]==0)return p.step;
            if(ii>0&&book[ii-1][jj]==0)
            {
                queue.add(new Point(ii-1,jj,step+1));
                book[ii-1][jj]=1;
            }
            if(ii<matrix.length-1&&book[ii+1][jj]==0)
            {
                queue.add(new Point(ii+1,jj,step+1));
                book[ii+1][jj]=1;
            }
            if(jj>0&&book[ii][jj-1]==0)
            {
                queue.add(new Point(ii,jj-1,step+1));
                book[ii][jj-1]=1;
            }
            if(jj<matrix[0].length-1&&book[ii][jj+1]==0)
            {
                queue.add(new Point(ii,jj+1,step+1));
                book[ii][jj+1]=1;
            }
        }
        return -1;
    }

    class Point{
        int i,j,step;
        public Point(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/892/
 *  01 矩阵
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
