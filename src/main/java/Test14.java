/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test14
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/25 19:06
 * @Version: 1.0
 */

/**
 * 所有输入只包含小写字母 a-z
 */
public class Test14 {
    public String longestCommonPrefix(String[] strs) {
        //判断数组非空
        if(strs == null || strs.length == 0) {
            return "";
        }
        //以第一个数组为基础
        for(int i = 0; i < strs[0].length(); i++) {
            char a = strs[0].charAt(i);
            //取第一个数组元素与其他数组相同位置的元素进行比较
            for(int j = 1; j < strs.length; j++) {
                //此处除了需要判等外，还需要判断其他数组长度
                if(i >= strs[j].length() || strs[j].charAt(i) != a) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];

    }

}
