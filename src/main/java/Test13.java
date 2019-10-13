/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test13
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/24 21:18
 * @Version: 1.0
 */
public class Test13 {
    public int romanToInt(String s) {
        int num = 0;
        int len = s.length();
        for(int i = 0; i < len ; i++) {
            if(i+1 < len) {
                if(res(s.charAt(i)) >= res(s.charAt(i+1))) {
                    num = num + res(s.charAt(i));
                } else {
                    num = num + res(s.charAt(i+1)) - res(s.charAt(i));
                    i++;
                }
            } else {
                num = num + res(s.charAt(i));
            }
        }
        return num;
    }

    public int res(char ch) {
        int num = 0;
        switch (ch) {
            case 'I' :
                num = 1;
                break;
            case 'V' :
                num =  5;
                break;
            case 'X' :
                num = 10;
                break;
            case 'L' :
                num = 50;
                break;
            case 'C' :
                num = 100;
                break;
            case 'D' :
                num = 500;
                break;
            case 'M' :
                num = 1000;
                break;
            default:
                System.out.println("error");
                break;
        }
        return num;
    }
}
