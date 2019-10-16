/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test06
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/16 23:04
 * @Version: 1.0
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */
public class Test06 {
    /**
     * Z字的长和宽相同，均为numRows
     * 思路：按行索引
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        //初始化数组
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0 ; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int j = 0;
        int flage = -1;
        //精华所在
        for (char ch : s.toCharArray()) {
            list.get(j).append(ch);
            //遇见转角处，反转
            if (j == 0 || j == numRows - 1) {
                flage = -flage;
            }
            j = j + flage;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder builder : list) {
            res = res.append(builder);
        }
        return res.toString();
    }
}
