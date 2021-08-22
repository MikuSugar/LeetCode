package JavaCode.contest.weekly.n201_300.n255;

/**
 * @author mikusugar
 */
public class N2 {

    public String findDifferentBinaryString(String[] nums) {
        Node root = new Node();
        for (String num : nums) {
            buildTree(root, num.toCharArray());
        }
        final String ans = find(root, "", nums[0].length());
        StringBuilder res = new StringBuilder(ans == null ? "" : ans);
        for (int i = res.length(); i < nums[0].length(); i++) res.append('0');
        return res.toString();
    }

    private String find(Node node, String s, final int n) {
        if (node == null) {
            if (s.length() <= n) return s;
            return null;
        }
        final String res = find(node.one, s + '1', n);
        if (res != null) return res;
        return find(node.zero, s + '0', n);
    }

    private void buildTree(Node root, char[] strs) {
        Node p = root;
        for (char c : strs) {
            if (c == '0') {
                if (p.zero == null) p.zero = new Node();
                p = p.zero;
            } else {
                if (p.one == null) p.one = new Node();
                p = p.one;
            }
        }
    }

    static class Node {
        Node zero;
        Node one;
    }
}
/*
给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。



示例 1：

输入：nums = ["01","10"]
输出："11"
解释："11" 没有出现在 nums 中。"00" 也是正确答案。
示例 2：

输入：nums = ["00","01"]
输出："11"
解释："11" 没有出现在 nums 中。"10" 也是正确答案。
示例 3：

输入：nums = ["111","011","001"]
输出："101"
解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。


提示：

n == nums.length
1 <= n <= 16
nums[i].length == n
nums[i] 为 '0' 或 '1'
 */
