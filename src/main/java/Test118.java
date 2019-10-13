import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test118
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/4 23:39
 * @Version: 1.0
 */
public class Test118 {
    /**
     * 杨辉三角
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        /**
         * 思路：先找规律，三角形的倒V型值均为1，从第三行起，其第二个数到倒数第二个数值为
         * 上一行对应两位值之和
         * lists.get(i-2).get(j-1) + lists.get(i-2).get(j)
         */
        List<List<Integer>> lists = new LinkedList<List<Integer>>();
        for(int i = 1;i <= numRows;i++) {
            List<Integer> list = new LinkedList<Integer>();
            list.add(0,1);
            for(int j = 1;j < i-1;j++) {
                list.add(j,lists.get(i-2).get(j-1) + lists.get(i-2).get(j));
            }
            if(i != 1) {
                list.add(i-1,1);
            }
            lists.add(i-1,list);
        }
        return lists;
    }
}
