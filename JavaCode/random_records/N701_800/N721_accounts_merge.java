package JavaCode.random_records.N701_800;

import java.util.*;

public class N721_accounts_merge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> name=new HashMap<>();
        Map<String,String> root=new HashMap<>();
        Map<String,TreeSet<String>> unio=new HashMap<>();
        for (List<String> s:accounts)
        {
            for (int i=1;i<s.size();i++)
            {
                root.put(s.get(i),s.get(i));
                name.put(s.get(i),s.get(0));
            }
        }
        for (List<String> s:accounts)
        {
            String r=find(root,s.get(1));
            for (int i=2;i<s.size();i++)
            {
                root.put(find(root,s.get(i)),r);
            }
        }
        for (List<String> s:accounts)
        {
            String r=find(root,s.get(1));
            if(!unio.containsKey(r))unio.put(r,new TreeSet<>());
            TreeSet<String> set=unio.get(r);
            for (int i=1;i<s.size();i++)
            {
                set.add(s.get(i));
            }
        }

        List<List<String>> res=new ArrayList<>();
        for(String p:unio.keySet())
        {
            List<String> list=new LinkedList<>(unio.get(p));
            list.add(0,name.get(p));
            res.add(list);
        }
        return res;
    }

    private String find(Map<String,String> root,String s)
    {
        return root.get(s)==s?s:find(root,root.get(s));
    }

}
/**
 * https://leetcode-cn.com/problems/accounts-merge/
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该帐户的邮箱地址。
 *
 * 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。
 *
 * 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。
 *
 * 例子 1:
 *
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 *   第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。
 *   第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
 *   我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 *   ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被接受。
 */
