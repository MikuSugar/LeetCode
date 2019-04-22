package JavaCode.contest.spring_2019_02;

public class N2 {

    public static void main(String[] args) {
        System.out.println(new N2().smallestEquivalentString("parker","morris","parser"));
    }

    public String smallestEquivalentString(String A, String B, String S) {
        return null;
    }
}
/**
 *2. 按字典序排列最小的等效字符串  显示英文描述
 * 用户通过次数 1
 * 用户尝试次数 2
 * 通过次数 1
 * 提交次数 2
 * 题目难度 Medium
 * 给出长度相同的两个字符串：A 和 B，其中 A[i] 和 B[i] 是一组等价字符。举个例子，如果 A = "abc" 且 B = "cde"，那么就有 'a' == 'c', 'b' == 'd', 'c' == 'e'。
 *
 * 等价字符遵循任何等价关系的一般规则：
 *
 * 自反性：'a' == 'a'
 * 对称性：'a' == 'b' 则必定有 'b' == 'a'
 * 传递性：'a' == 'b' 且 'b' == 'c' 就表明 'a' == 'c'
 * 例如，A 和 B 的等价信息和之前的例子一样，那么 S = "eed", "acd" 或 "aab"，这三个字符串都是等价的，而 "aab" 是 S 的按字典序最小的等价字符串
 *
 * 利用 A 和 B 的等价信息，找出并返回 S 的按字典序排列最小的等价字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = "parker", B = "morris", S = "parser"
 * 输出："makkek"
 * 解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [m,p], [a,o], [k,r,s], [e,i] 共 4 组。每组中的字符都是等价的，并按字典序排列。所以答案是 "makkek"。
 * 示例 2：
 *
 * 输入：A = "hello", B = "world", S = "hold"
 * 输出："hdld"
 * 解释：根据 A 和 B 中的等价信息，我们可以将这些字符分为 [h,w], [d,e,o], [l,r] 共 3 组。所以只有 S 中的第二个字符 'o' 变成 'd'，最后答案为 "hdld"。
 * 示例 3：
 *
 * 输入：A = "leetcode", B = "programs", S = "sourcecode"
 * 输出："aauaaaaada"
 * 解释：我们可以把 A 和 B 中的等价字符分为 [a,o,e,r,s,c], [l,p], [g,t] 和 [d,m] 共 4 组，因此 S 中除了 'u' 和 'd' 之外的所有字母都转化成了 'a'，最后答案为 "aauaaaaada"。
 *
 *
 * 提示：
 *
 * 字符串 A，B 和 S 仅有从 'a' 到 'z' 的小写英文字母组成。
 * 字符串 A，B 和 S 的长度在 1 到 1000 之间。
 * 字符串 A 和 B 长度相同。
 * 本场比赛距离结束剩余 1 小时 20 分 55 秒
 * 题目列表（共 4 题）
 * 得分
 * 有序数组中的缺失元素
 * 5
 * 按字典序排列最小的等效字符串
 * 6
 * 最长重复子串
 * 6
 * 有效子数组的数目
 * 7
 * 重要提示
 * 1. 请注意，每个错误提交的惩罚时间为 5 分钟，请谨慎提交解答
 *
 * 2. 所有解答提交都会自动经过我们严格智能的作弊侦测系统。 如被检查出抄袭、作弊等行为，将会直接导致 参赛资格被取消 以及 至少三周的账号冻结 。 力扣一向非常重视竞赛的公平，为了保障每一位用户的权益，我们会坚持以 零容忍 的态度维护竞赛的公平、公正。
 *
 * 显示列表
 */
