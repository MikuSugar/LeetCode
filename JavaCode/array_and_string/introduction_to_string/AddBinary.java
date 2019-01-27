package JavaCode.array_and_string.introduction_to_string;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010","1011"));
    }
    public String addBinary(String a, String b) {

        //补0；
        if(a.length()<b.length())
        {
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<b.length()-a.length();i++)
            {
                temp.append('0');
            }
            a=temp.toString()+a;
        }
        else if(a.length()>b.length())
        {
            StringBuilder temp=new StringBuilder();
            for(int i=0;i<a.length()-b.length();i++)
            {
                temp.append('0');
            }
            b=temp.toString()+b;
        }

        StringBuilder sb=new StringBuilder();
        int carry=0;
        for(int i=a.length()-1;i>=0;i--)
        {
            int x=a.charAt(i)-'0';
            int y=b.charAt(i)-'0';
            int c=(x+y+carry)%2;
            carry=(x+y+carry)/2;
            sb.append(c);
        }
        if(carry!=0) sb.append(carry);

        return sb.reverse().toString();
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/200/introduction-to-string/779/
 *二进制求和
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
