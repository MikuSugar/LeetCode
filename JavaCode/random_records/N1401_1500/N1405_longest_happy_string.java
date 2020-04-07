package JavaCode.random_records.N1401_1500;


/**
 * author:fangjie
 * time:2020/4/7
 */
public class N1405_longest_happy_string {
    public static void main(String[] args) {
        System.out.println(new N1405_longest_happy_string().longestDiverseString(0,0,3));
    }
    public String longestDiverseString(int a, int b, int c) {
        return slove(a,b,c,"a","b","c");
    }

    private String slove(int a, int b, int c, String aStr, String bStr, String cStr) {
        if(a<b)return slove(b,a,c,bStr,aStr,cStr);
        if(b<c)return slove(a,c,b,aStr,cStr,bStr);
        if(b==0)return repeat(aStr,Math.min(a,2));
        int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0;
        return repeat(aStr,use_a)+repeat(bStr,use_b)+
                slove(a-use_a,b-use_b,c,aStr,bStr,cStr);
    }

    private String repeat(String str, int cnt) {
        StringBuilder res=new StringBuilder();
        while (cnt-->0)res.append(str);
        return res.toString();
    }
}
/*
如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。

给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：

s 是一个尽可能长的快乐字符串。
s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
s 中只含有 'a'、'b' 、'c' 三种字母。
如果不存在这样的字符串 s ，请返回一个空字符串 ""。

 

示例 1：

输入：a = 1, b = 1, c = 7
输出："ccaccbcc"
解释："ccbccacc" 也是一种正确答案。
示例 2：

输入：a = 2, b = 2, c = 1
输出："aabbc"
示例 3：

输入：a = 7, b = 1, c = 0
输出："aabaa"
解释：这是该测试用例的唯一正确答案。
 

提示：

0 <= a, b, c <= 100
a + b + c > 0
通过次数1,628提交次数4,087

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-happy-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
