package JavaCode.contest.n138;

import java.util.Arrays;

public class N1 {
    public int heightChecker(int[] heights) {
        int[] h= Arrays.copyOf(heights,heights.length);
        Arrays.sort(h);
        int res=0;
        for (int i=0;i<h.length;i++)
        {
            res+=heights[i]!=h[i]?1:0;
        }
        return res;
    }
}
/**
 *1051. 高度检查器  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Easy
 * 拍年度纪念照时，要求学生按照高度非递减的顺序排列。
 *
 * 返回没有站在正确位置的学生人数。（该人数是能让所有学生以不递减高度排列的必要移动人数。）
 *
 *
 *
 * 示例：
 *
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生没有站在正确的位置。
 *
 *
 * 提示：
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
