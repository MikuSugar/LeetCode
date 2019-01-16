package JavaCode.top_interview_questions_medium.array_and_strings;

import java.util.*;


public class GroupAnagrams
{
    public static void main(String[] args)
    {
        char[] t={'a','c','b'};
        Arrays.sort(t);
        System.out.println();
    }

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map=new HashMap<>();

            for(String s:strs)
            {
                char[] t=s.toCharArray();
                Arrays.sort(t);
                String s1=new String(t);
                if(map.containsKey(s1))
                {
                    map.get(s1).add(s);
                }
                else
                {
                    List<String> list=new ArrayList<>();
                    list.add(s);
                    map.put(s1,list);
                }
            }

            List<List<String>> lists=new ArrayList<>();
            for(String key:map.keySet())
            {
                lists.add(map.get(key));
            }
            return lists;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/77/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
