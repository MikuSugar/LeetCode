package JavaCode.random_records.N301_400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N399_evaluate_division {
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res=new double[queries.length];
        Map<String,String> root=new HashMap<>();
        Map<String,Double> dist=new HashMap<>();

        for (int i=0;i<equations.length;i++)
        {
            String[] e=equations[i];
            String r1=find(root,dist,e[0]);
            String r2=find(root,dist,e[1]);
            root.put(r1,r2);
            dist.put(r1,dist.get(e[1])*values[i]/dist.get(e[0]));
        }
        int index=0;
        for (String[] q:queries)
        {
            if(!root.containsKey(q[0])||!root.containsKey(q[1]))
            {
                res[index++]=-1;
                continue;
            }
            String r1=find(root,dist,q[0]);
            String r2=find(root,dist,q[1]);
            if(!r1.equals(r2))
            {
                res[index++]=-1;
                continue;
            }
            res[index++]=dist.get(q[0])/dist.get(q[1]);
        }
        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if(!root.containsKey(s))
        {
            root.put(s,s);
            dist.put(s,1d);
            return s;
        }
        if(root.get(s).equals(s))return s;
        String lp=root.get(s);
        String p=find(root,dist,lp);
        root.put(s,p);
        dist.put(s,dist.get(s)*dist.get(lp));
        return p;
    }
}
/**
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 */
