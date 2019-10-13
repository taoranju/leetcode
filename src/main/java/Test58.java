/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test58
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/28 19:36
 * @Version: 1.0
 */

public class Test58 {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * 如果不存在最后一个单词，请返回 0 。
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        /**
         * 从后向前遍历
         */
        int res = 0;
//        for(int i = 0;i < s.length();i++) {
//            if(s.charAt(i) != ' ') {
//                res++;
//            } else if(i < s.length()-1){
//                if(s.charAt(i+1) != ' ') {
//                    res = 0;
//                }
//            }
//        }

        for(int i = s.length()-1;i >= 0;i--) {
            if(s.charAt(i) != ' ') {
                res++;
            } else if(res > 0){
                return res;
            }
        }
        return res;
    }
}
