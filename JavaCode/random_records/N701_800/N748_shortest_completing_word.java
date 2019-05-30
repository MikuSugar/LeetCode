package JavaCode.random_records.N701_800;

public class N748_shortest_completing_word {

    public static void main(String[] args) {
        System.out.println(new N748_shortest_completing_word().shortestCompletingWord("1s3 PSt",new String[]{"step","steps","stripe","stepple"}));
    }
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] book=new int[26];
        for (char c:licensePlate.toCharArray())
        {
            if(c>='a'&&c<='z')book[c-'a']++;
            else if (c>='A'&&c<='Z')book[c-'A']++;
        }
        String res="";
        int min=Integer.MAX_VALUE;
        for (String s:words)
        {
            if(s.length()<min&&check(s,book))
            {
                res=s;
                min=s.length();
            }
        }
        return res;
    }

    private boolean check(String s, int[] book) {
        int[] book1=new int[26];
        for (char c:s.toCharArray())
        {
            book1[c-'a']++;
        }
        for (int i=0;i<26;i++)
        {
            if(book1[i]<book[i])return false;
        }
        return true;
    }
}
/**
 *如果单词列表（words）中的一个单词包含牌照（licensePlate）中所有的字母，那么我们称之为完整词。在所有完整词中，最短的单词我们称之为最短完整词。
 *
 * 单词在匹配牌照中的字母时不区分大小写，比如牌照中的 "P" 依然可以匹配单词中的 "p" 字母。
 *
 * 我们保证一定存在一个最短完整词。当有多个单词都符合最短完整词的匹配条件时取单词列表中最靠前的一个。
 *
 * 牌照中可能包含多个相同的字符，比如说：对于牌照 "PP"，单词 "pair" 无法匹配，但是 "supper" 可以匹配。
 *
 *
 *
 * 示例 1：
 *
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 说明：最短完整词应该包括 "s"、"p"、"s" 以及 "t"。对于 "step" 它只包含一个 "s" 所以它不符合条件。同时在匹配过程中我们忽略牌照中的大小写。
 *
 *
 * 示例 2：
 *
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 说明：存在 3 个包含字母 "s" 且有着最短长度的完整词，但我们返回最先出现的完整词。
 *
 *
 * 注意:
 *
 * 牌照（licensePlate）的长度在区域[1, 7]中。
 * 牌照（licensePlate）将会包含数字、空格、或者字母（大写和小写）。
 * 单词列表（words）长度在区间 [10, 1000] 中。
 * 每一个单词 words[i] 都是小写，并且长度在区间 [1, 15] 中。
 */
