package JavaCode.random_records.N201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/9/17
 */
public class N229_majority_element_ii {
    public List<Integer> majorityElement(int[] nums) {
        int num1=0,num2=0;
        int cnt1=0,cnt2=0;
        for (int i:nums)
        {
            if(num1==i)cnt1++;
            else if(num2==i)cnt2++;
            else if(cnt1==0)
            {
                num1=i;
                cnt1=1;
            }
            else if(cnt2==0)
            {
                num2=i;
                cnt2=1;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=cnt2=0;
        for (int i:nums)
        {
            cnt1+=i==num1?1:0;
            cnt2+=i==num2?1:0;
        }
        List<Integer> res=new ArrayList<>(2);
        if(cnt1>nums.length/3)res.add(num1);
        if(num1!=num2&&cnt2>nums.length/3)res.add(num2);
        return res;
    }
}
/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
