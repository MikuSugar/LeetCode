package JavaCode.contest.biweekly_n8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N4 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        if (maxOnes==0)return 0;
        int[][] book=new int[sideLength][sideLength];
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<width;i++)
        {
            for (int j=0;j<height;j++)
            {
                book[i%sideLength][j%sideLength]++;
            }
        }
        for (int i=0;i<sideLength;i++)
        {
            for (int j=0;j<sideLength;j++)
            {
                list.add(book[i][j]);
            }
        }
        Collections.sort(list, (o1, o2)->Integer.compare(o2,o1));
        int res=0;
        for (int i=0;i<maxOnes;i++)
        {
            res+=list.get(i);
        }
        return res;

    }
}
/**
 *现在有一个尺寸为 width * height 的矩阵 M，矩阵中的每个单元格的值不是 0 就是 1。
 *
 * 而且矩阵 M 中每个大小为 sideLength * sideLength 的 正方形 子阵中，1 的数量不得超过 maxOnes。
 *
 * 请你设计一个算法，计算矩阵中最多可以有多少个 1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：width = 3, height = 3, sideLength = 2, maxOnes = 1
 * 输出：4
 * 解释：
 * 题目要求：在一个 3*3 的矩阵中，每一个 2*2 的子阵中的 1 的数目不超过 1 个。
 * 最好的解决方案中，矩阵 M 里最多可以有 4 个 1，如下所示：
 * [1,0,1]
 * [0,0,0]
 * [1,0,1]
 * 示例 2：
 *
 * 输入：width = 3, height = 3, sideLength = 2, maxOnes = 2
 * 输出：6
 * 解释：
 * [1,0,1]
 * [1,0,1]
 * [1,0,1]
 *
 *
 * 提示：
 *
 * 1 <= width, height <= 100
 * 1 <= sideLength <= width, height
 * 0 <= maxOnes <= sideLength * sideLength
 */
