package JavaCode.random_records.N401_500;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/7
 */
public class N472_concatenated_words {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res=new ArrayList<>(words.length/3+1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> set=new HashSet<>();
        for (String word:words)
        {
            if(check(word,set)) res.add(word);
            set.add(word);
        }
        return res;
    }

    private boolean check(String word, Set<String> set) {
        if(set.contains(word))return true;
        for (int i=1;i<word.length();i++)
        {
            if(set.contains(word.substring(0,i))&&check(word.substring(i),set))
                return true;
        }
        return false;
    }
}
/*
给定一个不含重复单词的列表，编写一个程序，返回给定单词列表中所有的连接词。

连接词的定义为：一个字符串完全是由至少两个给定数组中的单词组成的。

示例:

输入: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

输出: ["catsdogcats","dogcatsdog","ratcatdogcat"]

解释: "catsdogcats"由"cats", "dog" 和 "cats"组成;
     "dogcatsdog"由"dog", "cats"和"dog"组成;
     "ratcatdogcat"由"rat", "cat", "dog"和"cat"组成。
说明:

给定数组的元素总数不超过 10000。
给定数组中元素的长度总和不超过 600000。
所有输入字符串只包含小写字母。
不需要考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/concatenated-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
