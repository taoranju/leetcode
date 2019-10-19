import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test12
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/19 19:24
 * @Version: 1.0
 */
public class Test12 {
    /**
     * 整数转罗马数字
     * 1、if-else直接转
     * 2、贪心算法
     * @param num
     * @return
     */
    public String intToRoman1(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                res.append("M");
                num = num -1000;
            } else if (num >= 900 && num < 1000) {
                res.append("CM");
                num = num - 900;
            } else if (num >= 500 && num < 900) {
                res.append("D");
                num = num - 500;
            } else if (num >= 400 && num < 500) {
                res.append("CD");
                num = num - 400;
            } else if (num >= 100 && num < 400) {
                res.append("C");
                num = num - 100;
            } else if (num >= 90 && num < 100) {
                res.append("XC");
                num = num - 90;
            } else if (num >= 50 && num < 90) {
                res.append("L");
                num = num - 50;
            } else if (num >= 40 && num < 50) {
                res.append("XL");
                num = num - 40;
            } else if (num >= 10 && num < 40) {
                res.append("X");
                num = num - 10;
            } else if (num == 9) {
                res.append("IX");
                num = num - 9;
            } else if (num >= 5 && num < 9) {
                res.append("V");
                num = num - 5;
            } else if (num == 4) {
                res.append("IV");
                num = num - 4;
            } else {
                res.append("I");
                num--;
            }
        }
        return res.toString();
    }

    public String intToRoman2(int num) {
        int[] target = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for (int i = 0; i < target.length; i++) {
            if (num == 0) {
                break;
            }
            int k = num/target[i];
            for (int j = 0; j < k; j++) {
                res = res + str[i];
            }
            num = num - target[i]*k;
        }
        return res;
    }
}
