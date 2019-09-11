package JavaCode.random_records.N801_900;


import java.util.*;

public class N854_k_similar_strings {

    public int kSimilarity(String A, String B) {
        char[] a=A.toCharArray();
        char[] b=B.toCharArray();
        final long tar=getKey(b);
        final long start=getKey(a);
        return slove(0,start,tar,a,b,new HashMap<>());
    }

    private int slove(int idx, long cur, final long tar, final char[] a, final char[] b, final Map<Long, Integer> map) {
        if(cur==tar)return 0;
        if(idx==a.length)return Integer.MAX_VALUE>>1;
        if(map.containsKey(cur))return map.get(cur);
        int res=Integer.MAX_VALUE>>1;
        if(a[idx]==b[idx]) res=slove(idx+1,cur,tar,a,b,map);
        else
        {
            for (int i=idx+1;i<a.length;i++)
            {
                if(a[i]==b[idx]&&a[idx]!=b[idx])
                {
                    long next=help(cur, a, idx, i);
                    res=Math.min(res,1+slove(idx+1,next,tar,a,b,map));
                    swap(a,idx,i);
                }
            }
        }
        map.put(cur,res);
        return res;
    }

    private long getKey(long start, int idx, char c, int length) {
        long res=0;
        int len=(length-idx-1)*3;
        res|=(c-'a');
        res<<=len;
        long r=start<<(64-len)>>>(64-len);
        if(idx==length-1)r=0l;
        long l=start>>(len+3)<<(len+3);
        res|=r;
        res|=l;
        return res;
    }

    private long help(long start, char[] a, int idx, int j) {
        long res=getKey(start,idx,a[j],a.length);
        res=getKey(res,j,a[idx],a.length);
        swap(a, idx, j);
        return res;
    }

    private void swap(char[] a, int idx, int j) {
        char c=a[idx];
        a[idx]=a[j];
        a[j]=c;
    }

    private long getKey(char[] s) {
        long res=0;
        for (int i=0;i<s.length;i++)
        {
            res|=(s[i]-'a');
            res<<=3;
        }
        res>>>=3;
        return res;
    }
}
/**
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 *
 * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = "ab", B = "ba"
 * 输出：1
 * 示例 2：
 *
 * 输入：A = "abc", B = "bca"
 * 输出：2
 * 示例 3：
 *
 * 输入：A = "abac", B = "baca"
 * 输出：2
 * 示例 4：
 *
 * 输入：A = "aabc", B = "abca"
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= A.length == B.length <= 20
 * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-similar-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
