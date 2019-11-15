package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/11/15
 */
public class N906_super_palindromes {
    public int superpalindromesInRange(String L, String R) {
        long l=Long.parseLong(L);
        long r=Long.parseLong(R);
        int res=0;
        for (long i=(long) Math.sqrt(l);i*i<=r;)
        {
            long cur=getCur(i);
            if(cur*cur<r&&isP(cur*cur))res++;
            i=cur+1;
        }
        return res;
    }

    private boolean isP(long l) {
        char[] s=String.valueOf(l).toCharArray();
        int i=0,j=s.length-1;
        while (i<j)
        {
            if(s[i++]!=s[j--])return false;
        }
        return true;
    }

    private long getCur(long num) {
        String s=String.valueOf(num);
        String half=s.substring(0,(s.length()+1)/2);
        long res=Long.parseLong(half+new StringBuilder(half.substring(0,s.length()/2)).reverse().toString());
        if(res>=num)return res;
        half=String.valueOf(Long.parseLong(half)+1);
        res=Long.parseLong(half+new StringBuilder(half.substring(0,s.length()/2)).reverse().toString());
        return res;
    }
}
/*
如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。

现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。

 

示例：

输入：L = "4", R = "1000"
输出：4
解释：
4，9，121，以及 484 是超级回文数。
注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
 

提示：

1 <= len(L) <= 18
1 <= len(R) <= 18
L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
int(L) <= int(R)
 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/super-palindromes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */