use std::cmp;

pub fn reverse_str(s: String, k: i32) -> String {
    let chars: Vec<char> = s.chars().collect();
    let mut res = String::new();
    let mut cnt = 0;
    let mut i: usize = 0;
    let len = chars.len();
    let k = k as usize;
    while i < len {
        if cnt % 2 == 0 {
            for k in (i..cmp::min(i + k, len)).rev() {
                res.push(chars[k]);
            }
        } else {
            for k in i..cmp::min(i + k, len) {
                res.push(chars[k]);
            }
        }
        cnt += 1;
        i += k;
    }
    res
}
/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


示例 1：

输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：

输入：s = "abcd", k = 2
输出："bacd"


提示：

1 <= s.length <= 104
s 仅由小写英文组成
1 <= k <= 104

https://leetcode.cn/problems/reverse-string-ii/description/?envType=daily-question&envId=2025-01-31
 */
