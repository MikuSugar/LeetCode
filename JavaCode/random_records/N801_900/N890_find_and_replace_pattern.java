package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author:fangjie
 * time:2019/11/27
 */
public class N890_find_and_replace_pattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        String key=getKey(pattern);
        List<String> res=new ArrayList<>(words.length/2+1);
        for (String s:words)
        {
            if(key.equals(getKey(s)))res.add(s);
        }
        return res;
    }

    private String getKey(String s) {
        StringBuilder sb=new StringBuilder();
        int[] book=new int[26];
        Arrays.fill(book,-1);
        int idx=0;
        for (char c:s.toCharArray())
        {
            int cur=c-'a';
            if(book[cur]==-1) book[cur]=idx++;
            sb.append(book[cur]);
        }
        return sb.toString();
    }
}
/*
你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。

如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。

（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）

返回 words 中与给定模式匹配的单词列表。

你可以按任何顺序返回答案。

 

示例：

输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
输出：["mee","aqq"]
解释：
"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
因为 a 和 b 映射到同一个字母。
 

提示：

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-and-replace-pattern
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
