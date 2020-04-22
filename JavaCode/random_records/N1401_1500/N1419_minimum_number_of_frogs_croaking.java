package JavaCode.random_records.N1401_1500;

/**
 * author:fangjie
 * time:2020/4/22
 */
public class N1419_minimum_number_of_frogs_croaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int res=0;
        int[] book=new int[5];
        for (char c:croakOfFrogs.toCharArray())
        {
            book[getIdx(c)]++;
            if(!check1(book))return -1;
            res=Math.max(res,book[0]-book[4]);
        }
        return book[0]==book[4]?res:-1;


    }
    private boolean check1(int[] book) {
        for (int i=1;i<book.length;i++)
        {
            if(book[i]>book[i-1])return false;
        }
        return true;
    }

    private final static char[] CHARS={'c','r','o','a','k'};
    private int getIdx(char c)
    {
        for (int i=0;i<CHARS.length;i++)
        {
            if(c==CHARS[i])return i;
        }
        return -1;
    }

}
/*
给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。

注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。

如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。

 

示例 1：

输入：croakOfFrogs = "croakcroak"
输出：1
解释：一只青蛙 “呱呱” 两次
示例 2：

输入：croakOfFrogs = "crcoakroak"
输出：2
解释：最少需要两只青蛙，“呱呱” 声用黑体标注
第一只青蛙 "crcoakroak"
第二只青蛙 "crcoakroak"
示例 3：

输入：croakOfFrogs = "croakcrook"
输出：-1
解释：给出的字符串不是 "croak" 的有效组合。
示例 4：

输入：croakOfFrogs = "croakcroa"
输出：-1
 

提示：

1 <= croakOfFrogs.length <= 10^5
字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
