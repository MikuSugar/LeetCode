package JavaCode.random_records.N901_1000;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/9
 */
public class N966_vowel_spellchecker {

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set=new HashSet<>();
        Map<String,String> lowMap=new HashMap<>();
        Map<String,String> vowelMap=new HashMap<>();
        for (String w:wordlist)
        {
            set.add(w);
            lowMap.putIfAbsent(w.toLowerCase(),w);
            vowelMap.putIfAbsent(getVowelKey(w),w);
        }
        String[] res=new String[queries.length];
        for (int i=0;i<queries.length;i++)
        {
            String q=queries[i];
            if(set.contains(q))
            {
                res[i]=q;
                continue;
            }
            res[i]=lowMap.getOrDefault(q.toLowerCase(),"");
            if(!res[i].isEmpty())continue;
            res[i]=vowelMap.getOrDefault(getVowelKey(q),"");
        }
        return res;
    }

    private String getVowelKey(String w) {
        char[] strs=w.toLowerCase().toCharArray();
        for (int i=0;i<strs.length;i++)
        {
            if(check(strs[i]))strs[i]='$';
        }
        return new String(strs);
    }

    private boolean check(char str) {
        for (char s:chars) if(s==str)return true;
        return false;
    }

    final static char chars[]={'a','e','i','o','u'};

}
/**
 * 在给定单词列表 wordlist 的情况下，我们希望实现一个拼写检查器，将查询单词转换为正确的单词。
 *
 * 对于给定的查询单词 query，拼写检查器将会处理两类拼写错误：
 *
 * 大小写：如果查询匹配单词列表中的某个单词（不区分大小写），则返回的正确单词与单词列表中的大小写相同。
 * 例如：wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * 例如：wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * 例如：wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * 元音错误：如果在将查询单词中的元音（‘a’、‘e’、‘i’、‘o’、‘u’）分别替换为任何元音后，能与单词列表中的单词匹配（不区分大小写），则返回的正确单词与单词列表中的匹配项大小写相同。
 * 例如：wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * 例如：wordlist = ["YellOw"], query = "yeellow": correct = "" （无匹配项）
 * 例如：wordlist = ["YellOw"], query = "yllw": correct = "" （无匹配项）
 * 此外，拼写检查器还按照以下优先级规则操作：
 *
 * 当查询完全匹配单词列表中的某个单词（区分大小写）时，应返回相同的单词。
 * 当查询匹配到大小写问题的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 当查询匹配到元音错误的单词时，您应该返回单词列表中的第一个这样的匹配项。
 * 如果该查询在单词列表中没有匹配项，则应返回空字符串。
 * 给出一些查询 queries，返回一个单词列表 answer，其中 answer[i] 是由查询 query = queries[i] 得到的正确单词。
 *
 *  
 *
 * 示例：
 *
 * 输入：wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * 输出：["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
 *  
 *
 * 提示：
 *
 * 1 <= wordlist.length <= 5000
 * 1 <= queries.length <= 5000
 * 1 <= wordlist[i].length <= 7
 * 1 <= queries[i].length <= 7
 * wordlist 和 queries 中的所有字符串仅由英文字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vowel-spellchecker
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
