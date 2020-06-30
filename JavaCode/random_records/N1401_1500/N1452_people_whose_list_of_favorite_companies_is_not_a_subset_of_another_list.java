package JavaCode.random_records.N1401_1500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: fangjie
 * @Date: 2020/6/25 12:52 上午
 */
public class N1452_people_whose_list_of_favorite_companies_is_not_a_subset_of_another_list {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Set<String>> fSet=new ArrayList<>(favoriteCompanies.size());
        for(List<String> list:favoriteCompanies)fSet.add(new HashSet<>(list));

        int[] fa=new int[favoriteCompanies.size()];
        for (int i=0;i<fa.length;i++)fa[i]=i;

        for (int i=0;i<fSet.size();i++)
        {
            for (int j=i+1;j<fSet.size();j++)
            {
                int a=find(i,fa);
                int b=find(j,fa);
                if(a==b)continue;
                if(check(fSet.get(a),fSet.get(b)))fa[a]=b;
                else if(check(fSet.get(b),fSet.get(a)))fa[b]=a;
            }
        }
        List<Integer> res=new ArrayList<>(favoriteCompanies.size()/2+5);
        for (int i=0;i<fa.length;i++)
        {
            if(fa[i]==i)res.add(i);
        }
        return res;
    }

    private <T> boolean check(Set<T> son,Set<T> father)
    {
        if (son.size()>father.size())return false;
        return father.containsAll(son);
    }
    private int find(int idx,int[] fa)
    {
        return fa[idx]=fa[idx]==idx?idx:find(fa[idx],fa);
    }
}
/*
给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。

请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。

 

示例 1：

输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
输出：[0,1,4]
解释：
favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
示例 2：

输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
输出：[0,1]
解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
示例 3：

输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
输出：[0,1,2,3]
 

提示：

1 <= favoriteCompanies.length <= 100
1 <= favoriteCompanies[i].length <= 500
1 <= favoriteCompanies[i][j].length <= 20
favoriteCompanies[i] 中的所有字符串 各不相同 。
用户收藏的公司清单也 各不相同 ，也就是说，即便我们按字母顺序排序每个清单， favoriteCompanies[i] != favoriteCompanies[j] 仍然成立。
所有字符串仅包含小写英文字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
