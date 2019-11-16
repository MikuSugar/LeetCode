package JavaCode.contest.biweekly_n13;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/16
 */
public class N2 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String,String> faMap=new HashMap<>();
        for (List<String> r:regions)
        {
            for (int i=1;i<r.size();i++)
            {
                faMap.put(r.get(i),r.get(0));
            }
        }
        List<String> fa1=new ArrayList<>();
        List<String> fa2=new ArrayList<>();
        getList(region1,faMap,fa1);
        getList(region2,faMap,fa2);
        int idx1=fa1.size()-1,idx2=fa2.size()-1;
        while (idx1>=0&&idx2>=0&&fa1.get(idx1).equals(fa2.get(idx2)))
        {
            idx1--;
            idx2--;
        }
        return fa1.get(idx1+1);
    }

    private void getList(String r, Map<String, String> fa, List<String> res) {
        res.add(r);
        if(fa.containsKey(r)) getList(fa.get(r),fa,res);
    }
}
/*
给你一些区域列表 regions ，每个列表的第一个区域都包含这个列表内所有其他区域。

很自然地，如果区域 X 包含区域 Y ，那么区域 X  比区域 Y 大。

给定两个区域 region1 和 region2 ，找到同时包含这两个区域的 最小 区域。

如果区域列表中 r1 包含 r2 和 r3 ，那么数据保证 r2 不会包含 r3 。

数据同样保证最小公共区域一定存在。



示例 1：

输入：
regions = [["Earth","North America","South America"],
["North America","United States","Canada"],
["United States","New York","Boston"],
["Canada","Ontario","Quebec"],
["South America","Brazil"]],
region1 = "Quebec",
region2 = "New York"
输出："North America"


提示：

2 <= regions.length <= 10^4
region1 != region2
所有字符串只包含英文字母和空格，且最多只有 20 个字母。
 */
