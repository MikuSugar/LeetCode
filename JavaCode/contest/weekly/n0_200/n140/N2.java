package JavaCode.contest.weekly.n0_200.n140;

import java.util.HashSet;
import java.util.Set;

public class N2 {

    public int numTilePossibilities(String tiles) {
        char[] word= tiles.toCharArray();
        Set<String> set=new HashSet<>();
        dfs(new StringBuilder(),new boolean[word.length],set,word);
        return set.size();
    }

    private void dfs(StringBuilder sb, boolean[] book, Set<String> set,char[] word) {
        if(sb.length()>0)set.add(sb.toString());
        Set<Character> use=new HashSet<>();
        for (int i=0;i<word.length;i++)
        {
            if(book[i]||set.contains(word[i]))continue;
            sb.append(word[i]);
            book[i]=true;
            use.add(word[i]);
            dfs(sb,book,set,word);
            book[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
/**
 *你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 *
 * 输入："AAABBC"
 * 输出：188
 *
 *
 * 提示：
 *
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 */
