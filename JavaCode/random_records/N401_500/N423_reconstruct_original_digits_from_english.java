package JavaCode.random_records.N401_500;

public class N423_reconstruct_original_digits_from_english {

    //"zero","one","two","three","four","five","six","seven","eight","nine"
    public String originalDigits(String s) {
        int[] book=new int[10];
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='z')book[0]++;
            else if(c=='w')book[2]++;
            else if(c=='x')book[6]++;
            else if(c=='s')book[7]++;//s_cnt=six+seven
            else if(c=='g')book[8]++;
            else if(c=='u')book[4]++;
            else if(c=='f')book[5]++;//f_cnt=four+five
            else if(c=='h')book[3]++;//h_cnt=three+eight
            else if(c=='i')book[9]++;//i_cnt=five+six+eight+nine
            else if(c=='o')book[1]++;//o_cnt=zero+one+two+four
        }
        book[7]-=book[6];
        book[5]-=book[4];
        book[3]-=book[8];
        book[9]-=book[5]+book[6]+book[8];
        book[1]-=book[0]+book[2]+book[4];

        StringBuilder res=new StringBuilder();
        for (int i=0;i<10;i++)
        {
            for (int j=0;j<book[i];j++)
            {
                res.append(i);
            }
        }
        return res.toString();
    }
}
/**
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 *
 * 注意:
 *
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 示例 1:
 *
 * 输入: "owoztneoer"
 *
 * 输出: "012" (zeroonetwo)
 * 示例 2:
 *
 * 输入: "fviefuro"
 *
 * 输出: "45" (fourfive)
 */
