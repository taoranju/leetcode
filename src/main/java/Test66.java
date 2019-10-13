/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test66
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/28 22:56
 * @Version: 1.0
 */
public class Test66 {
    public int[] plusOne(int[] digits) {
        //遇见大数，int型存储不下，用数组来求解
        for(int i = digits.length-1; i >= 0; i--) {
            if(digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        //for循环完了，即表明数组为99999...
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
