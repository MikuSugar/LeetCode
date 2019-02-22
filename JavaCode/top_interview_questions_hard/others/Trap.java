package JavaCode.top_interview_questions_hard.others;

public class Trap {
    public int trap(int[] height) {
        int index_max=0;//最高的柱子索引
        for (int i=0;i<height.length;i++)
        {
            if(height[i]>height[index_max])
            {
                index_max=i;
            }
        }

        int area=0;

        int left=0;
        for (int i=0;i<index_max;i++)
        {
            if(height[i]<left)
            {
                area+=left-height[i];
            }
            else
            {
                left=height[i];
            }
        }

        int right=0;
        for (int i=height.length-1;i>index_max;i--)
        {
            if(height[i]<right)
            {
                area+=right-height[i];
            }
            else
            {
                right=height[i];
            }
        }
        return area;
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/167/
 *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *  https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
