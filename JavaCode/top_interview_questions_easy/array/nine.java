package JavaCode.top_interview_questions_easy.array;

import java.util.*;

public class nine {

    public static void main(String[] args) {
        int[] t={3,3};

        System.out.println(Arrays.toString(new nine().new Solution().twoSum(t,6)));
    }
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            return fun1(nums,target);
        }

        //暴力
        int[] fun0(int[] nums,int target)
        {
            int[] ans=new int[2];

            for(int i=0;i<nums.length;i++)
            {
                int x=target-nums[i];
                for(int k=0;k<nums.length;k++)
                {
                    if(k==i)
                    {
                        break;
                    }

                    if(x==nums[k])
                    {
                        ans[0]=i;
                        ans[1]=k;
                        return ans;
                    }
                }
            }
            return ans;
        }

        //hash优化
        int[] fun1(int[] nums,int target)
        {
            int[] ans=new int[2];
            Map<Integer, ArrayList<Integer>> map=new HashMap<>();
            for(int i=0;i<nums.length;i++)
            {
                if(map.containsKey(nums[i]))
                {
                    map.get(nums[i]).add(i);
                }
                else
                {
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(i);
                    map.put(nums[i],list);
                }
            }
            for(int key:map.keySet())
            {
                int x=target-key;
                if(map.containsKey(x))
                {
                    if(x==key)
                    {
                        if (map.get(key).size()>1)
                        {
                            ArrayList<Integer> list = map.get(key);
                            ans[0] = list.get(0);
                            ans[1] = list.get(1);
                        }
                        continue;
                    }
                    else
                    {
                        ans[0]=map.get(key).get(0);
                        ans[1]=map.get(x).get(0);
                    }

                    if(ans[0]>ans[1])
                    {
                        ans[0]=ans[0]+ans[1];
                        ans[1]=ans[0]-ans[1];
                        ans[0]=ans[0]-ans[1];
                    }
                    break;
                }
            }
            return ans;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
