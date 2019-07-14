package JavaCode.contest.n145;

import java.util.*;

public class N4 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String,Integer> map=new HashMap<>();
        for (int i=0;i<req_skills.length;i++)
        {
            map.put(req_skills[i],i);
        }
        int[] dp=new int[1<<req_skills.length];
        Arrays.fill(dp,Integer.MAX_VALUE/2);
        dp[0]=0;
        List<Integer>[] lists=new List[1<<req_skills.length];
        for (int i=(1<<req_skills.length)-1;i>=0;i--)
        {
            lists[i]=new ArrayList<>();
        }
        int id=0;
        int g=Integer.MAX_VALUE;
        int gst=-1;
        for(List<String> c:people)
        {
            for (int status=(1<<req_skills.length)-1;status>=0;status--)
            {
                int cur=0;
                for (String str:c)
                {
                    if(map.containsKey(str))
                    {
                        int idx=map.get(str);
                        cur|=1<<idx;
                    }
                }
                int next_status=status|cur;
                if(dp[status]+1<dp[next_status])
                {
                    dp[next_status]=dp[status]+1;
                    lists[next_status]=new ArrayList<>();
                    for (int i:lists[status])
                    {
                        lists[next_status].add(i);
                    }
                    lists[next_status].add(id);
                }
            }
            id++;
        }
        int k=(1<<req_skills.length)-1;
        int len=lists[k].size();
        int[] res=new int[len];
        for (int i=0;i<len;i++)
        {
            res[i]=lists[k].get(i);
        }
        return res;
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
