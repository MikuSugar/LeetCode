package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;
import utils.Parse;

import java.util.*;

/**
 * @author mikusugar
 * @version 1.0, 2023/4/6 17:22
 * @description N2542_maximum_subsequence_score
 */
public class N2542_maximum_subsequence_score {

    public static void main(String[] args) {
        final N2542_maximum_subsequence_score algo = new N2542_maximum_subsequence_score();
        //输入：nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
        //输出：12
        CheckUtil.check(algo.maxScore(Parse.toIntArr("[1,3,3,2]"), Parse.toIntArr("[2,1,3,4]"), 3)
                , 12L);
        //输入：nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
        //输出：30
        CheckUtil.check(algo.maxScore(Parse.toIntArr("[4,2,3,1,1]"), Parse.toIntArr("[7,5,10,9,6]"), 1),
                30L);

        //[93,463,179,2488,619,2006,1561,137,53,1765,2304,1459,1768,450,1938,2054,466,331,670,1830,1550,1534,2164,1280,2277,2312,1509,867,2223,1482,2379,1032,359,1746,966,232,67,1203,2474,944,1740,1775,1799,1156,1982,1416,511,1167,1334,2344]
        //[345,229,976,2086,567,726,1640,2451,1829,77,1631,306,2032,2497,551,2005,2009,1855,1685,729,2498,2204,588,474,693,30,2051,1126,1293,1378,1693,1995,2188,1284,1414,1618,2005,1005,1890,30,895,155,526,682,2454,278,999,1417,1682,995]
        //42
        CheckUtil.check(algo.maxScore(Parse.toIntArr("[93,463,179,2488,619,2006,1561,137,53,1765,2304,1459,1768,450,1938,2054,466,331,670,1830,1550,1534,2164,1280,2277,2312,1509,867,2223,1482,2379,1032,359,1746,966,232,67,1203,2474,944,1740,1775,1799,1156,1982,1416,511,1167,1334,2344]"),
                Parse.toIntArr("[345,229,976,2086,567,726,1640,2451,1829,77,1631,306,2032,2497,551,2005,2009,1855,1685,729,2498,2204,588,474,693,30,2051,1126,1293,1378,1693,1995,2188,1284,1414,1618,2005,1005,1890,30,895,155,526,682,2454,278,999,1417,1682,995]"),
                42), 26653494L);

    }

    @SuppressWarnings("all")
    public long maxScore(int[] nums1, int[] nums2, int k) {
        final int[][] arr = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);
        for (int i = 0; i < k; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];
        }
        long res = sum * arr[k - 1][1];
        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i][0]);
            sum += arr[i][0];
            sum -= pq.poll();
            res = Math.max(res, sum * arr[i][1]);
        }
        return res;

    }
}
/*
给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。

对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：

nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
用公示表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
请你返回 最大 可能的分数。

一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。

 

示例 1：

输入：nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
输出：12
解释：
四个可能的子序列分数为：
- 选择下标 0 ，1 和 2 ，得到分数 (1+3+3) * min(2,1,3) = 7 。
- 选择下标 0 ，1 和 3 ，得到分数 (1+3+2) * min(2,1,4) = 6 。
- 选择下标 0 ，2 和 3 ，得到分数 (1+3+2) * min(2,3,4) = 12 。
- 选择下标 1 ，2 和 3 ，得到分数 (3+3+2) * min(1,3,4) = 8 。
所以最大分数为 12 。
示例 2：

输入：nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
输出：30
解释：
选择下标 2 最优：nums1[2] * nums2[2] = 3 * 10 = 30 是最大可能分数。
 

提示：

n == nums1.length == nums2.length
1 <= n <= 105
0 <= nums1[i], nums2[j] <= 105
1 <= k <= n

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-subsequence-score
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
