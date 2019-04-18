package JavaCode.random_records.N1_100;


import java.util.ArrayList;
import java.util.List;

public class N93_restore_ip_addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        for (int i=0;i<s.length()-2&&i<4;i++)
        {
            for (int j=i+1;j<i+4&&j<s.length()-1;j++)
            {
                for (int k=j+1;k<j+4&&k<s.length();k++)
                {
                    String s1=s.substring(0,i);
                    String s2=s.substring(i,j);
                    String s3=s.substring(j,k);
                    String s4=s.substring(k);
                    if(check(new String[]{s1,s2,s3,s4}))
                    {
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }

    private boolean check(String[] strings) {
        for (String s:strings)
        {
            if(s.length()==0||s.length()>3||(s.charAt(0)=='0'&&s.length()>1)||Integer.parseInt(s)>255)
                return false;
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
