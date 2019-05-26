package JavaCode.contest.n138;

import java.util.*;

public class N4 {

    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length<=2)return barcodes;
        int[] res=new int[barcodes.length];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:barcodes)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        queue.addAll(map.entrySet());
        Map.Entry<Integer,Integer> e=queue.poll();
        res[0]=e.getKey();
        e.setValue(e.getValue()-1);
        if(e.getValue()>0)queue.add(e);
        int cur=1;
        while (cur<res.length)
        {
            Map.Entry<Integer,Integer> e1=queue.poll();
            if(e1.getKey()!=res[cur-1])
            {
                res[cur++]=e1.getKey();
                e1.setValue(e1.getValue()-1);
                if(e1.getValue()>0)queue.add(e1);
            }
            else
            {
                Map.Entry<Integer,Integer> e2=queue.poll();
                queue.add(e1);
                res[cur++]=e2.getKey();
                e2.setValue(e2.getValue()-1);
                if(e2.getValue()>0)queue.add(e2);
            }
        }
        return res;
    }

}
/**
 *  在仓库中，有一排条形码，第 i 个条形码为 barcodes[i]。
 *
 * 重新排列条形码，使两个相邻的条形码不相等。 你可以返回任何满足要求的答案，此题保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 *
 * 输入：[1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *
 *
 * 提示：
 *
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 */
