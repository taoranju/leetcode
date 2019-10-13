/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test38
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/28 18:18
 * @Version: 1.0
 */
public class Test38 {

    public String countAndSay(int n) {

        String res = "";
        if(n == 1) {
            return "1";
        }
        if(n == 2) {
            return getString("1");
        } else {
            res = getString(countAndSay(n-1));
        }
        return res;
    }

    public String getString(String str) {
        StringBuilder res = new StringBuilder();
        int len = str.length();
        int i = 0;
        int num = 1;
        while(i < len-1) {
            char c = str.charAt(i);
            if(c != str.charAt(i+1)) {
                res = res.append(num).append(c);
                num = 1;
            } else {
                num ++;
            }
            i++;
        }
        res = res.append(num).append(str.charAt(i));
        return res.toString().trim();
    }
}
