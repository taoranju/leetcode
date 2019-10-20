/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test17
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/20 23:35
 * @Version: 1.0
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合
 */
public class Test17 {
    /**
     * 大佬的解法太牛逼了
     * 完美的的使用了链表的尾插法和删除
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<String>();
        String[] mapping = new String[]{"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if("".equals(digits) || digits == null) {
            return new LinkedList<String>();
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //确定传入字符对应的字符串
            int index = Character.getNumericValue(digits.charAt(i));
            //此处判断是否为老数据
            while (res.peek().length() == i) {
                //移出当前链表首元素
                String s = res.remove();
                //添加新元素
                for (char ch : mapping[index].toCharArray()) {
                    res.add(s + ch);
                }
            }
        }
        return res;
    }

}
