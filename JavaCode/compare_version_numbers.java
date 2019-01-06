package JavaCode;

public class compare_version_numbers {
    class Solution {
        public int compareVersion(String version1, String version2) {

            /**
             * 把版本号切割成数组
             */
            String[] v1s=version1.split("[.]");
            String[] v2s=version2.split("[.]");

            /**
             * 遍历数组
             * 位数不一样补0
             */
            int n=Math.max(v1s.length,v2s.length);
            for(int i=0;i<n;i++)
            {
                int v1,v2;
                if(i<v1s.length)
                {
                    v1=Integer.parseInt(v1s[i]);
                }
                else
                {
                    v1=0;
                }

                if(i<v2s.length)
                {
                    v2=Integer.parseInt(v2s[i]);
                }
                else
                {
                    v2=0;
                }

                /**
                 * 比较版本大小
                 */
                if(v1>v2)
                {
                    return 1;
                }
                else if(v1<v2)
                {
                    return -1;
                }
            }
            /**
             * 如果全部遍历完没返回说明相等
             */
            return 0;

        }
    }
}
/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *  . 字符不代表小数点，而是用于分隔数字序列。
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *
 * 示例 1:
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 */
