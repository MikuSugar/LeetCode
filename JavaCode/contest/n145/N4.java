package JavaCode.contest.n145;

import java.util.*;

public class N4 {

    //超时待解决！
    private int[] res;
    private List<List<String>> people;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Set<String> set=new HashSet<>();
        this.people=people;
        for (String s:req_skills)
        {
            set.add(s);
        }
        dfs(set,0,new ArrayList<>());
        return res;
    }

    private void dfs(Set<String> set, int start, List<Integer> list) {
        if(res!=null&&list.size()>res.length)return;
        if(set.size()==0)
        {
            if(res==null||res.length>list.size())
            {
                res=new int[list.size()];
                int idx=0;
                for (int i:list)
                {
                    res[idx++]=i;
                }
            }
            return;
        }
        for (int i=start;i<people.size();i++)
        {
            List<String> p = people.get(i);
            if(getNum(set,p)==0)continue;
            Set<String> set1=new HashSet<>(set);
            help(set,p);
            list.add(i);
            dfs(set,start+1,list);
            list.remove(list.size()-1);
            set=set1;
        }
    }

    private int getNum(Set<String> set, List<String> list) {
        int res=0;
        for (String s:list)
        {
            if (set.contains(s)) res++;
        }
        return res;
    }
    private void help(Set<String> set, List<String> p) {
        List<String> res=new ArrayList<>();
        for (String s:p)
        {
            set.remove(s);
            res.add(s);
        }

    }
}
/**
 *作为项目的项目经理，你规划了一份需求技能清单 req_skills ，并打算从备选人员名单 people 中选出一些人构成必要团队。 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表。
 *
 * 在一个必要团队中， 对于需求技能列表 req_skills  中列出的每项技能，团队中都至少有一名成员已经掌握。我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 *
 * 返回 任一 规模最小的的必要团队，团队成员用每个人的编号表示。
 *
 * 你可以按任意顺序返回答案。本题保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * 输出：[0,2]
 * 示例 2：
 *
 * 输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 1 <= req_skills.length <= 16
 * 1 <= people.length <= 60
 * 1 <= people[i].length, req_skills[i].length, people[i][j].length <= 16
 * req_skills 和 people[i] 中的元素分别各不相同。
 * req_skills[i][j], people[i][j][k] 都由小写英文字母组成。
 * 保证存在一个必要团队
 */
