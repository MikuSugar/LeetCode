package JavaCode.contest.weekly.n0_200.n158;

import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2019/10/13
 */
public class N4 {
    public int maxEqualFreq(int[] nums) {
        if(nums.length<=2)return nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i=nums.length-1;i>=0;i--)
        {
            if(check(map))return i+1;
            int cnt=map.get(nums[i]);
            if(cnt==1)map.remove(nums[i]);
            else map.put(nums[i],cnt-1);
        }
        return -1;
    }

    private boolean check(Map<Integer, Integer> map) {
        if(map.size()==1)return true;
        Map<Integer,Integer> cntmap=new HashMap<>();
        int ka=-1,kb=-1;
        for (int i:map.values())
        {
            if(ka==-1)ka=i;
            else if(kb==-1&&i!=ka)kb=i;
            cntmap.put(i,cntmap.getOrDefault(i,0)+1);
            if(cntmap.size()>2)return false;
        }
        if(cntmap.size()==1)return ka==1;
        int va=cntmap.get(ka);
        int vb=cntmap.get(kb);
        if(va==1) return ka-kb==1||ka==1;
        if(vb==1) return kb-ka==1||kb==1;
        return false;
    }
}
/**
 *给出一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回其长度：
 *
 * 从前缀中 删除一个 元素后，使得所剩下的每个数字的出现次数相同。
 * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,2,1,1,5,3,3,5]
 * 输出：7
 * 解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4]=5，就可以得到 [2,2,1,1,3,3]，里面每个数字都出现了两次。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
 * 输出：13
 * 示例 3：
 *
 * 输入：nums = [1,1,1,2,2,2]
 * 输出：5
 * 示例 4：
 *
 * 输入：nums = [10,2,8,9,3,8,1,5,2,3,7,6]
 * 输出：8
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
