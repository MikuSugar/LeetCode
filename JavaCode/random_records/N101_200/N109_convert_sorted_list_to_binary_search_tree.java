package JavaCode.random_records.N101_200;


import JavaCode.data_structure_binary_tree.TreeNode;
import JavaCode.linked_list.ListNode;

public class N109_convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)return null;
        int len=getLen(head);
        int[] arr=new int[len];
        int idx=0;
        while (head!=null)
        {
            arr[idx++]=head.val;
            head=head.next;
        }
        return buildTree(0,arr.length-1,arr);
    }

    private TreeNode buildTree(int left, int right, int[] arr) {
        if(left>right)return null;
        int mid=(left+right)/2;
        TreeNode node=new TreeNode(arr[mid]);
        node.left=buildTree(left,mid-1,arr);
        node.right=buildTree(mid+1,right,arr);
        return node;
    }

    private int getLen(ListNode head) {
        if(head==null)return 0;
        return 1+getLen(head.next);
    }
}
/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
