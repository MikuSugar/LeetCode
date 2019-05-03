package JavaCode.random_records.N701_800;

import java.util.ArrayList;
import java.util.List;

public class N722_remove_comments {
    public List<String> removeComments(String[] source) {
        if(source==null||source.length==0)return new ArrayList<>();
        List<String> res=new ArrayList<>(source.length/2+1);
        int cur=0;
        while (cur<source.length)
        {
            String str=source[cur];
            if(str==null||str.length()==0)
            {
                cur++;
                continue;
            }

            int i=str.indexOf("//");
            int j=str.indexOf("/*");
            if(i==-1&&j==-1)
            {
                res.add(str);
                cur++;
                continue;
            }
            if(i!=-1&&(j==-1||i<j))
            {
                source[cur]=str.substring(0,i);
                continue;
            }
            if(j!=-1)
            {
                String pre=str.substring(0,j);
                source[cur]=str.substring(j+2,str.length());
                String sec="";
                while (cur<source.length)
                {
                    int index = source[cur].indexOf("*/");
                    if(index!=-1)
                    {
                        source[cur]=pre+source[cur].substring(index+2,source[cur].length());
                        break;
                    }
                    cur++;
                }
            }
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/remove-comments/
 */
