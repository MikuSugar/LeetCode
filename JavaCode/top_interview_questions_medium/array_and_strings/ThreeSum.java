package JavaCode.top_interview_questions_medium.array_and_strings;

import java.util.*;

public class ThreeSum
{

    public static void main(String[] args)
    {
        int[] t={-4,-1,-1,0, 1, 2};
       showList(new ThreeSum().new Solution().threeSum(t));
    }

    public static void showList(List<List<Integer>> list)
    {
        for(List<Integer> list1:list)
        {
            System.out.println("------");
            for(int i:list1)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return fun0(nums);
        }

        //暴力
        List<List<Integer>> fun0(int[] nums)
        {
            Map<Integer,Integer> map=new HashMap<>();

            for(int i:nums)
            {
                if(map.containsKey(i))
                {
                    map.put(i,map.get(i)+1);
                }
                else
                {
                    map.put(i,1);
                }
            }

            List<List<Integer>> list=new ArrayList<>();
            Set<String> set=new HashSet<>();
            int x,y;
            for(int i=0;i<nums.length-1;i++)
            {
                x=nums[i];
                map.put(x,map.get(x)-1);
                for (int j=i+1;j<nums.length;j++)
                {
                    y=nums[j];
                    map.put(y,map.get(y)-1);
                    int c=0-x-y;
                    if(c>=0)
                    {

                        if (map.containsKey(c))
                        {
                            if (map.get(c) > 0)
                            {
                                for (int k = 0; k < map.get(c); k++)
                                {
                                    int[] tem={x,y,c};
                                    Arrays.sort(tem);
                                    if(set.contains(Arrays.toString(tem)))
                                    {
                                        break;
                                    }
                                    else
                                    {
                                        List<Integer> list1 = new ArrayList<>();
                                        set.add(Arrays.toString(tem));
                                        list1.add(x);
                                        list1.add(y);
                                        list1.add(c);
                                        list.add(list1);
                                    }

                                }
                            }
                        }

                    }
                    map.put(y, map.get(y) + 1);
                }
                map.put(x,map.get(x)+1);
            }
            return list;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/75/
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
