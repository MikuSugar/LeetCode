package JavaCode.contest.n136;

import java.util.HashMap;
import java.util.Map;

public class N4 {

    private final static int MOD=(int) 1e9+7;
    private final static int R=26;
    public String longestDupSubstring(String S) {
        int left=0;
        int right=S.length()-1;
        String res="";
        while (left<right)
        {
            int len=(int) Math.ceil((left*1.0+right)/2);
            String temp=getOverlapping(S,len);
            if(temp.isEmpty())
            {
                right=len-1;
            }
            else
            {
                left=len;
                res=temp;
            }
        }
        return res;
    }

    private String getOverlapping(String s, int len) {
        long RM=1l;
        for (int i=1;i<len;i++)
        {
            RM=(RM*R)%MOD;
        }
        Map<Integer,Integer> map=new HashMap<>();
        long hash=0l;
        for (int i=0;i<len;i++)
        {
            hash=(hash*R+s.charAt(i)-97)%MOD;
        }
        map.put((int)hash,0);
        for (int i=0;i<s.length()-len;i++)
        {
            int pre_code=s.charAt(i)-97;
            int cur_code=s.charAt(i+len)-97;
            hash=(hash+MOD-(pre_code*RM%MOD))%MOD;
            hash=(hash*R+cur_code)%MOD;
            if(map.containsKey((int)hash))
            {
                String temp=s.substring(i+1,i+1+len);
                int index=map.get((int)hash);
                String pre=s.substring(index,index+len);
                if(pre.equals(temp))return pre;
            }
            map.put((int)hash,i+1);
        }
        return "";
    }
}
/**
 * 5058. 最长重复子串  显示英文描述
 * 用户通过次数 7
 * 用户尝试次数 70
 * 通过次数 7
 * 提交次数 201
 * 题目难度 Hard
 * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
 * 示例 1：
 * 输入："banana"
 * 输出："ana"
 * 示例 2：
 * 输入："abcd"
 * 输出：""
 * 提示：
 * 2 <= S.length <= 10^5
 * S 由小写英文字母组成。
 */
