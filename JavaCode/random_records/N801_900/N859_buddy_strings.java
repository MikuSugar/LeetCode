package JavaCode.random_records.N801_900;

public class N859_buddy_strings {
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length()||A.length()<2)return false;
        int[] book=new int[26];
        if(A.equals(B))
        {
            for (char c:A.toCharArray())
            {
                book[c-'a']++;
                if(book[c-'a']>1)return true;
            }
            return false;
        }
        char[] a = A.toCharArray();
        char[] b=B.toCharArray();
        for (char c: a)
        {
            book[c-'a']++;
        }
        for (char c:b)
        {
            book[c-'a']--;
        }
        for (int i:book)
        {
            if(i!=0)return false;
        }
        int cnt=0;
        for (int i=0;i<a.length;i++)
        {
            if(a[i]!=b[i])
            {
                cnt++;
                if(cnt>2)return false;
            }
        }
        return true;
    }
}
/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 示例 1：
 *
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 *
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 *
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 *
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 *
 * 输入： A = "", B = "aa"
 * 输出： false
 *  
 *
 * 提示：
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
