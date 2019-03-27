package JavaCode.random_records.N301_400;

public class N345_reverseVowels {

    public static void main(String[] args) {
        System.out.println(new N345_reverseVowels().reverseVowels(".,"));
    }

    public String reverseVowels(String s) {
        int left=0;
        int right=s.length()-1;
        char[] res = s.toCharArray();
        while (left<right)
        {
            while (!check(s.charAt(left)))
            {
                left++;
                if(left>=right)return new String(res);
            }
            while (!check(s.charAt(right)))
            {
                right--;
                if (right<=left)return new String(res);
            }
            if(check(s.charAt(left))&&check(s.charAt(right)))
            {
                char temp=res[left];
                res[left]=res[right];
                res[right]=temp;
            }
            left++;
            right--;
        }
        return new String(res);
    }

    //aeiou
    private boolean check(char s)
    {
        return s=='a'||s=='e'||s=='i'||s=='o'||s=='u'||s=='A'||s=='E'||s=='I'||s=='O'||s=='U';
    }
}
/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/comments/
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
