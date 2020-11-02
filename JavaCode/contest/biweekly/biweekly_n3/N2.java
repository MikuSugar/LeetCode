package JavaCode.contest.biweekly.biweekly_n3;

public class N2 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if(K>S.length())return 0;
        char[] s = S.toCharArray();
        int[] book=new int[26];
        for (int i=0;i<K;i++)
        {
            book[s[i]-'a']++;
        }
        int res=check(book)?1:0;
        for (int i=K;i<s.length;i++)
        {
            book[s[i-K]-'a']--;
            book[s[i]-'a']++;
            res+=check(book)?1:0;
        }
        return res;
    }

    private boolean check(int[] book) {
        for (int i:book)
        {
            if(i>1)return false;
        }
        return true;
    }
}
/**
 *给你一个字符串 S，找出所有长度为 K 且不含重复字符的子串，请你返回全部满足要求的子串的 数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "havefunonleetcode", K = 5
 * 输出：6
 * 解释：
 * 这里有 6 个满足题意的子串，分别是：'havef','avefu','vefun','efuno','etcod','tcode'。
 * 示例 2：
 *
 * 输入：S = "home", K = 5
 * 输出：0
 * 解释：
 * 注意：K 可能会大于 S 的长度。在这种情况下，就无法找到任何长度为 K 的子串。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 10^4
 * S 中的所有字符均为小写英文字母
 * 1 <= K <= 10^4
 */
