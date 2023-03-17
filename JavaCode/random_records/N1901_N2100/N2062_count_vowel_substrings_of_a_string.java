package JavaCode.random_records.N1901_N2100;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/17 14:50
 */
public class N2062_count_vowel_substrings_of_a_string {

    public static void main(String[] args) {
        System.out.println(new N2062_count_vowel_substrings_of_a_string().countVowelSubstrings("aeiouu"));
    }

    private final static char[] m = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int countVowelSubstrings(String word) {
        final int[][] books = new int[m.length][word.length() + 1];
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            int idx = getIdx(cur);
            if (idx != -1) {
                books[idx][i + 1]++;
            }
            for (int k = 0; k < m.length; k++) {
                books[k][i + 1] += books[k][i];
            }
        }

        int res = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + m.length - 1; j < word.length(); j++) {
                if (checkOnlyM(i, j, books)) {
                    if (check(i, j, books)) {
                        res++;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }

    private boolean check(int i, int j, int[][] books) {
        for (int[] book : books) {
            if (book[j + 1] - book[i] <= 0) return false;
        }
        return true;
    }

    private boolean checkOnlyM(int i, int j, int[][] books) {
        int sum = 0;
        for (int[] book : books) {
            sum += book[j + 1] - book[i];
        }
        return sum == j - i + 1;
    }

    private int getIdx(char cur) {
        for (int i = 0; i < m.length; i++) {
            if (cur == m[i]) {
                return i;
            }
        }
        return -1;
    }
}
/**
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * <p>
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 * <p>
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aeiouu"
 * 输出：2
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "aeiouu"
 * - "aeiouu"
 * 示例 2：
 * <p>
 * 输入：word = "unicornarihan"
 * 输出：0
 * 解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
 * 示例 3：
 * <p>
 * 输入：word = "cuaieuouac"
 * 输出：7
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * 示例 4：
 * <p>
 * 输入：word = "bbaeixoubb"
 * 输出：0
 * 解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 100
 * word 仅由小写英文字母组成
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-vowel-substrings-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
