/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test07
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/24 22:35
 * @Version: 1.0
 */

/**
 * 字符串转整数
 * 第一种方法：i=Integer.parseInt(s);
 * 第二种方法：i=Integer.valueOf(s).intValue();
 */

/**
 * 不适合用字符串方法做，在字符串转整数会存在溢出现象
 */
public class Test07 {
//    public int reverse(int x) {
//        int num = 0;
//        String s = Integer.toString(x);
//        Stack<Character> stack = new Stack<>();
//        String res = "";
//        if(x >= 0) {
//            for(int i = 0; i < s.length(); i++) {
//                stack.push(s.charAt(i));
//            }
//            for(int j = 0; j < s.length(); j++) {
//                res = res + stack.pop();
//            }
//            num = Integer.parseInt(res.trim());
//        } else {
//            for(int i = 1; i < s.length(); i++) {
//                stack.push(s.charAt(i));
//            }
//            for(int j = 0; j < s.length() - 1; j++) {
//                res = res + stack.pop();
//            }
//            num = Integer.parseInt(res.trim());
//            num = -num;
//        }
//
//        return  num;
//    }

    public int reverse(int x) {
        long num = 0;
        while (x != 0) {
            num = num*10 + x%10;
            x = x/10;
        }
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            num = 0;
        }
        return (int) num;
    }
}
