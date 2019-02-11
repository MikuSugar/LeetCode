package JavaCode.top_interview_questions_hard.array_and_strings;

public class MaxArea {
    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
        while (left<right)
        {
            max=Math.max(max,getArea(height,left,right));
            if(height[left]<height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return max;
    }

    private int getArea(int[] height,int i,int j)
    {
        return Math.min(height[i],height[j])*(j-i);
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/126/
 * 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
