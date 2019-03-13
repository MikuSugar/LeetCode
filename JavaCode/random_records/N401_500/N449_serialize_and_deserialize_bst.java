package JavaCode.random_records.N401_500;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N449_serialize_and_deserialize_bst {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root)
        {
            if(root==null) return "";
            StringBuilder sb = new StringBuilder();
            help1(root, sb);
            if (sb.length() == 0) return "";
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private void help1(TreeNode root, StringBuilder sb)
        {
            if (root == null) return;
            sb.append(root.val + ",");
            help1(root.left, sb);
            help1(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data)
        {
            if(data==null||data.length()==0)return null;

            String[] strings = data.split(",");
            if (strings.length == 0) return null;
            int[] pre = new int[strings.length];
            for (int i = 0; i < pre.length; i++)
            {
                pre[i] = Integer.parseInt(strings[i]);
            }

            return help2(0, pre.length - 1, pre);
        }

        private TreeNode help2(int l, int r, int[] pre)
        {
            TreeNode root = new TreeNode(pre[l]);
            if (l < r)
            {
                int index = getindex(l, r, pre);
                if (index == -1)
                {
                    root.left = help2(l + 1, r, pre);
                    root.right = null;
                } else if (index == l + 1)
                {
                    root.left = null;
                    root.right = help2(l + 1, r, pre);
                } else
                {
                    root.left = help2(l + 1, index - 1, pre);
                    root.right = help2(index, r, pre);
                }
            }
            return root;
        }

        private int getindex(int l, int r, int[] pre)
        {
            for (int i = l + 1; i <= r; i++)
            {
                if (pre[i] > pre[l]) return i;
            }
            return -1;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 */
