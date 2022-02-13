package JavaCode.contest.weekly.n201_300.n280;

import utils.Parse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mikusugar
 */
public class N2 {
    public static void main(String[] args) {
        //[3,1,3,2,4,3]
        //[2,2,2,2,2]
        System.out.println(new N2().minimumOperations(Parse.parseToIntArray("[2,2,2,2,2]")));
    }

    public int minimumOperations(int[] nums) {
        if (nums.length <= 1) return 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                map2.put(nums[i], map2.getOrDefault(nums[i], 0) + 1);
            } else {
                map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            }
        }
        int a = help(map2);
        int b = help(map1);
        int aCnt = map2.get(a);
        int bCnt = map1.get(b);
        if (a == b) {
            map2.remove(a);
            int a1 = help(map2);
            map1.remove(b);
            int b1 = help(map1);
            if (a1 == -1 || b1 == -1) {
                if (a1 != -1) a = a1;
                if (b1 != -1) b = b1;
            } else {
                return Math.min(slove(nums, a, b1), slove(nums, a1, b));
            }
        }
        if (a == b) {
            if (aCnt > bCnt) b++;
            else a++;
        }
        return slove(nums, a, b);

    }

    private int slove(int[] nums, int a, int b) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                if (nums[i] != a) res++;
            } else {
                if (nums[i] != b) res++;
            }
        }
        return res;
    }

    private int help(Map<Integer, Integer> map) {
        int aMax = -1, aCnt = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > aCnt) {
                aCnt = e.getValue();
                aMax = e.getKey();
            }
        }
        return aMax;
    }
}
/*
给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。

如果满足下述条件，则数组 nums 是一个 交替数组 ：

nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。

返回使数组变成交替数组的 最少操作数 。



示例 1：

输入：nums = [3,1,3,2,4,3]
输出：3
解释：
使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
在这种情况下，操作数为 3 。
可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
示例 2：

输入：nums = [1,2,2,2,2]
输出：2
解释：
使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
在这种情况下，操作数为 2 。
注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。


提示：

1 <= nums.length <= 105
1 <= nums[i] <= 105
 */
