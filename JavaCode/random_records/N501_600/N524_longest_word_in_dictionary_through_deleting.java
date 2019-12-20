package JavaCode.random_records.N501_600;

import java.util.*;

/**
 * author:fangjie
 * time:2019/12/20
 */
public class N524_longest_word_in_dictionary_through_deleting {
    public String findLongestWord(String s, List<String> d) {
        char[] str=s.toCharArray();
        List<Integer>[] book=new List[26];
        for (int i=0;i<book.length;i++)book[i]=new ArrayList<>(s.length()/10+1);
        for (int i=0;i<str.length;i++)
        {
            book[str[i]-'a'].add(i);
        }
        d.sort((o1, o2)->{
            if (o1.length()==o2.length()) return o1.compareTo(o2);
            return Integer.compare(o2.length(), o1.length());
        });
        for (String res:d)
        {
            if(check(res,book,s.length()))return res;
        }
        return "";
    }

    private boolean check(String s, List<Integer>[] book, int len) {
        char[] str=s.toCharArray();
        for (int i=str.length-1;i>=0;i--)
        {
            List<Integer> list=book[str[i]-'a'];
            int idx=-1;
            int left=0,right=list.size()-1;
            while (left<=right)
            {
                int mid=(left+right)/2;
                int value=list.get(mid);
                if(value<len)
                {
                    idx=value;
                    left=mid+1;
                }
                else right=mid-1;
            }
            if(idx==-1)return false;
            len=idx;
        }
        return true;
    }
}
/*
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

示例 1:

输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出:
"apple"
示例 2:

输入:
s = "abpcplea", d = ["a","b","c"]

输出:
"a"
说明:

所有输入的字符串只包含小写字母。
字典的大小不会超过 1000。
所有输入的字符串长度不会超过 1000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
