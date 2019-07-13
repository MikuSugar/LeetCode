package JavaCode.contest.biweekly_n4;

public class N1 {
    static int[] res={31,28,31,30,31,30,31,31,30,31,30,31};
    public int numberOfDays(int Y, int M) {
        if(Y%400==0||(Y%100!=0&&Y%4==0))
        {
            if(M==2)return 29;
        }
        return res[M-1];
    }
}
/**
 *1118. 一月有多少天  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Easy
 * 指定年份 Y 和月份 M，请你帮忙计算出该月一共有多少天。
 *
 *
 *
 * 示例 1：
 *
 * 输入：Y = 1992, M = 7
 * 输出：31
 * 示例 2：
 *
 * 输入：Y = 2000, M = 2
 * 输出：29
 * 示例 3：
 *
 * 输入：Y = 1900, M = 2
 * 输出：28
 */
