package JavaCode.contest.weekly.n201_300.n267;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikusugar
 */
public class N4 {
    //TODO
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] c = new int[n];
        for (int i = 0; i < c.length; i++) {
            c[i] = i;
        }
        for (int[] r : restrictions) {
            union(r[0], r[1], c);
        }


        int[] f = new int[n];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }


        boolean[] res = new boolean[requests.length];

        for (int i = 0; i < res.length; i++) {
            int x = requests[i][0];
            int y = requests[i][1];

            List<Integer> xList = help(x, f);
            List<Integer> yList = help(y, f);

            if (check(xList, yList, c,f)) {
                union(x,y,f);
                union(find(x,c),find(y,c),c);
                res[i]=true;
            }
            else res[i]=false;

        }

        return res;

    }

    private boolean check(List<Integer> xList, List<Integer> yList, int[] c,int[]f) {
        for (int xx : xList) {
            for (int yy : yList) {
                if (find(xx, c) == find(yy, c)) return false;
            }
        }
        return true;
    }

    private List<Integer> help(int x, int[] f) {
        List<Integer> res = new ArrayList<>();
        final int tar = find(x, f);
        for (int i = 0; i < f.length; i++) {
            if (tar == find(i, f)) res.add(i);
        }
        return res;
    }

    private static int find(int x, int[] f) {
        if (f[x] == x) return x;
        f[x] = find(f[x], f);
        return f[x];
    }

    private static void union(int x, int y, int[] f) {
        int xRoot = find(x, f);
        int yRoot = find(y, f);
        if (xRoot != yRoot) {
            f[xRoot] = yRoot;
        }
    }
}
/*
给你一个整数 n ，表示网络上的用户数目。每个用户按从 0 到 n - 1 进行编号。

给你一个下标从 0 开始的二维整数数组 restrictions ，其中 restrictions[i] = [xi, yi] 意味着用户 xi 和用户 yi 不能 成为 朋友 ，不管是 直接 还是通过其他用户 间接 。

最初，用户里没有人是其他用户的朋友。给你一个下标从 0 开始的二维整数数组 requests 表示好友请求的列表，其中 requests[j] = [uj, vj] 是用户 uj 和用户 vj 之间的一条好友请求。

如果 uj 和 vj 可以成为 朋友 ，那么好友请求将会 成功 。每个好友请求都会按列表中给出的顺序进行处理（即，requests[j] 会在 requests[j + 1] 前）。一旦请求成功，那么对所有未来的好友请求而言， uj 和 vj 将会 成为直接朋友 。

返回一个 布尔数组 result ，其中元素遵循此规则：如果第 j 个好友请求 成功 ，那么 result[j] 就是 true ；否则，为 false 。

注意：如果 uj 和 vj 已经是直接朋友，那么他们之间的请求将仍然 成功 。



示例 1：

输入：n = 3, restrictions = [[0,1]], requests = [[0,2],[2,1]]
输出：[true,false]
解释：
请求 0 ：用户 0 和 用户 2 可以成为朋友，所以他们成为直接朋友。
请求 1 ：用户 2 和 用户 1 不能成为朋友，因为这会使 用户 0 和 用户 1 成为间接朋友 (1--2--0) 。
示例 2：

输入：n = 3, restrictions = [[0,1]], requests = [[1,2],[0,2]]
输出：[true,false]
解释：
请求 0 ：用户 1 和 用户 2 可以成为朋友，所以他们成为直接朋友。
请求 1 ：用户 0 和 用户 2 不能成为朋友，因为这会使 用户 0 和 用户 1 成为间接朋友 (0--2--1) 。
示例 3：

输入：n = 5, restrictions = [[0,1],[1,2],[2,3]], requests = [[0,4],[1,2],[3,1],[3,4]]
输出：[true,false,true,false]
解释：
请求 0 ：用户 0 和 用户 4 可以成为朋友，所以他们成为直接朋友。
请求 1 ：用户 1 和 用户 2 不能成为朋友，因为他们之间存在限制。
请求 2 ：用户 3 和 用户 1 可以成为朋友，所以他们成为直接朋友。
请求 3 ：用户 3 和 用户 4 不能成为朋友，因为这会使 用户 0 和 用户 1 成为间接朋友 (0--4--3--1) 。


提示：

2 <= n <= 1000
0 <= restrictions.length <= 1000
restrictions[i].length == 2
0 <= xi, yi <= n - 1
xi != yi
1 <= requests.length <= 1000
requests[j].length == 2
0 <= uj, vj <= n - 1
uj != vj

 */