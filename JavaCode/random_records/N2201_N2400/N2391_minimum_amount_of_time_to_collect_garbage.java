package JavaCode.random_records.N2201_N2400;

import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2023/5/31 15:38
 * @description N2391_minimum_amount_of_time_to_collect_garbage
 */
public class N2391_minimum_amount_of_time_to_collect_garbage {

    public static void main(String[] args) {
        final N2391_minimum_amount_of_time_to_collect_garbage algo = new N2391_minimum_amount_of_time_to_collect_garbage();
        CheckUtil.check(21, algo.garbageCollection(Parse.parseToStringArray("[\"G\",\"P\",\"GP\",\"GG\"]"), Parse.parseToIntArray("[2,4,3]")));
        CheckUtil.check(37,algo.garbageCollection(Parse.parseToStringArray("[\"MMM\",\"PGM\",\"GP\"]"),Parse.parseToIntArray("[3,10]")));
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int gIdx = 0;
        int pIdx = 0;
        int mIdx = 0;
        for (int i = 0; i < garbage.length; i++) {
            final int[] count = count(garbage[i]);
            final int g = count[0];
            final int p = count[1];
            final int m = count[2];

            res += cal(g, gIdx, i, travel);
            res += cal(p, pIdx, i, travel);
            res += cal(m, mIdx, i, travel);

            gIdx = g > 0 ? i : gIdx;
            pIdx = p > 0 ? i : pIdx;
            mIdx = m > 0 ? i : mIdx;
        }
        return res;
    }

    private int cal(int count, int preIdx, int curIdx, int[] travel) {
        if (count == 0) {
            return 0;
        }
        int res = 0;
        for (int i = preIdx; i < curIdx; i++) {
            res += travel[i];
        }
        return res + count;
    }

    private int[] count(String str) {
        final int[] res = new int[]{0, 0, 0};
        for (char c : str.toCharArray()) {
            if (c == 'G') res[0]++;
            else if (c == 'P') res[1]++;
            else if (c == 'M') res[2]++;
        }
        return res;
    }
}
/*
给你一个下标从 0 开始的字符串数组 garbage ，其中 garbage[i] 表示第 i 个房子的垃圾集合。garbage[i] 只包含字符 'M' ，'P' 和 'G' ，但可能包含多个相同字符，每个字符分别表示一单位的金属、纸和玻璃。垃圾车收拾 一 单位的任何一种垃圾都需要花费 1 分钟。

同时给你一个下标从 0 开始的整数数组 travel ，其中 travel[i] 是垃圾车从房子 i 行驶到房子 i + 1 需要的分钟数。

城市里总共有三辆垃圾车，分别收拾三种垃圾。每辆垃圾车都从房子 0 出发，按顺序 到达每一栋房子。但它们 不是必须 到达所有的房子。

任何时刻只有 一辆 垃圾车处在使用状态。当一辆垃圾车在行驶或者收拾垃圾的时候，另外两辆车 不能 做任何事情。

请你返回收拾完所有垃圾需要花费的 最少 总分钟数。

 

示例 1：

输入：garbage = ["G","P","GP","GG"], travel = [2,4,3]
输出：21
解释：
收拾纸的垃圾车：
1. 从房子 0 行驶到房子 1
2. 收拾房子 1 的纸垃圾
3. 从房子 1 行驶到房子 2
4. 收拾房子 2 的纸垃圾
收拾纸的垃圾车总共花费 8 分钟收拾完所有的纸垃圾。
收拾玻璃的垃圾车：
1. 收拾房子 0 的玻璃垃圾
2. 从房子 0 行驶到房子 1
3. 从房子 1 行驶到房子 2
4. 收拾房子 2 的玻璃垃圾
5. 从房子 2 行驶到房子 3
6. 收拾房子 3 的玻璃垃圾
收拾玻璃的垃圾车总共花费 13 分钟收拾完所有的玻璃垃圾。
由于没有金属垃圾，收拾金属的垃圾车不需要花费任何时间。
所以总共花费 8 + 13 = 21 分钟收拾完所有垃圾。
示例 2：

输入：garbage = ["MMM","PGM","GP"], travel = [3,10]
输出：37
解释：
收拾金属的垃圾车花费 7 分钟收拾完所有的金属垃圾。
收拾纸的垃圾车花费 15 分钟收拾完所有的纸垃圾。
收拾玻璃的垃圾车花费 15 分钟收拾完所有的玻璃垃圾。
总共花费 7 + 15 + 15 = 37 分钟收拾完所有的垃圾。
 

提示：

2 <= garbage.length <= 105
garbage[i] 只包含字母 'M' ，'P' 和 'G' 。
1 <= garbage[i].length <= 10
travel.length == garbage.length - 1
1 <= travel[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-amount-of-time-to-collect-garbage
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
