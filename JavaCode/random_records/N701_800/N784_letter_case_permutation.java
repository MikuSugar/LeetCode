package JavaCode.random_records.N701_800;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/9/19
 */
public class N784_letter_case_permutation {
    public List<String> letterCasePermutation(String S) {
        List<String> res=new ArrayList<>();
        char[] strs=S.toCharArray();
        slove(0,strs,res);
        return res;
    }

    private void slove(int idx, char[] strs, List<String> res) {
        while (idx<strs.length&&Character.isDigit(strs[idx]))idx++;
        if(idx==strs.length)
        {
            res.add(new String(strs));
            return;
        }
        slove(idx+1,strs,res);
        swap(idx,strs);
        slove(idx+1,strs,res);
    }

    private void swap(int idx, char[] strs) {
        if(Character.isUpperCase(strs[idx]))strs[idx]=Character.toLowerCase(strs[idx]);
        else strs[idx]=Character.toUpperCase(strs[idx]);
    }
}
/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-case-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
