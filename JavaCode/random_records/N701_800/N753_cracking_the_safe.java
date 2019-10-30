package JavaCode.random_records.N701_800;

import java.util.HashSet;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/10/30
 */
public class N753_cracking_the_safe {
    public String crackSafe(int n, int k) {
        if(n*k==1)return "0";
        Set<String> set=new HashSet<>();
        StringBuilder res=new StringBuilder();

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<n-1;i++)sb.append('0');
        String start=sb.toString();

        dfs(start,k,set,res);
        res.append(start);
        return res.toString();
    }

    private void dfs(String start, int k, Set<String> set, StringBuilder res) {
        for (int x=0;x<k;x++)
        {
            String cur=start+x;
            if(set.contains(cur))continue;
            set.add(cur);
            dfs(cur.substring(1),k,set,res);
            res.append(x);
        }
    }
}
/*
有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。

你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。

举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符.

请返回一个能打开保险箱的最短字符串。

 

示例1:

输入: n = 1, k = 2
输出: "01"
说明: "10"也可以打开保险箱。
 

示例2:

输入: n = 2, k = 2
输出: "00110"
说明: "01100", "10011", "11001" 也能打开保险箱。
 

提示：

n 的范围是 [1, 4]。
k 的范围是 [1, 10]。
k^n 最大可能为 4096。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cracking-the-safe
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
