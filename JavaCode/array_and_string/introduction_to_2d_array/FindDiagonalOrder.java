package JavaCode.array_and_string.introduction_to_2d_array;

import java.util.Arrays;

public class FindDiagonalOrder {

    public static void main(String[] args) {
        int[][] t={};
        System.out.println(Arrays.toString(new FindDiagonalOrder().findDiagonalOrder(t)));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0) return new int[]{};
        int index=0;
        int cnt=0;
        int flag=0;
        int[] result=new int[matrix.length*matrix[0].length];
        for(;cnt<result.length;index++,flag++)
        {
            if(flag%2==0)
            {
                int i,j;
                if(index>=matrix.length)
                {
                    i=matrix.length-1;
                    j=index-matrix.length+1;
                }
                else
                {
                    i=index;
                    j=0;
                }

                while (true)
                {
                    result[cnt]=matrix[i][j];
                    cnt++;
                    if(i>0&&j<matrix[0].length-1)
                    {
                        i--;
                        j++;
                    }
                    else
                    {
                        break;
                    }
                }
            }
            if(flag%2!=0)
            {
                int i,j;
                if(index>=matrix[0].length)
                {
                    j=matrix[0].length-1;
                    i=index-matrix[0].length+1;
                }
                else
                {
                    i=0;
                    j=index;
                }
                while (true)
                {
                    result[cnt]=matrix[i][j];
                    cnt++;
                    if(i<matrix.length-1&&j>0)
                    {
                        i++;
                        j--;
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/774/
 * 对角线遍历
 * 示例:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * 输出:  [1,2,4,7,5,3,6,8,9]
 */
