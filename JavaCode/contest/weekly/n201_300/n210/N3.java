package JavaCode.contest.weekly.n201_300.n210;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/10/11 10:40 上午
 */
public class N3 {
    public static void main(String[] args) {
        System.out.println(new N3().checkPalindromeFormation(
                "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd",
                "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }
    public boolean checkPalindromeFormation(String a, String b) {
        if(a.length()==1)return true;
        char[] strs1=a.toCharArray();
        char[] strs2=b.toCharArray();
        return check(strs1,strs2)||check(strs2,strs1);
    }
    private boolean check(char[] strs1, char[] strs2) {
        boolean flag=false;
        boolean pre=true;
        boolean last=true;
        int cur=0;
        while (cur<=strs1.length/2-1)
        {
            if(!flag&&strs1[cur]==strs2[strs1.length-cur-1])cur++;
            else
            {
                flag=true;
                if(pre&&strs2[cur]==strs2[strs1.length-cur-1])cur++;
                else pre=false;
                if(last&&strs1[cur]==strs1[strs1.length-cur-1])cur++;
                else last=false;
                if(!pre&&!last) return false;
            }
        }
        return true;
    }
}
/*
给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。

当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。

如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。

请注意， x + y 表示连接字符串 x 和 y 。



示例 1：

输入：a = "x", b = "y"
输出：true
解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
aprefix = "", asuffix = "x"
bprefix = "", bsuffix = "y"
那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
示例 2：

输入：a = "abdef", b = "fecab"
输出：false
示例 3：

输入：a = "ulacfd", b = "jizalu"
输出：true
解释：在下标为 3 处分割：
aprefix = "ula", asuffix = "cfd"
bprefix = "jiz", bsuffix = "alu"
那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。


提示：

1 <= a.length, b.length <= 105
a.length == b.length
a 和 b 都只包含小写英文字母
 */
