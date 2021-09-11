package JavaCode.contest.other.fa_2021;



import java.util.*;

/**
 * @author mikusugar
 */
public class N2 {
    public static void main(String[] args) {

    }


    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i : cards) {
            if (i % 2 == 0) l1.add(i);
            else l2.add(i);
        }
        l2.sort((o1, o2) -> Integer.compare(o2, o1));

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0] / o2[1], o1[0] / o1[1]));

        for (int i = 1; i < l2.size(); i += 2) {
            pq.add(new int[]{l2.get(i) + l2.get(i - 1), 2});
        }
        for (int i : l1) pq.add(new int[]{i, 1});

        int sum = 0;
        while (cnt > 0 && !pq.isEmpty()) {
            final int[] cur = pq.poll();
            if (cnt >= cur[1]) {
                cnt -= cur[1];
                sum += cur[0];
            }
        }
        if (cnt > 0) return 0;
        return sum;

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
