package JavaCode.random_records.N801_900;

public class N825_friends_of_appropriate_ages {
    public int numFriendRequests(int[] ages) {
        int res=0;
        int[] book=new int[121];
        for (int i:ages)
        {
            book[i]++;
        }
        for (int i=0;i<=120;i++)
        {
            if(book[i]==0)continue;
            if(check(i,i)) res+=book[i]*(book[i]-1);
            for (int j=i+1;j<=120;j++)
            {
                if(book[j]==0)continue;
                if(check(i,j))res+=book[i]*book[j];
                if(check(j,i))res+=book[j]*book[i];
            }
        }
        return res;
    }

    private boolean check(int ageA, int ageB) {
        if(ageB<=ageA*0.5+7)return false;
        if(ageB>ageA)return false;
        if(ageB>100&&ageA<100)return false;
        return true;
    }

}
/*
当满足以下条件时，A 不能给 B（A、B不为同一人）发送好友请求：

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
否则，A 可以给 B 发送好友请求。

注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 

求总共会发出多少份好友请求?

 

示例 1:

输入: [16,16]
输出: 2
解释: 二人可以互发好友申请。
示例 2:

输入: [16,17,18]
输出: 2
解释: 好友请求可产生于 17 -> 16, 18 -> 17.
示例 3:

输入: [20,30,100,110,120]
输出: 3
解释: 好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
 

说明:

1 <= ages.length <= 20000.
1 <= ages[i] <= 120.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */