package JavaCode.random_records;

import java.util.HashMap;
import java.util.Map;

public class N930_numSubarraysWithSum {

    public static void main(String[] args) {
        int[] A={1,0,1,0,1};
        System.out.println(new N930_numSubarraysWithSum().numSubarraysWithSum(A,2));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int res=0;
        for (int i:A)
        {
            sum+=i;
            res+=map.getOrDefault(sum-S,0);
            res+=sum==S?1:0;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 *
 *
 *
 * 示例：
 *
 * 输入：A = [1,0,1,0,1], S = 2
 * 输出：4
 * 解释：
 * 如下面黑体所示，有 4 个满足题目要求的子数组：
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 *
 * 提示：
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] 为 0 或 1
 */
