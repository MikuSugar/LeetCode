package JavaCode.contest.weekly.n0_200.n160;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/10/27
 */
public class N3 {
    private int res;
    public int maxLength(List<String> arr) {
        List<int[]> list=new ArrayList<>();
        for (String s:arr)
        {
            int[] book=getCnt(s);
            if(book!=null)list.add(book);
        }
        res=0;
        dfs(0,new int[26],list);
        return res;
    }

    private void dfs(int idx, int[] book, List<int[]> list) {
        if(idx==list.size())
        {
            res=Math.max(res,getLen(book));
            return;
        }
        dfs(idx+1,book,list);
        if(check(list.get(idx),book))
        {
            int[] next=add(list.get(idx),book);
            dfs(idx+1,next,list);
        }
    }

    private boolean check(int[] a, int[] b) {
        for (int i=0;i<26;i++)
        {
            if(a[i]+b[i]>1)return false;
        }
        return true;
    }

    private int[] add(int[] a,int[] b)
    {
        int[] res=new int[26];
        for (int i=0;i<26;i++)
        {
            res[i]=a[i]+b[i];
        }
        return res;
    }

    private int getLen(int[] book) {
        int len=0;
        for (int i:book)
        {
            len+=i;
        }
        return len;
    }

    private int[] getCnt(String s) {
        int[] book=new int[26];
        for (char c:s.toCharArray())
        {
            book[c-'a']++;
            if(book[c-'a']>1)return null;
        }
        return book;
    }
}
/*
给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。

请返回所有可行解 s 中最长长度。



示例 1：

输入：arr = ["un","iq","ue"]
输出：4
解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
示例 2：

输入：arr = ["cha","r","act","ers"]
输出：6
解释：可能的解答有 "chaers" 和 "acters"。
示例 3：

输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
输出：26


提示：

1 <= arr.length <= 16
1 <= arr[i].length <= 26
arr[i] 中只含有小写英文字母
 */
