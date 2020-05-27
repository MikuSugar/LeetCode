package JavaCode.random_records.N1401_1500;

/**
 * @Author: fangjie
 * @Date: 2020/5/27 10:06 下午
 */
public class N1456_maximum_number_of_vowels_in_a_substring_of_given_length {
    public int maxVowels(String s, int k) {
        char[] strs=s.toCharArray();
        int res=0;
        for (int i=0;i<k;i++)
        {
            if(check(strs[i]))res++;
        }
        int cur=res;

        for (int i=k;i<strs.length;i++)
        {
            if(check(strs[i]))cur++;
            if(check(strs[i-k]))cur--;
            res=Math.max(res,cur);
        }
        return res;
    }
    private final char[] VOWELS={'a', 'e', 'i', 'o', 'u'};
    private boolean check(char c){
        for (char t:VOWELS)if(c==t)return true;
        return false;
    }
}
/*
给你字符串 s 和整数 k 。

请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

英文中的 元音字母 为（a, e, i, o, u）。

 

示例 1：

输入：s = "abciiidef", k = 3
输出：3
解释：子字符串 "iii" 包含 3 个元音字母。
示例 2：

输入：s = "aeiou", k = 2
输出：2
解释：任意长度为 2 的子字符串都包含 2 个元音字母。
示例 3：

输入：s = "leetcode", k = 3
输出：2
解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
示例 4：

输入：s = "rhythms", k = 4
输出：0
解释：字符串 s 中不含任何元音字母。
示例 5：

输入：s = "tryhard", k = 4
输出：1
 

提示：

1 <= s.length <= 10^5
s 由小写英文字母组成
1 <= k <= s.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
