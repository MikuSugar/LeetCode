package JavaCode.random_records.N101_200;

public class N168_excel_sheet_column_title {
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while (n>0)
        {
            int x=n%26;
            if(x==0) {
                n=n-26;
                sb.append('Z');
            }
            else sb.append((char) ('A'+x-1));
            n/=26;
        }
        return sb.reverse().toString();
    }
}
/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-title
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
