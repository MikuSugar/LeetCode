package JavaCode.random_records.N301_400;

import java.util.*;

public class N398_random_pick_index {
    class Solution {
        private Map<Integer, List<Integer>> map;
        private Random random;
        public Solution(int[] nums) {
            random=new Random();
            map=new HashMap<>();
            for (int i=0;i<nums.length;i++)
            {
                if(!map.containsKey(nums[i]))
                {
                    map.put(nums[i],new ArrayList<>());
                }
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list=map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your n2342 object will be instantiated and called as such:
 * n2342 obj = new n2342(nums);
 * int param_1 = obj.pick(target);
 */
}
/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 *
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 *
 * 示例:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * n2342 solution = new n2342(nums);
 *
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 *
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
