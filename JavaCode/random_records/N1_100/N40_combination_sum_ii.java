package JavaCode.random_records.N1_100;

import java.util.*;

public class N40_combination_sum_ii {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,candidates,target,0,0,new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int index, int sum, List<Integer> list) {
        if(sum==target)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum>target)return;

        for (int i=index;i<candidates.length;i++)
        {
            if(i>index&&candidates[i]==candidates[i-1])continue;
            list.add(candidates[i]);
            dfs(res,candidates,target,i+1,sum+candidates[i],list);
            list.remove(list.size()-1);
        }
    }
}
/**
 *
 */
