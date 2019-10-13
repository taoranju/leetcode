/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test28
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/1 23:51
 * @Version: 1.0
 */
public class Test28 {
    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                //i和j对应，每次后移一位
                i = i - j + 1;
                j = 0;
            }
        }
        if(j != needle.length()) {
            return -1;
        } else {
            return i-j;
        }
    }
}
