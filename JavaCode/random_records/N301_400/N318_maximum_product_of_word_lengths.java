package JavaCode.random_records.N301_400;

public class N318_maximum_product_of_word_lengths {

    public int maxProduct(String[] words) {
        int[] book=new int[words.length];
        for (int i=0;i<words.length;i++)
        {
            String word=words[i];
            for (int j=0;j<word.length();j++)
            {
                book[i]|=1<<(word.charAt(j)-'a');
            }
        }
        int res=0;
        for (int i=0;i<words.length-1;i++)
        {
            int len=words[i].length();
            for (int j=i+1;j<words.length;j++)
            {
                if((book[i]&book[j])==0)
                {
                    res=Math.max(res,len*words[j].length());
                }
            }
        }
        return res;
    }
}
/**
 *给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
