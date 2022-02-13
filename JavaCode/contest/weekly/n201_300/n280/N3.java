package JavaCode.contest.weekly.n201_300.n280;

import utils.Parse;

import java.util.Arrays;

/**
 * @author mikusugar
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().minimumRemoval(
                Parse.parseToIntArray(
                        "[53,2,94,12,96,78,17,71,78,67,1,5,61,30,13,98,96,63,92,7,52,22,27,23,62,79,36,67,33,52,96,6,15,32,90,53,55,21,55,80,3,80,50,78,51,78,99,19,91,87,41,11,7,62,5,98,18,13]"
                )
        ));
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long[] sum = new long[beans.length + 1];
        for (int i = 0; i < beans.length; i++) {
            sum[i + 1] = sum[i] + beans[i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < beans.length; i++) {
            res = Math.min(res, sum[i] + sum[sum.length - 1] - sum[i + 1] - (long) beans[i] * (beans.length - i - 1));
        }
        return res;
    }
}
/*
给你一个 正 整数数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。

请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少 还有 一颗 魔法豆的袋子）魔法豆的数目 相等 。一旦魔法豆从袋子中取出，你不能将它放到任何其他的袋子中。

请你返回你需要拿出魔法豆的 最少数目。



示例 1：

输入：beans = [4,1,6,5]
输出：4
解释：
- 我们从有 1 个魔法豆的袋子中拿出 1 颗魔法豆。
  剩下袋子中魔法豆的数目为：[4,0,6,5]
- 然后我们从有 6 个魔法豆的袋子中拿出 2 个魔法豆。
  剩下袋子中魔法豆的数目为：[4,0,4,5]
- 然后我们从有 5 个魔法豆的袋子中拿出 1 个魔法豆。
  剩下袋子中魔法豆的数目为：[4,0,4,4]
总共拿出了 1 + 2 + 1 = 4 个魔法豆，剩下非空袋子中魔法豆的数目相等。
没有比取出 4 个魔法豆更少的方案。
示例 2：

输入：beans = [2,10,3,2]
输出：7
解释：
- 我们从有 2 个魔法豆的其中一个袋子中拿出 2 个魔法豆。
  剩下袋子中魔法豆的数目为：[0,10,3,2]
- 然后我们从另一个有 2 个魔法豆的袋子中拿出 2 个魔法豆。
  剩下袋子中魔法豆的数目为：[0,10,3,0]
- 然后我们从有 3 个魔法豆的袋子中拿出 3 个魔法豆。
  剩下袋子中魔法豆的数目为：[0,10,0,0]
总共拿出了 2 + 2 + 3 = 7 个魔法豆，剩下非空袋子中魔法豆的数目相等。
没有比取出 7 个魔法豆更少的方案。


提示：

1 <= beans.length <= 105
1 <= beans[i] <= 105
 */
