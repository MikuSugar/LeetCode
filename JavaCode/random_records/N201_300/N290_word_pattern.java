package JavaCode.random_records.N201_300;

import java.util.HashMap;
import java.util.Map;

public class N290_word_pattern {
    public boolean wordPattern(String pattern, String str) {
        String[] book=new String[26];
        Map<String,Integer> map=new HashMap<>();
        String[] s = str.split(" ");
        if(pattern.length()!=s.length)return false;
        for (int i=0;i<pattern.length();i++)
        {
            char c=pattern.charAt(i);
            if(book[c-'a']==null&&!map.containsKey(s[i]))
            {
                book[c-'a']=s[i];
                map.put(s[i],c-'a');
            }
            else if(book[c-'a']==null)return false;
            else if(!map.containsKey(s[i]))return false;
            else if(c-'a'!=map.get(s[i]))return false;
        }
        return true;
    }
}
/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
