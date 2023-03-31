package JavaCode.random_records.N2201_N2400;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/29 17:13
 * @description N2288_apply_discount_to_prices
 */
public class N2288_apply_discount_to_prices {

    public static void main(String[] args) {
        System.out.println(new N2288_apply_discount_to_prices().discountPrices(
                "there are $1 $2 and 5$ candies in the shop", 50
        ));
        //1 2 $3 4 $5 $6 7 8$ $9 $10$
        System.out.println(new N2288_apply_discount_to_prices().discountPrices(
                "1 2 $3 4 $5 $6 7 8$ $9 $10$", 100
        ));
        //"$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999"
        //0
        System.out.println(new N2288_apply_discount_to_prices().discountPrices(
                "$2$3 $10 $100 $1 200 $33 33$ $$ $99 $99999 $9999999999", 0
        ));
    }

    public String discountPrices(String sentence, int discount) {
        StringBuilder res = new StringBuilder();
        int idx = 0;
        while (idx < sentence.length()) {
            final char cur = sentence.charAt(idx);
            res.append(cur);
            if (cur == '$' && (idx == 0 || sentence.charAt(idx - 1) == ' ')) {
                String number = getNumber(idx, sentence);
                if (!number.isEmpty()) {
                    double n = Double.parseDouble(number);
                    n = n - n * discount / 100;
                    final String newNumber = String.format("%.2f", n);
                    res.append(newNumber);
                    idx += number.length();
                }
            }
            idx++;
        }
        return res.toString();
    }

    private String getNumber(int idx, String sentence) {
        boolean isPoint = false;
        StringBuilder res = new StringBuilder();
        for (int i = idx + 1; i < sentence.length(); i++) {
            final char cur = sentence.charAt(i);
            if (Character.isDigit(cur)) {
                res.append(cur);
            } else if (cur == '.' && !isPoint) {
                isPoint = true;
                res.append(cur);
            } else if (cur == ' ' || cur == sentence.length() - 1) {
                break;
            } else {
                return "";
            }
        }
        return res.toString();
    }
}
/*
句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。

例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
注意：本题输入中的价格均为整数。

给你一个字符串 sentence  和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。

返回表示修改后句子的字符串。

 

示例 1：

输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
输出："there are $0.50 $1.00 and 5$ candies in the shop"
解释：
表示价格的单词是 "$1" 和 "$2" 。
- "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
- "$2" 减免 50% 为 "$1" ，所以 "$2" 替换为 "$1.00" 。
示例 2：

输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
解释：
任何价格减免 100% 都会得到 0 。
表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
每个单词都替换为 "$0.00"。
 

提示：

1 <= sentence.length <= 105
sentence 由小写英文字母、数字、' ' 和 '$' 组成
sentence 不含前导和尾随空格
sentence 的所有单词都用单个空格分隔
所有价格都是 正 整数且不含前导零
所有价格 最多 为  10 位数字
0 <= discount <= 100

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/apply-discount-to-prices
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
