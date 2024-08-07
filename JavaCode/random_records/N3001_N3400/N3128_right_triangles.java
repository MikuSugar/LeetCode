package JavaCode.random_records.N3001_N3400;

import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2024/8/2 下午3:30
 * @description N3128_right_triangles
 */
public class N3128_right_triangles {
    public static void main(String[] args) {
        CheckUtil.check(2L,
                new N3128_right_triangles().numberOfRightTriangles(Parse.toIntTwoArr("[[0,1,0],[0,1,1],[0,1,0]]")));
        CheckUtil.check(2L, new
                N3128_right_triangles().numberOfRightTriangles(Parse.toIntTwoArr("[[1,0,1],[1,0,0],[1,0,0]]")));
    }

    public long numberOfRightTriangles(int[][] grid) {
        //todo
        int[] sumI = new int[grid.length + 1];
        int[] sumJ = new int[grid[0].length + 1];


        long count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

            }
        }
        return count;
    }


}
/*
给你一个二维 boolean 矩阵 grid 。

请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。

注意：

如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素互相之间不需要相邻。


示例 1：

0	1	0
0	1	1
0	1	0
0	1	0
0	1	1
0	1	0
输入：grid = [[0,1,0],[0,1,1],[0,1,0]]

输出：2

解释：

有 2 个直角三角形。

示例 2：

1	0	0	0
0	1	0	1
1	0	0	0
输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]

输出：0

解释：

没有直角三角形。

示例 3：

1	0	1
1	0	0
1	0	0
1	0	1
1	0	0
1	0	0
输入：grid = [[1,0,1],[1,0,0],[1,0,0]]

输出：2

解释：

有两个直角三角形。



提示：

1 <= grid.length <= 1000
1 <= grid[i].length <= 1000
0 <= grid[i][j] <= 1

 */
