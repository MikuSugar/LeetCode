package JavaCode.random_records.N2401_N2600;

import utils.Parse;

import java.util.Arrays;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/29 14:15
 * @description N2517_maximum_tastiness_of_candy_basket
 */
public class N2517_maximum_tastiness_of_candy_basket {

    public static void main(String[] args) {
        System.out.println(new N2517_maximum_tastiness_of_candy_basket().maximumTastiness(
                Parse.parseToIntArray("[13,5,1,8,21,2]"), 3
        ));
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int left = 0, right = price[n - 1] - price[0];
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, k, price)) {
                left = mid + 1;
                res = Math.max(res, mid);
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private boolean check(int mid, int k, int[] price) {
        int count = 0;
        int pre = price[0];
        for (int p : price) {
            if (p - pre >= mid) {
                count++;
                if (count >= k - 1) {
                    return true;
                }
                pre = p;
            }
        }
        return false;
    }

}
/*
给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。

商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。

返回礼盒的 最大 甜蜜度。

 

示例 1：

输入：price = [13,5,1,8,21,2], k = 3
输出：8
解释：选出价格分别为 [13,5,21] 的三类糖果。
礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
可以证明能够取得的最大甜蜜度就是 8 。
示例 2：

输入：price = [1,3,1], k = 2
输出：2
解释：选出价格分别为 [1,3] 的两类糖果。
礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
可以证明能够取得的最大甜蜜度就是 2 。
示例 3：

输入：price = [7,7,7,7], k = 2
输出：0
解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
 

提示：

1 <= price.length <= 105
1 <= price[i] <= 109
2 <= k <= price.length

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-tastiness-of-candy-basket
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
