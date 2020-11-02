package JavaCode.contest.weekly.n0_200.n139;

public class N1 {

    public String gcdOfStrings(String str1, String str2) {
        String max,min;
        if(str1.length()>str2.length())
        {
            max=str1;
            min=str2;
        }
        else
        {
            max=str2;
            min=str1;
        }
        String res;
        int l=max.length();
        int s=min.length();
        for (int len=min.length();len>0;len--)
        {
            if(l%len==0&&s%len==0)
            {
                boolean falg=true;
                String t=min.substring(0,len);
                for (int i=0;i<l;i+=len)
                {
                    if(!t.equals(max.substring(i,i+len)))
                    {
                        falg=false;
                        break;
                    }
                }
                if(!falg)continue;
                for (int i=0;i<s;i+=len)
                {
                    if(!t.equals(min.substring(i,i+len)))
                    {
                        falg=false;
                        break;
                    }
                }
                if(falg) return t;
            }
        }
        return "";
    }
}
/**
 *对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 *
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 *
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *
 *
 * 提示：
 *
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
