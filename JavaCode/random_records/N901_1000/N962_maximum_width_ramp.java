package JavaCode.random_records.N901_1000;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/11
 */
public class N962_maximum_width_ramp {
    public int maxWidthRamp(int[] A) {
       int[] minL=new int[A.length];
       int[] maxR=new int[A.length];
       for (int i=1;i<A.length;i++)
       {
           minL[i]=minL[i-1];
           if(A[i]<A[minL[i]])
           {
               minL[i]=i;
           }
       }
       maxR[A.length-1]=A.length-1;
       for (int i=A.length-2;i>=0;i--)
       {
           maxR[i]=maxR[i+1];
           if(A[i]>A[maxR[i]])
           {
               maxR[i]=i;
           }
       }

       int res=0;
       int i=0,j=0;
       while (i<A.length&&j<A.length)
       {
           if(A[minL[i]]<=A[maxR[j]])
           {
               res=Math.max(res,maxR[j]-minL[i]);
               j=maxR[j]+1;
           }
           else
           {
               while (i<A.length-1&&minL[i]==minL[i+1])
               {
                   i++;
               }
               i++;
           }
       }
       return res;
    }
}
/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *  
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-ramp
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
