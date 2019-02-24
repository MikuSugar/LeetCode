package JavaCode.top_interview_questions_hard.others;

import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)return 0;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<heights.length;i++)
        {
            if(stack.isEmpty()||heights[stack.peek()]<=heights[i])
            {
                stack.push(i);
            }
            else
            {
                int top=stack.pop();
                int len=stack.isEmpty()?i:i-stack.peek()-1;
                maxArea=Math.max(maxArea,len*heights[top]);
                i--;
            }
        }

        while (!stack.isEmpty())
        {
            int top=stack.pop();
            int len=stack.isEmpty()?heights.length:heights.length-stack.peek()-1;
            maxArea=Math.max(maxArea,len*heights[top]);
        }
        return maxArea;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/169/
 * 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
