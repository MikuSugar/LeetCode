package JavaCode.array_and_string.introduction_to_2d_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralOrder {


    public static void main(String[] args) {
        int[][] t={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for(int i:new SpiralOrder().spiralOrder(t))
        {
            System.out.print(i+",");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0) return list;

        while (true)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                list.add(matrix[0][i]);
            }
            if(matrix.length==1) break;
            else matrix=fun0(matrix);
        }
        return list;

    }

    //去除第一行并翻转
    int[][] fun0(int[][] matrix)
    {
        int[][] result= new int[matrix[0].length][matrix.length-1];

        for(int j=matrix[0].length-1;j>=0;j--)
        {
            for(int i=1;i<matrix.length;i++)
            {
                result[result.length-1-j][i-1]=matrix[i][j];
            }
        }
        return result;
    }

}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/775/
 * 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
