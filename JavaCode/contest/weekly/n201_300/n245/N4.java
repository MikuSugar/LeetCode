package JavaCode.contest.weekly.n201_300.n245;

import java.util.*;

public class N4 {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(new N4().earliestAndLatest(5, 1, 3)));
    }

    private int n;

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        //TODO
        int cur = 0;
        this.n = n;
        Map<Integer, int[]> dp = new HashMap<>();
        return slove(cur, firstPlayer, secondPlayer, dp);
    }

    private int[] slove(int cur, final int firstPlayer, final int secondPlayer, Map<Integer, int[]> dp) {
        if (dp.containsKey(cur)) return dp.get(cur);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (((cur >> i) & 1) == 0) list.add(i);
        }

        int[] res = help(0, list.size() - 1, cur, firstPlayer, secondPlayer, dp, list);
        dp.put(cur, res);
        System.out.println("=========");
        System.out.println(list);
//        System.out.println(Arrays.toString(res));
        return res;
    }

    private int[] help(int l, int r, int cur, final int firstPlayer, final int secondPlayer, Map<Integer, int[]> dp, List<Integer> list) {
//        System.out.println(l + "::" + r);
        int left = list.get(l);
        int right = list.get(r);
        if (list.size() == 2||list.size()==3) {
            if (left == firstPlayer && right == secondPlayer) return new int[]{1, 1};
            else if (left == secondPlayer && right == firstPlayer) return new int[]{1, 1};
            else if(left==firstPlayer||left==secondPlayer||right==secondPlayer||right==firstPlayer){
                return new int[]{2,2};
            }
            return new int[]{Integer.MAX_VALUE >> 1, -1};
        }
        if (l == r || l + 1 == r) {
            if (left == firstPlayer && right == secondPlayer) return new int[]{1, 1};
            else if (left == secondPlayer && right == firstPlayer) return new int[]{1, 1};
            else if(left==firstPlayer||left==secondPlayer||right==secondPlayer||right==firstPlayer){
                return new int[]{2,2};
            }
            else {
                int[] res = slove(cur, firstPlayer, secondPlayer, dp);
                res[0]++;
                res[1]++;
                return res;
            }
        }

        if (left == firstPlayer && right == secondPlayer) return new int[]{1, 1};
        else if (left == secondPlayer && right == firstPlayer) return new int[]{1, 1};
        if (left == firstPlayer || left == secondPlayer) {
            int next = cur | (1 << right);
            return help(l + 1, r - 1, next, firstPlayer, secondPlayer, dp, list);
        }
        if (right == secondPlayer || right == firstPlayer) {
            int next = cur | (1 << left);
            return help(l + 1, r - 1, next, firstPlayer, secondPlayer, dp, list);
        }
        int next = cur | (1 << right);
        final int[] res1 = help(l + 1, r - 1, next, firstPlayer, secondPlayer, dp, list);
        next = cur | (1 << left);
        final int[] res2 = help(l + 1, r - 1, next, firstPlayer, secondPlayer, dp, list);
        return new int[]{Math.min(res1[0], res2[0]), Math.max(res1[1], res2[1])};

    }
}
/*
n 名运动员参与一场锦标赛，所有运动员站成一排，并根据 最开始的 站位从 1 到 n 编号（运动员 1 是这一排中的第一个运动员，运动员 2 是第二个运动员，依此类推）。

锦标赛由多个回合组成（从回合 1 开始）。每一回合中，这一排从前往后数的第 i 名运动员需要与从后往前数的第 i 名运动员比拼，获胜者将会进入下一回合。如果当前回合中运动员数目为奇数，那么中间那位运动员将轮空晋级下一回合。

例如，当前回合中，运动员 1, 2, 4, 6, 7 站成一排
运动员 1 需要和运动员 7 比拼
运动员 2 需要和运动员 6 比拼
运动员 4 轮空晋级下一回合
每回合结束后，获胜者将会基于最开始分配给他们的原始顺序（升序）重新排成一排。

编号为 firstPlayer 和 secondPlayer 的运动员是本场锦标赛中的最佳运动员。在他们开始比拼之前，完全可以战胜任何其他运动员。而任意两个其他运动员进行比拼时，其中任意一个都有获胜的可能，因此你可以 裁定 谁是这一回合的获胜者。

给你三个整数 n、firstPlayer 和 secondPlayer 。返回一个由两个值组成的整数数组，分别表示两位最佳运动员在本场锦标赛中比拼的 最早 回合数和 最晚 回合数。



示例 1：

输入：n = 11, firstPlayer = 2, secondPlayer = 4
输出：[3,4]
解释：
一种能够产生最早回合数的情景是：
回合 1：1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
回合 2：2, 3, 4, 5, 6, 11
回合 3：2, 3, 4
一种能够产生最晚回合数的情景是：
回合 1：1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
回合 2：1, 2, 3, 4, 5, 6
回合 3：1, 2, 4
回合 4：2, 4
示例 2：

输入：n = 5, firstPlayer = 1, secondPlayer = 5
输出：[1,1]
解释：两名最佳运动员 1 和 5 将会在回合 1 进行比拼。
不存在使他们在其他回合进行比拼的可能。


提示：

2 <= n <= 28
1 <= firstPlayer < secondPlayer <= n
 */
