package JavaCode.random_records.N1_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/12/17
 */
public class N84_largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        return slove(0,heights.length-1,heights);
    }

    private int slove(int left, int right, int[] heights) {
        if(left>right)return 0;
        int idx=left;
        for (int i=left;i<=right;i++)
        {
            if(heights[i]<heights[idx])
            {
                idx=i;
            }
        }
        return Math.max(heights[idx]*(right-left+1),
                Math.max(slove(left,idx-1,heights),slove(idx+1,right,heights)));
    }
}
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。
以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

 

示例:

输入: [2,1,5,6,2,3]
输出: 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
