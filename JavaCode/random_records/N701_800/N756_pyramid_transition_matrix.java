package JavaCode.random_records.N701_800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N756_pyramid_transition_matrix {

    //从底向上搜索
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String,List<Character>> map=new HashMap<>();//以孩子为key，父亲为val
        for (String s:allowed)
        {
            String child=s.substring(0,2);
            char root=s.charAt(2);
            if(!map.containsKey(child))
            {
                map.put(child,new ArrayList<>());
            }
            map.get(root).add(root);
        }
        return dfs(bottom,map);//dfs搜索
    }

    private boolean dfs(String bottom, Map<String, List<Character>> map) {
        if(bottom.length()==1)return true;//已经到达顶层

        //获取所有可能的父亲集合
        List<List<Character>> list=new ArrayList<>();
        for (int i=1;i<bottom.length();i++)
        {
            String temp=bottom.substring(i-1,i+1);
            if(!map.containsKey(temp))return false;
            list.add(map.get(temp));
        }

        List<String> bottoms=new ArrayList<>();
        help(list,bottoms,0,"");//dfs排列出上面一层所有的可能

        //遍历搜索上面一层
        for (String s:bottoms)
        {
            if(dfs(s,map))return true;
        }
        return false;
    }

    private void help(List<List<Character>> list, List<String> bottoms, int index, String s) {
        if(index==list.size())
        {
            bottoms.add(s);
            return;
        }
        for (char c:list.get(index))
        {
            help(list,bottoms,index+1,s+c);
        }
    }


}
/**
 * https://leetcode-cn.com/problems/pyramid-transition-matrix/
 * 在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示，例如 “Z”。
 *
 * 使用三元组表示金字塔的堆砌规则如下：
 *
 * (A, B, C) 表示，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B, C)是被允许的三元组，我们才可以将其堆砌上。
 *
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 *
 * 如果可以由基层一直堆到塔尖返回true，否则返回false。
 *
 * 示例 1:
 *
 * 输入: bottom = "XYZ", allowed = ["XYD", "YZE", "DEA", "FFF"]
 * 输出: true
 * 解析:
 * 可以堆砌成这样的金字塔:
 *     A
 *    / \
 *   D   E
 *  / \ / \
 * X   Y   Z
 *
 * 因为符合('X', 'Y', 'D'), ('Y', 'Z', 'E') 和 ('D', 'E', 'A') 三种规则。
 * 示例 2:
 *
 * 输入: bottom = "XXYX", allowed = ["XXX", "XXY", "XYX", "XYY", "YXZ"]
 * 输出: false
 * 解析:
 * 无法一直堆到塔尖。
 * 注意, 允许存在三元组(A, B, C)和 (A, B, D) ，其中 C != D.
 * 注意：
 *
 * bottom 的长度范围在 [2, 8]。
 * allowed 的长度范围在[0, 200]。
 * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 */
