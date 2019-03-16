package JavaCode.random_records.N601_700;

public class N640_solve_the_equation {
    public String solveEquation(String equation) {
        if(equation==null||equation.length()<3) return "No solution";
        String[] s1=equation.split("=");
        String[] left=s1[0].replace("-","+-").split("\\+");
        String[] right=s1[1].replace("-","+-").split("\\+");
        int x_cnt=0;
        int sum=0;
        for(String s:left)
        {
            if(s.length()==0)continue;
            if(s.equals("x"))x_cnt++;
            else if(s.equals("-x"))x_cnt--;
            else if(s.charAt(s.length()-1)=='x')
            {
                x_cnt+=Integer.parseInt(s.substring(0,s.length()-1));
            }
            else sum+=Integer.parseInt(s);
        }
        for (String s:right)
        {
            if(s.length()==0)continue;
            if(s.equals("x"))x_cnt--;
            else if(s.equals("-x"))x_cnt++;
            else if(s.charAt(s.length()-1)=='x')
            {
                x_cnt-=Integer.parseInt(s.substring(0,s.length()-1));
            }
            else sum-=Integer.parseInt(s);
        }
        if(x_cnt==0)return sum==0?"Infinite solutions":"No solution";
        return "x="+(-sum/x_cnt);
    }
}
/**
 * https://leetcode-cn.com/problems/solve-the-equation/
 * 求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回“No solution”。
 *
 * 如果方程有无限解，则返回“Infinite solutions”。
 *
 * 如果方程中只有一个解，要保证返回值 x 是一个整数。
 *
 * 示例 1：
 *
 * 输入: "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 *
 * 输入: "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 *
 * 输入: "2x=x"
 * 输出: "x=0"
 * 示例 4:
 *
 * 输入: "2x+3x-6x=x+2"
 * 输出: "x=-1"
 * 示例 5:
 *
 * 输入: "x=x+2"
 * 输出: "No solution"
 */
