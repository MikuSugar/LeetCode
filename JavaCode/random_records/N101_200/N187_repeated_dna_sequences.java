package JavaCode.random_records.N101_200;

import java.util.*;

public class N187_repeated_dna_sequences {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length()<10)return new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        List<String> res=new ArrayList<>();
        int hash=0;
        char[] str = s.toCharArray();
        for (int i=0;i<10;i++)
        {
            hash<<=2;
            hash|=getKey(str[i]);
        }
        map.put(hash,1);
        for (int i=10;i<str.length;i++)
        {
            hash<<=2;
            hash=hash<<12>>>12;
            hash|=getKey(str[i]);
            int cnt=map.getOrDefault(hash,0);
            if(cnt==1)res.add(s.substring(i-9,i+1));
            map.put(hash,cnt+1);
        }
        return res;
    }

    private int getKey(char c) {
        if(c=='A')return 0;
        if(c=='C')return 1;
        if(c=='G')return 2;
        return 3;
    }

}
/**
 * 所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
 *
 * 示例:
 *
 * 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
