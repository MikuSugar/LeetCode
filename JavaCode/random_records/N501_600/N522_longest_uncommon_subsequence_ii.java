package JavaCode.random_records.N501_600;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class N522_longest_uncommon_subsequence_ii {

    public int findLUSlength(String[] strs) {
        Map<String,Integer> map=new HashMap<>();
        for (String s:strs)
        {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int res=0;
        Set<String> set=map.keySet();
        for (Map.Entry<String,Integer> e:map.entrySet())
        {
            if(e.getValue()==1&&e.getKey().length()>res)
            {
                boolean flag=false;
                for (String s:set)
                {
                    if(s.equals(e.getKey()))continue;
                    else if(check(e.getKey().toCharArray(),s.toCharArray()))
                    {
                        flag=true;
                        break;
                    }
                }
                if(!flag)res=e.getKey().length();
            }
        }
        return res;
    }

    private boolean check(char[] key, char[] s) {
        int cur=0;
        for (char c:key)
        {
            boolean flag=false;
            for (;cur<s.length;cur++)
            {
                if(s[cur]==c)
                {
                    flag=true;
                    cur++;
                    break;
                }
            }
            if(!flag)return false;
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii/
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 *
 *
 *
 * 示例：
 *
 * 输入: "aba", "cdc", "eae"
 * 输出: 3
 *
 *
 * 提示：
 *
 * 所有给定的字符串长度不会超过 10 。
 * 给定字符串列表的长度将在 [2, 50 ] 之间。
 *
 */
