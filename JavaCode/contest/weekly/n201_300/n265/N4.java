package JavaCode.contest.weekly.n201_300.n265;

import java.util.*;

/**
 * @author mikusugar
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().possiblyEquals(
                "v375v736v443v897v633v527v781v121v317",
                "475v899v753v784v438v415v431v216v968"
        ));
    }
    private char[] book = new char[20000];
    public boolean possiblyEquals(String s1, String s2) {
        Arrays.fill(book,'@');
        List<String> strs1 = getAll(s1,true);
        List<String> strs2 = getAll(s2,false);

        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs1) {
            if (!map.containsKey(s.length())) {
                map.put(s.length(), new ArrayList<>());
            }
            map.get(s.length()).add(s);
        }
        for (String s : strs2) {
            if (!map.containsKey(s.length())) continue;
            for (String ss : map.get(s.length())) {
                if (cmp(s, ss)) return true;
            }
        }
        return false;

    }

    private boolean cmp(String s, String ss) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || ss.charAt(i) == '*') continue;
            if (s.charAt(i) != ss.charAt(i)) return false;
        }
        return true;
    }

    private List<String> getAll(String str,boolean ok) {
        StringBuilder sb = new StringBuilder();
        char[] strs = str.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(strs, 0, sb, res,ok);
        return res;
    }


    private void dfs(char[] strs, int idx, StringBuilder sb, List<String> res,boolean ok) {
        if (idx >= strs.length) {
            res.add(sb.toString());
            return;
        }
        if (isNum(strs[idx])) {
            int num = strs[idx] - '0';
            addChar(num, sb, '*',ok);
            dfs(strs, idx + 1, sb, res,ok);
            rmChar(num, sb);
            if (idx + 1 < strs.length && isNum(strs[idx + 1])) {
                num = Integer.parseInt(strs[idx] + "" + strs[idx + 1]);
                addChar(num, sb, '*',ok);
                dfs(strs, idx + 2, sb, res,ok);
                rmChar(num, sb);
                if (idx + 2 < strs.length && isNum(strs[idx + 2])) {
                    num = Integer.parseInt(strs[idx] + "" + strs[idx + 1] + "" + strs[idx + 2]);
                    addChar(num, sb, '*',ok);
                    dfs(strs, idx + 3, sb, res,ok);
                    rmChar(num, sb);
                }
            }
        } else {
            sb.append(strs[idx]);
            if(ok){
                if(book[sb.length()-1]!='*')book[sb.length()-1]=strs[idx];
            }
            else {
                if(book[sb.length()-1]!='*'||book[sb.length()-1]=='@'){
                    rmChar(1, sb);
                    System.out.println("**");
                    return;
                }
            }
            dfs(strs, idx + 1, sb, res,ok);
            rmChar(1, sb);
        }
    }

    private void rmChar(int num, StringBuilder sb) {
        while (num-- > 0) sb.deleteCharAt(sb.length()-1);
    }

    private void addChar(int num, StringBuilder sb, char c,boolean ok) {
        while (num-- > 0) {
            sb.append(c);
            if(ok)book[sb.length()-1]='*';
        }
    }


    private boolean isNum(char str) {
        return str >= '0' && str <= '9';
    }
}
/*
原字符串由小写字母组成，可以按下述步骤编码：

任意将其 分割 为由若干 非空 子字符串组成的一个 序列 。
任意选择序列中的一些元素（也可能不选择），然后将这些元素替换为元素各自的长度（作为一个数字型的字符串）。
重新 顺次连接 序列，得到编码后的字符串。
例如，编码 "abcdefghijklmnop" 的一种方法可以描述为：

将原字符串分割得到一个序列：["ab", "cdefghijklmn", "o", "p"] 。
选出其中第二个和第三个元素并分别替换为它们自身的长度。序列变为 ["ab", "12", "1", "p"] 。
重新顺次连接序列中的元素，得到编码后的字符串："ab121p" 。
给你两个编码后的字符串 s1 和 s2 ，由小写英文字母和数字 1-9 组成。如果存在能够同时编码得到 s1 和 s2 原字符串，返回 true ；否则，返回 false。

注意：生成的测试用例满足 s1 和 s2 中连续数字数不超过 3 。



示例 1：

输入：s1 = "internationalization", s2 = "i18n"
输出：true
解释："internationalization" 可以作为原字符串
- "internationalization"
  -> 分割：      ["internationalization"]
  -> 不替换任何元素
  -> 连接：      "internationalization"，得到 s1
- "internationalization"
  -> 分割：      ["i", "nternationalizatio", "n"]
  -> 替换：      ["i", "18",                 "n"]
  -> 连接：      "i18n"，得到 s2
示例 2：

输入：s1 = "l123e", s2 = "44"
输出：true
解释："leetcode" 可以作为原字符串
- "leetcode"
  -> 分割：       ["l", "e", "et", "cod", "e"]
  -> 替换：       ["l", "1", "2",  "3",   "e"]
  -> 连接：       "l123e"，得到 s1
- "leetcode"
  -> 分割：       ["leet", "code"]
  -> 替换：       ["4",    "4"]
  -> 连接：       "44"，得到 s2
示例 3：

输入：s1 = "a5b", s2 = "c5b"
输出：false
解释：不存在这样的原字符串
- 编码为 s1 的字符串必须以字母 'a' 开头
- 编码为 s2 的字符串必须以字母 'c' 开头
示例 4：

输入：s1 = "112s", s2 = "g841"
输出：true
解释："gaaaaaaaaaaaas" 可以作为原字符串
- "gaaaaaaaaaaaas"
  -> 分割：       ["g", "aaaaaaaaaaaa", "s"]
  -> 替换：       ["1", "12",           "s"]
  -> 连接：       "112s"，得到 s1
- "gaaaaaaaaaaaas"
  -> 分割：       ["g", "aaaaaaaa", "aaaa", "s"]
  -> 替换：       ["g", "8",        "4",    "1"]
  -> 连接         "g841"，得到 s2
示例 5：

输入：s1 = "ab", s2 = "a2"
输出：false
解释：不存在这样的原字符串
- 编码为 s1 的字符串由两个字母组成
- 编码为 s2 的字符串由三个字母组成


提示：

1 <= s1.length, s2.length <= 40
s1 和 s2 仅由数字 1-9 和小写英文字母组成
s1 和 s2 中连续数字数不超过 3

 */
