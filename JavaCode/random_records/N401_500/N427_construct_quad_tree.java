package JavaCode.random_records.N401_500;

/**
 * author:fangjie
 * time:2019/10/11
 */
public class N427_construct_quad_tree {

    public Node construct(int[][] grid) {
        return slove(0,0,grid.length-1,grid.length-1,grid);
    }

    private Node slove(int r1, int c1, int r2, int c2, int[][] grid) {
        if(r1>r2||c1>c2)return null;
        if(check(r1,c1,r2,c2,grid))return new Node(grid[r1][c1]==1,true,null,null,null,null);
        int rmid=(r1+r2)/2;
        int cmid=(c1+c2)/2;
        return new Node(false,false,
                slove(r1,c1,rmid,cmid,grid),
                slove(r1,cmid+1,rmid,c2,grid),
                slove(rmid+1,c1,r2,cmid,grid),
                slove(rmid+1,cmid+1,r2,c2,grid));
    }//

    private boolean check(int r1, int c1, int r2, int c2, int[][] grid) {
        final int val=grid[r1][c1];
        for (int i=r1;i<=r2;i++)
        {
            for (int j=c1;j<=c2;j++)
            {
                if(grid[i][j]!=val)return false;
            }
        }
        return true;
    }
}
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
}
/**
 * 我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。树的根结点代表整个网络。对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
 *
 * 每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。val 变量储存叶子结点所代表的区域的值。
 *
 * 你的任务是使用一个四叉树表示给定的网络。下面的例子将有助于你理解这个问题：
 *
 * 给定下面这个8 x 8 网络，我们将这样建立一个对应的四叉树：
 *
 *
 *
 * 由上文的定义，它能被这样分割：
 *
 *
 *
 *  
 *
 * 对应的四叉树应该像下面这样，每个结点由一对 (isLeaf, val) 所代表.
 *
 * 对于非叶子结点，val 可以是任意的，所以使用 * 代替。
 *
 *
 *
 * 提示：
 *
 * N 将小于 1000 且确保是 2 的整次幂。
 * 如果你想了解更多关于四叉树的知识，你可以参考这个 wiki 页面。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-quad-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
