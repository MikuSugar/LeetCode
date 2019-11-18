package JavaCode.random_records.N401_500;

import java.util.Random;

/**
 * author:fangjie
 * time:2019/11/18
 */
public class N497_random_point_in_non_overlapping_rectangles {
    class Solution {

        private int fSum;
        private int[][] rects;
        private int[] sum;
        private Random random;
        public Solution(int[][] rects) {
            this.rects=rects;
            fSum=0;
            sum=new int[rects.length];
            random=new Random();
            int idx=0;
            for (int[] rect:rects)
            {
               fSum+=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
                sum[idx++]=fSum;
            }
        }

        public int[] pick() {
            int tar=random.nextInt(fSum);
            int left=0,right=sum.length-1;
            while (left<right)
            {
                int mid=(left+right)/2;
                if(sum[mid]>tar)right=mid;
                else left=mid+1;
            }
            int[] rect=rects[left];
            int w=rect[2]-rect[0]+1;
            int r=rect[3]-rect[1]+1;
            int preSum=sum[left]-w*r;
            return new int[]{rect[0]+(tar-preSum)%w,rect[1]+(tar-preSum)/w};
        }
    }
}
/*
给定一个非重叠轴对齐矩形的列表 rects，写一个函数 pick 随机均匀地选取矩形覆盖的空间中的整数点。

提示：

整数点是具有整数坐标的点。
矩形周边上的点包含在矩形覆盖的空间中。
第 i 个矩形 rects [i] = [x1，y1，x2，y2]，其中 [x1，y1] 是左下角的整数坐标，[x2，y2] 是右上角的整数坐标。
每个矩形的长度和宽度不超过 2000。
1 <= rects.length <= 100
pick 以整数坐标数组 [p_x, p_y] 的形式返回一个点。
pick 最多被调用10000次。
 

示例 1：

输入:
["Solution","pick","pick","pick"]
[[[[1,1,5,5]]],[],[],[]]
输出:
[null,[4,1],[4,1],[3,3]]
示例 2：

输入:
["Solution","pick","pick","pick","pick","pick"]
[[[[-2,-2,-1,-1],[1,0,3,0]]],[],[],[],[],[]]
输出:
[null,[-1,-2],[2,0],[-2,-1],[3,0],[-2,-2]]
 

输入语法的说明：

输入是两个列表：调用的子例程及其参数。Solution 的构造函数有一个参数，即矩形数组 rects。pick 没有参数。参数总是用列表包装的，即使没有也是如此。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
