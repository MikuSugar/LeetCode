package JavaCode.contest.n113;

import java.util.*;

public class N4 {

    class Node
    {
        int val;
        Set<Node> neighbor;
        boolean isexit;//是否是真实际存在的点
        public Node(int val,boolean isexit)
        {
            this.val=val;
            this.isexit=isexit;
            neighbor=new HashSet<>();
        }

    }

    //private static List<Integer> prime;
    private static boolean[] prime;

    public int largestComponentSize(int[] A) {
        if(prime==null)prime=getPrime();
        Map<Integer,Node> map=new HashMap<>();
        for (int i:A)
        {
           map.put(i,new Node(i,true));
        }
        for (int i:A)
        {
            buildmap(i,map);
        }

        int res=0;
        Set<Node> book=new HashSet<>();
        for (Node node:map.values())
        {
            if(node.isexit)
                res=Math.max(res,dfs(node,book));
        }
        return res;

    }

    private int dfs(Node node, Set<Node> book) {
        if(book.contains(node))return 0;
        book.add(node);
        int cnt=node.isexit?1:0;
        for (Node n:node.neighbor)
        {
            cnt+=dfs(n,book);
        }
        return cnt;
    }

    private void buildmap(int num, Map<Integer, Node> map) {
        Node node=map.get(num);
        for (int i=2;i<=Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                Node node1;
                if(!prime[i])
                {
                    node1=map.getOrDefault(i,new Node(i,false));
                    node.neighbor.add(node1);
                    node1.neighbor.add(node);
                    map.put(i,node1);
                }
                int k=num/i;
                if(k>=prime.length)continue;
                if(!prime[k])
                {
                    node1=map.getOrDefault(k,new Node(k,false));
                    node.neighbor.add(node1);
                    node1.neighbor.add(node);
                    map.put(k,node1);
                }
            }
        }

    }

    /**
     * 获取质数
     * @return
     */
    private static boolean[] getPrime()
    {
        int max=50000;
        List<Integer> prime=new ArrayList<>();
        boolean[] book=new boolean[max+5];
        int len=0;
        for (int i=2;i<=max;i++)
        {
            if(!book[i])
            {
                prime.add(i);
                len++;
            }
            for(int j=0;j<len&&prime.get(j)*i<=max;j++){
                book[prime.get(j)*i] = true;
                if(i%prime.get(j)==0)break;
            }
        }
        return book;
    }


}
/**
 * 给定一个由不同正整数的组成的非空数组 A，考虑下面的图：
 *
 * 有 A.length 个节点，按从 A[0] 到 A[A.length - 1] 标记；
 * 只有当 A[i] 和 A[j] 共用一个大于 1 的公因数时，A[i] 和 A[j] 之间才有一条边。
 * 返回图中最大连通组件的大小。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[4,6,15,35]
 * 输出：4
 *
 * 示例 2：
 *
 * 输入：[20,50,9,63]
 * 输出：2
 *
 * 示例 3：
 *
 * 输入：[2,3,6,7,4,12,21,39]
 * 输出：8
 *
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 100000
 */
