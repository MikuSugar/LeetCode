package JavaCode.random_records.N901_1000;

/**
 * author:fangjie
 * time:2019/10/29
 */
public class N942_di_string_match {
    public int[] diStringMatch(String S) {
        int max=S.length(),min=0;
        int[] res=new int[S.length()+1];
        int idx=0;
        for(char c:S.toCharArray())
        {
            if(c=='D')res[idx++]=max--;
            else res[idx++]=min++;
        }
        res[idx]=min;
        return res;
    }
}
/*
给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。

返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：

如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]
 

示例 1：

输出："IDID"
输出：[0,4,1,3,2]
示例 2：

输出："III"
输出：[0,1,2,3]
示例 3：

输出："DDI"
输出：[3,2,0,1]
 

提示：

1 <= S.length <= 1000
S 只包含字符 "I" 或 "D"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-string-match
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
