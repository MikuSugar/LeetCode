package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.List;

public class N821_shortest_distance_to_a_character {


    public int[] shortestToChar(String S, char C) {
        List<Integer> list=new ArrayList<>(S.length());
        for (int i=0;i<S.length();i++)
        {
            if(S.charAt(i)==C)
                list.add(i);
        }
        int[] res=new int[S.length()];
        for (int i=0;i<S.length();i++)
        {
            if(list.size()==1)
            {
                res[i]=Math.abs(list.get(0)-i);
            }
            else
            {
                int left=Math.abs(list.get(0)-i);
                int right=Math.abs(list.get(1)-i);
                if(right<=left)
                {
                    list.remove(0);
                    res[i]=right;
                }
                else
                {
                    res[i]=left;
                }
            }
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 *
 * 示例 1:
 *
 * 输入: S = "loveleetcode", C = 'e'
 * 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * 说明:
 *
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 */
