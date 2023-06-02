package JavaCode.random_records.N1901_N2100;

import utils.CheckUtil;
import utils.Parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mikusugar
 * @version 1.0, 2023/6/2 14:50
 * @description N2100_find_good_days_to_rob_the_bank
 */
public class N2100_find_good_days_to_rob_the_bank {

    public static void main(String[] args) {
        final N2100_find_good_days_to_rob_the_bank algo = new N2100_find_good_days_to_rob_the_bank();
        CheckUtil.check(Arrays.toString(Parse.toIntArr("[2,3]")), algo.goodDaysToRobBank(Parse.toIntArr("[5,3,3,3,5,6,2]"), 2).toString());
        CheckUtil.check(Arrays.toString(Parse.toIntArr("[0,1,2,3,4]")), algo.goodDaysToRobBank(Parse.toIntArr("[1,1,1,1,1]"), 0).toString());
        CheckUtil.check(Arrays.toString(Parse.toIntArr("[]")), algo.goodDaysToRobBank(Parse.toIntArr("[1,2,3,4,5,6]"), 2).toString());
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        final List<Integer> res = new ArrayList<>();

        final int[] countPre = pre(security);
        final int[] countLast = last(security);

        for (int i = 0; i < security.length; i++) {
            if (countPre[i] >= time && countLast[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }

    private int[] last(int[] security) {
        final int[] res = new int[security.length];
        int count = 0;
        for (int i = res.length - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                count++;
            } else {
                count = 0;
            }
            res[i] = count;
        }
        return res;
    }

    private int[] pre(int[] security) {
        final int[] res = new int[security.length];
        int count = 0;
        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i - 1]) {
                count++;
            } else {
                count = 0;
            }
            res[i] = count;
        }
        return res;
    }

}
/*
你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。

如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：

第 i 天前和后都分别至少有 time 天。
第 i 天前连续 time 天警卫数目都是非递增的。
第 i 天后连续 time 天警卫数目都是非递减的。
更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].

请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。

 

示例 1：

输入：security = [5,3,3,3,5,6,2], time = 2
输出：[2,3]
解释：
第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
示例 2：

输入：security = [1,1,1,1,1], time = 0
输出：[0,1,2,3,4]
解释：
因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
示例 3：

输入：security = [1,2,3,4,5,6], time = 2
输出：[]
解释：
没有任何一天的前 2 天警卫数目是非递增的。
所以没有适合打劫银行的日子，返回空数组。
 

提示：

1 <= security.length <= 105
0 <= security[i], time <= 105

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/find-good-days-to-rob-the-bank
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
