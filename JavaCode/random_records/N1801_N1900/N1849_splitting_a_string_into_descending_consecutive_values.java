package JavaCode.random_records.N1801_N1900;

public class N1849_splitting_a_string_into_descending_consecutive_values {

    //TODO 半夜辣鸡代码，虽AC，但需修改
    public static void main(String[] args) {
        System.out.println(new N1849_splitting_a_string_into_descending_consecutive_values().splitString("94650723337775781477"));
    }

    public boolean splitString(String s) {
        for (int i = 1; i < s.length(); i++) {
            long pre;
            try {
                pre = Long.parseLong(s.substring(0, i));
            } catch (Exception e) {
                continue;
            }
            if (slove(i, s, pre)) return true;
        }
        return false;
    }

    private boolean slove(int idx, String str, long pre) {
        if (idx >= str.length()) return true;
        long next = pre - 1;
        for (int i = idx + String.valueOf(next).length(); i <= str.length(); i++) {
            try {
                if (next == Long.parseLong(str.substring(idx, i))) {
                    if (slove(i, str, next)) return true;
                }
            } catch (Exception e) {
                break;
            }
        }
        return false;
    }
}
/*
给你一个仅由数字组成的字符串 s 。

请你判断能否将 s 拆分成两个或者多个 非空子字符串 ，使子字符串的 数值 按 降序 排列，且每两个 相邻子字符串 的数值之 差 等于 1 。

例如，字符串 s = "0090089" 可以拆分成 ["0090", "089"] ，数值为 [90,89] 。这些数值满足按降序排列，且相邻值相差 1 ，这种拆分方法可行。
另一个例子中，字符串 s = "001" 可以拆分成 ["0", "01"]、["00", "1"] 或 ["0", "0", "1"] 。然而，所有这些拆分方法都不可行，因为对应数值分别是 [0,1]、[0,1] 和 [0,0,1] ，都不满足按降序排列的要求。
如果可以按要求拆分 s ，返回 true ；否则，返回 false 。

子字符串 是字符串中的一个连续字符序列。

 

示例 1：

输入：s = "1234"
输出：false
解释：不存在拆分 s 的可行方法。
示例 2：

输入：s = "050043"
输出：true
解释：s 可以拆分为 ["05", "004", "3"] ，对应数值为 [5,4,3] 。
满足按降序排列，且相邻值相差 1 。
示例 3：

输入：s = "9080701"
输出：false
解释：不存在拆分 s 的可行方法。
示例 4：

输入：s = "10009998"
输出：true
解释：s 可以拆分为 ["100", "099", "98"] ，对应数值为 [100,99,98] 。
满足按降序排列，且相邻值相差 1 。
 

提示：

1 <= s.length <= 20
s 仅由数字组成


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
