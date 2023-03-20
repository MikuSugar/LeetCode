package JavaCode.random_records.N2201_N2400

object N2278_percentage_of_letter_in_string {
  def percentageLetter(s: String, letter: Char): Int = {
    s.count(_ == letter) * 100 / s.length
  }
}

/*
2278. 字母在字符串中的百分比
给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。



示例 1：

输入：s = "foobar", letter = "o"
输出：33
解释：
等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。
示例 2：

输入：s = "jjjj", letter = "k"
输出：0
解释：
等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。

 */
