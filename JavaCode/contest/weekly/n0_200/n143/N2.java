package JavaCode.contest.weekly.n0_200.n143;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2 {
    private static int[] n={0,1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047,
            4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575};
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res=new ArrayList<>();
        while (label>0)
        {
            int level=findLevel(label);
            res.add(label);
            if(level%2!=0)
            {
                label=(n[level]-label+1+n[level-1])/2;
            }
            else
            {
                if(label==1)
                {
                    label=0;
                }
                else
                {
                    label=n[level-1]-label/2+1+n[level-2];
                }
            }

        }
        Collections.reverse(res);
        return res;
    }

    private int findLevel(int label) {
        for (int i=0;i<n.length;i++)
        {
           if(n[i]>=label)return i;
        }
        return -1;
    }
}
/**
 *在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 *
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * 示例 2：
 *
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 *
 * 提示：
 *
 * 1 <= label <= 10^6
 */
