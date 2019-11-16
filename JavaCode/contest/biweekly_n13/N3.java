package JavaCode.contest.biweekly_n13;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/16
 */
public class N3 {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        TreeSet<String> res=new TreeSet<>();
        Map<String, Set<String>> map=new HashMap<>();
        for (List<String> s:synonyms)
        {
            map.putIfAbsent(s.get(0),new HashSet<>());
            map.putIfAbsent(s.get(1),new HashSet<>());
            map.get(s.get(0)).add(s.get(1));
            map.get(s.get(1)).add(s.get(0));
        }
        int idx=0;
        Map<String,Integer> map1=new HashMap<>();
        for (List<String> ss:synonyms)
        {
            for (String s:ss)
            {
                if(map1.containsKey(s))continue;
                help(s,map,idx++,map1);
            }
        }
        Map<Integer,List<String>> map2=new HashMap<>();
        for (Map.Entry<String,Integer> e:map1.entrySet())
        {
            map2.putIfAbsent(e.getValue(),new ArrayList<>());
            map2.get(e.getValue()).add(e.getKey());
        }
        String[] strs=text.split("[ ]");
        dfs(0,strs,map1,map2,res);
        return new ArrayList<>(res);
    }

    private void help(String s, Map<String, Set<String>> map, int value, Map<String, Integer> map1) {
        map1.put(s,value);
        for (String next:map.getOrDefault(s,new HashSet<>()))
        {
            if(map1.containsKey(next))continue;
            help(next,map,value,map1);
        }
    }

    private void dfs(int i, String[] strs, Map<String,Integer> map1,Map<Integer,List<String>> map2, TreeSet<String> res) {
        if(i==strs.length)
        {
            StringBuilder sb=new StringBuilder();
            for (String s:strs)sb.append(s+" ");
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        String temp=strs[i];
        for (String s:map2.getOrDefault(map1.getOrDefault(temp,-1),new LinkedList<>()))
        {
            strs[i]=s;
            dfs(i+1,strs,map1,map2,res);
            strs[i]=temp;
        }
        dfs(i+1,strs,map1,map2,res);
    }
}
/*
给你一个近义词表 synonyms 和一个句子 text ， synonyms 表中是一些近义词对 ，你可以将句子 text 中每个单词用它的近义词来替换。

请你找出所有用近义词替换后的句子，按 字典序排序 后返回。



示例 1：

输入：
synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
text = "I am happy today but was sad yesterday"
输出：
["I am cheerful today but was sad yesterday",
"I am cheerful today but was sorrow yesterday",
"I am happy today but was sad yesterday",
"I am happy today but was sorrow yesterday",
"I am joy today but was sad yesterday",
"I am joy today but was sorrow yesterday"]


提示：

0 <= synonyms.length <= 10
synonyms[i].length == 2
synonyms[0] != synonyms[1]
所有单词仅包含英文字母，且长度最多为 10 。
text 最多包含 10 个单词，且单词间用单个空格分隔开。
 */
