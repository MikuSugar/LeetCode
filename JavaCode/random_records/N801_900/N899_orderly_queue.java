package JavaCode.random_records.N801_900;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/31
 */
public class N899_orderly_queue {
    public String orderlyQueue(String S, int K) {
        String res=S;
        if (K==1)
        {
            for (int i=0;i<S.length();i++)
            {
                String cur=S.substring(i)+S.substring(0,i);
                if(cur.compareTo(res)<0)res=cur;
            }
        }
        else
        {
            char[] s=S.toCharArray();
            Arrays.sort(s);
            res=new String(s);
        }
        return res;
    }
}
/*
给出了一个由小写字母组成的字符串 S。然后，我们可以进行任意次数的移动。

在每次移动中，我们选择前 K 个字母中的一个（从左侧开始），将其从原位置移除，并放置在字符串的末尾。

返回我们在任意次数的移动之后可以拥有的按字典顺序排列的最小字符串。

 

示例 1：

输入：S = "cba", K = 1
输出："acb"
解释：
在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
示例 2：

输入：S = "baaca", K = 3
输出："aaabc"
解释：
在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
 

提示：

1 <= K <= S.length <= 1000
S 只由小写字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/orderly-queue
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
