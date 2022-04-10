package JavaCode.contest.weekly.n201_300.n288;

import java.util.PriorityQueue;

/**
 * @author mikusugar
 */
public class N1 {
    public int largestInteger(int num) {
        final PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        final PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

        for (char i : String.valueOf(num).toCharArray()) {
            int cur = i - '0';
            if (cur % 2 == 0) pq2.add(cur);
            else pq1.add(cur);
        }

        StringBuilder sb = new StringBuilder();
        for (char i : String.valueOf(num).toCharArray()) {
            int cur = i - '0';
            if (cur % 2 == 0) sb.append(pq2.poll());
            else sb.append(pq1.poll());
        }

        return Integer.parseInt(sb.toString());

    }
}
/*
给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。

返回交换 任意 次之后 num 的 最大 可能值。



示例 1：

输入：num = 1234
输出：3412
解释：交换数字 3 和数字 1 ，结果得到 3214 。
交换数字 2 和数字 4 ，结果得到 3412 。
注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
示例 2：

输入：num = 65875
输出：87655
解释：交换数字 8 和数字 6 ，结果得到 85675 。
交换数字 5 和数字 7 ，结果得到 87655 。
注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。


提示：

1 <= num <= 109

 */
