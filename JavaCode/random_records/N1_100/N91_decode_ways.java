package JavaCode.random_records.N1_100;

import java.util.HashMap;
import java.util.Map;

public class N91_decode_ways {

    private Map<String,Integer> map=new HashMap<>();
    public int numDecodings(String s) {
        if(s==null|s.isEmpty())return 1;
        if(s.charAt(0)=='0')return 0;
        if(s.length()==1)return 1;
        if(map.containsKey(s))return map.get(s);
        int res=0;
        if(Integer.parseInt(s.substring(0,2))>26)
        {
            res=numDecodings(s.substring(1));
        }
        else
        {
            res=numDecodings(s.substring(1))+numDecodings(s.substring(2));
        }
        map.put(s,res);
        return res;
    }
}
/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
