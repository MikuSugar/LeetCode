package JavaCode.contest.other.fa_2021;

import java.util.*;

/**
 * @author mikusugar
 */
public class N2 {

    public int maxmiumScore(int[] cards, int cnt) {

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : cards) {
            if (i % 2 == 0) l1.add(i);
            else l2.add(i);
        }
        l1.sort((o1, o2) -> Integer.compare(o2, o1));
        l2.sort((o1, o2) -> Integer.compare(o2, o1));

        int[] s1 = getSum(l1);
        int[] s2 = getSum(l2);

        int res = 0;
        for (int i = 0; i <= Math.min(cnt, s2.length-1); i += 2) {
            int j = cnt - i;
            if (j >= s1.length) continue;
            res = Math.max(res, s1[j] + s2[i]);
        }
        return res;
    }

    private int[] getSum(List<Integer> list) {
        int[] res = new int[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            res[i + 1] = res[i] + list.get(i);
        }
        return res;
    }
}
/*
力扣挑战赛」心算项目的挑战比赛中，要求选手从 N 张卡牌中选出 cnt 张卡牌，若这 cnt 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 cnt 张卡牌数字总和。
给定数组 cards 和 cnt，其中 cards[i] 表示第 i 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡牌方案，则返回 0。

示例 1：

输入：cards = [1,2,8,9], cnt = 3

输出：18

解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。

示例 2：

输入：cards = [3,3,1], cnt = 1

输出：0

解释：不存在获取有效得分的卡牌方案。

提示：

1 <= cnt <= cards.length <= 10^5
1 <= cards[i] <= 1000
 */
