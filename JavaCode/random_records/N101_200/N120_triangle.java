package JavaCode.random_records.N101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N120_triangle
{

    public int minimumTotal(List<List<Integer>> triangle)
    {
       for (int i=triangle.size()-2;i>=0;i--)
       {
           for (int j=0;j<=i;j++)
           {
               triangle.get(i).set(j,Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1))+triangle.get(i).get(j));
           }
       }
       return triangle.get(0).get(0);
    }
}
/**
 * https://leetcode-cn.com/problems/triangle/
 *  给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
