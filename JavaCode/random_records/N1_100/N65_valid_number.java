package JavaCode.random_records.N1_100;

/**
 * author:fangjie
 * time:2019/10/21
 */
public class N65_valid_number {
    public boolean isNumber(String s) {
        s=s.trim();
        if(s.isEmpty())return false;
        char[] strs=s.toCharArray();
        if(!checkCnt(strs))return false;
        if(!checkOperator(strs))return false;
        if(s.charAt(0)=='+'||s.charAt(0)=='-')s=s.substring(1);
        if(!checkPoint(s.toCharArray()))return false;
        if(!checkE(s))return false;
        return true;
    }

    private boolean checkPoint(char[] strs) {
        for (int i=0;i<strs.length;i++)
        {
            if(strs[i]=='.')
            {
                if(i==0)
                {
                    if(strs.length==1)return false;
                    return Character.isDigit(strs[i+1]);
                }
                else if(i==strs.length-1)return Character.isDigit(strs[i-1]);
                else return Character.isDigit(strs[i-1])&&(Character.isDigit(strs[i+1])||strs[i+1]=='e');
            }
        }
        return true;
    }

    private boolean checkOperator(char[] strs) {
        for(int i=0;i<strs.length;i++)
        {
            if(strs[i]=='+'||strs[i]=='-')
            {

                if(i==strs.length-1)return false;
                if(i!=0&&strs[i-1]!='e')return false;
            }
        }
        return true;
    }

    private boolean checkE(String s) {
        int idx=s.indexOf('e');
        if(idx==-1)return true;
        if(s.length()==1||idx==s.length()-1)return false;
        String[] es=s.split("e");
        if(!isNumber(es[0]))return false;
        if(es[1].charAt(0)=='+'||es[1].charAt(0)=='-')
        {
            es[1]=es[1].substring(1);
            if(es[1].isEmpty())return false;
        }
        for (char c:es[1].toCharArray())
        {
            if(!Character.isDigit(c))return false;
        }
        return true;
    }

    private boolean checkCnt(char[] strs) {
        int e_cnt=0;
        int operator_cnt=0;
        int point_cnt=0;
        for (char c:strs)
        {
            if(Character.isDigit(c))continue;
            if(c=='e')
            {
                e_cnt++;
                if(e_cnt>1)return false;
            }
            else if(c=='.')
            {
                point_cnt++;
                if (point_cnt>1)return false;
            }
            else if(c=='+'||c=='-')
            {
                operator_cnt++;
                if(operator_cnt>2)return false;
            }
            else return false;
        }
        return true;
    }
}
/**
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
