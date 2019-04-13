package JavaCode.random_records.N901_1000;

import java.util.Map;
import java.util.TreeMap;

public class N954_arrayof_doubled_pairs {

    public boolean canReorderDoubled(int[] A) {
        if(A.length==0)return true;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i:A)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for (Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()==0)continue;
            int key=e.getKey()>0?e.getKey()*2:e.getKey()/2;
            int cnt=map.getOrDefault(key,0);
            if(cnt>=e.getValue())
            {
                map.put(key,cnt-e.getValue());
            }
            else return false;
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/
 * 题目描述
 * 评论 (14)
 * 题解
 * 提交记录
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：[2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 *
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 */
