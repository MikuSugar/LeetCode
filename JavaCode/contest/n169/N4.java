package JavaCode.contest.n169;

import java.util.*;

/**
 * author:fangjie
 * time:2020/1/26
 */
public class N4 {

    //超时待修改
    public static void main(String[] args) {
        //["SEIS","CATORCE","SETENTA"]
        //"NOVENTA"
        System.out.println(new N4().isSolvable(new String[]{"SEIS","CATORCE","SETENTA"},"NOVENTA"));
    }
    public boolean isSolvable(String[] words, String result) {
        int[] book=new int[26];
        Arrays.fill(book,-1);
        Set<Character> set=new HashSet<>();
        Set<Character> setF=new HashSet<>();
        for (String w:words)
        {
            char[] s=w.toCharArray();
            for (char c:s)set.add(c);
            setF.add(s[0]);
        }
        setF.add(result.charAt(0));
        for (char c:result.toCharArray())set.add(c);
        Character[] array=set.toArray(new Character[0]);
        boolean[] used=new boolean[10];
        return slove(0,array,used,book,setF,words,result);
    }

    private boolean slove(int idx, Character[] array, boolean[] used, int[] book, Set<Character> setF, String[] words, String result) {
        if(idx==array.length)return check(book,words,result);
        if(!setF.contains(array[idx])&&!used[0]){
            book[array[idx]-'A']=0;
            used[0]=true;
            if(slove(idx+1,array,used,book,setF,words,result))return true;
            used[0]=false;
        }
        for (int i=1;i<10;i++)
        {
            if(used[i])continue;
            book[array[idx]-'A']=i;
            used[i]=true;
            if(slove(idx+1,array,used,book,setF,words,result))return true;
            used[i]=false;
        }
        return false;

    }

    private boolean check(int[] book, String[] words, String result) {
        int sum=0;
        for (String s:words)sum+=decode(book,s);
        return sum==decode(book,result);
    }

    private int decode(int[] book, String s) {
        char[] strs=s.toCharArray();
        for (int i=0;i<strs.length;i++)
        {
            strs[i]=(char) ('0'+book[strs[i]-'A']);
        }
//        System.out.println(s);
//        System.out.println(new String(strs));
        return Integer.parseInt(new String(strs));
    }
}
/*
给你一个方程，左边用 words 表示，右边用 result 表示。

你需要根据以下规则检查方程是否可解：

每个字符都会被解码成一位数字（0 - 9）。
每对不同的字符必须映射到不同的数字。
每个 words[i] 和 result 都会被解码成一个没有前导零的数字。
左侧数字之和（words）等于右侧数字（result）。 
如果方程可解，返回 True，否则返回 False。

 

示例 1：

输入：words = ["SEND","MORE"], result = "MONEY"
输出：true
解释：映射 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
所以 "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
示例 2：

输入：words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
输出：true
解释：映射 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
所以 "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
示例 3：

输入：words = ["THIS","IS","TOO"], result = "FUNNY"
输出：true
示例 4：

输入：words = ["LEET","CODE"], result = "POINT"
输出：false
 

提示：

2 <= words.length <= 5
1 <= words[i].length, results.length <= 7
words[i], result 只含有大写英文字母
表达式中使用的不同字符数最大为 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/verbal-arithmetic-puzzle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
