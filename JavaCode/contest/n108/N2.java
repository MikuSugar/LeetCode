package JavaCode.contest.n108;


import java.util.HashMap;
import java.util.Map;

public class N2 {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int res=0;
        int sum=0;
        for (int i:A)
        {
            sum+=i;
            res+=map.getOrDefault(sum-S,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
/**
 * 930. 和相同的二元子数组  显示英文描述
 * 用户通过次数 88
 * 用户尝试次数 179
 * 通过次数 89
 * 提交次数 527
 * 题目难度 Medium
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
