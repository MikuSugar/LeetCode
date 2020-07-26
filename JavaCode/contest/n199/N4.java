package JavaCode.contest.n199;



/**
 * @Author: fangjie
 * @Date: 2020/7/26 10:13 上午
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().getLengthOfOptimalCompression("abc",2));
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        ListNode<int[]> root=init(s);
        slove(root,k);
        int res=0;
        root=root.next;
        while (root!=null)
        {
            res++;
            if(root.value[1]!=1) res+=String.valueOf(root.value[1]).length();
            root=root.next;
        }
        return res;
    }

    private void slove(ListNode<int[]> root, int k) {
        ListNode<int[]> p=root.next;
        int[] max=new int[]{-1,0};
        ListNode<int[]> de=null;
        while (p!=null)
        {
            int[] l=getLen(p,k);
            if(max[0]<l[0]){
                max=l;
                de=p;
            }
            if(max[0]==l[0]&&max[1]>l[1]){
                de=p;
                max=l;
            }
            p=p.next;
        }
        if(max[0]==0)return;
        if(!delete(de,k))return;
        slove(root,k-max[1]);
    }

    private boolean delete(ListNode<int[]> p,int k) {
        if(p==null)return false;
        System.out.println(p);
        if(k<p.value[1])
        {
            p.value[1]-=k;
        }
        else if(p.pre!=null&&p.next!=null&&p.pre.value[0]==p.next.value[0])
        {
           p.pre.value[1]+=p.next.value[1];
           p.pre.next=p.next.next;
           if(p.next.next!=null)p.next.next.pre=p.pre;
        }
        else {
            p.pre.next=p.next;
            if(p.next!=null)p.next.pre=p.pre;
        }
        return true;
    }

    private int[] getLen(ListNode<int[]> p, int k) {
        if(k<p.value[1])
        {
            return new int[]{String.valueOf(p.value[1]).length()-String.valueOf(p.value[1]-k).length(),k};
        }
        else if(p.pre!=null&&p.next!=null&&p.pre.value[0]==p.next.value[0])
        {
            return new int[]{String.valueOf(p.pre.value[1]).length()+String.valueOf(p.next.value[1]).length()
                    -String.valueOf(p.pre.value[1]+p.next.value[1]).length()+1+String.valueOf(p.value[1]).length()+1
                    ,String.valueOf(p.value[1]).length()};
        }
        return new int[]{String.valueOf(p.value[1]).length()+1
                ,String.valueOf(p.value[1]).length()};
    }

    private ListNode<int[]> init(String s) {
        char[] strs=s.toCharArray();
        ListNode<int[]> node=new ListNode<>(new int[]{0,0});
        ListNode<int[]> p=node;
        int cnt=1;
        char pre=strs[0];
        for (int i=1;i<strs.length;i++)
        {
            if(strs[i]==pre)cnt++;
            else {
                ListNode<int[]> cur=new ListNode<>(new int[]{pre,cnt});
                cur.pre=p;
                p.next=cur;
                p=cur;
                cnt=1;
                pre=strs[i];
            }
        }
        ListNode<int[]> cur=new ListNode<>(new int[]{pre,cnt});
        cur.pre=p;
        p.next=cur;
        return node;
    }

    static class  ListNode<T> {
        T value;
        ListNode<T> pre;
        ListNode<T> next;

        public ListNode(T value) {
            this.value=value;
        }
    }
}
/*
行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。

注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。

给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。

请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。



示例 1：

输入：s = "aaabcccd", k = 2
输出：4
解释：在不删除任何内容的情况下，压缩后的字符串是 "a3bc3d" ，长度为 6 。最优的方案是删除 'b' 和 'd'，这样一来，压缩后的字符串为 "a3c3" ，长度是 4 。
示例 2：

输入：s = "aabbaa", k = 2
输出：2
解释：如果删去两个 'b' 字符，那么压缩后的字符串是长度为 2 的 "a4" 。
示例 3：

输入：s = "aaaaaaaaaaa", k = 0
输出：3
解释：由于 k 等于 0 ，不能删去任何字符。压缩后的字符串是 "a11" ，长度为 3 。


提示：

1 <= s.length <= 100
0 <= k <= s.length
s 仅包含小写英文字母
 */
