package JavaCode.contest.weekly.n201_300.n291;

/**
 * @author mikusugar
 */
//TODO TimeOut
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().appealSum("abbca"));
    }

    public long appealSum(String s) {
        long res = 0;
        final char[] strs = s.toCharArray();
        int[][] preSum = new int[26][s.length() + 1];

        //预处理
        for (int i = 0; i < strs.length; i++) {
            for (int k = 0; k < 26; k++) {
                preSum[k][i + 1] = preSum[k][i];
            }
            preSum[strs[i] - 'a'][i + 1]++;
        }

        for (int i = 0; i < strs.length; i++) {
            int k = strs.length - i - 1;
            long last = -1;
            while (true) {
                long t = 0L;
                if (last==-1) {
                    for (int j = 0; j < 26; j++) {
                        t += (preSum[j][i + 1 + k] - preSum[j][i]) > 0 ? 1 : 0;
                    }
                } else {
                    if (preSum[strs[i + k + 1] - 'a'][i + 2 + k] - preSum[strs[i + k + 1] - 'a'][i + k+1] == 1 &&
                            preSum[strs[i + k + 1] - 'a'][i + k+1] - preSum[strs[i + k + 1] - 'a'][i] == 0) {
                        last--;
                    }
                    t = last;
                }
                last=t;
                if (t == k + 1) {
                    res += (t + 1) * t / 2;
                    break;
                } else {
                    res += t;
                    k--;
                }
            }

        }
        return res;
    }
}
/*
字符串的 引力 定义为：字符串中 不同 字符的数量。

例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
给你一个字符串 s ，返回 其所有子字符串的总引力 。

子字符串 定义为：字符串中的一个连续字符序列。



示例 1：

输入：s = "abbca"
输出：28
解释："abbca" 的子字符串有：
- 长度为 1 的子字符串："a"、"b"、"b"、"c"、"a" 的引力分别为 1、1、1、1、1，总和为 5 。
- 长度为 2 的子字符串："ab"、"bb"、"bc"、"ca" 的引力分别为 2、1、2、2 ，总和为 7 。
- 长度为 3 的子字符串："abb"、"bbc"、"bca" 的引力分别为 2、2、3 ，总和为 7 。
- 长度为 4 的子字符串："abbc"、"bbca" 的引力分别为 3、3 ，总和为 6 。
- 长度为 5 的子字符串："abbca" 的引力为 3 ，总和为 3 。
引力总和为 5 + 7 + 7 + 6 + 3 = 28 。
示例 2：

输入：s = "code"
输出：20
解释："code" 的子字符串有：
- 长度为 1 的子字符串："c"、"o"、"d"、"e" 的引力分别为 1、1、1、1 ，总和为 4 。
- 长度为 2 的子字符串："co"、"od"、"de" 的引力分别为 2、2、2 ，总和为 6 。
- 长度为 3 的子字符串："cod"、"ode" 的引力分别为 3、3 ，总和为 6 。
- 长度为 4 的子字符串："code" 的引力为 4 ，总和为 4 。
引力总和为 4 + 6 + 6 + 4 = 20 。


提示：

1 <= s.length <= 105
s 由小写英文字母组成
 */
