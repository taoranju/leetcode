import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test204
 * @Author: 陶然居
 * @Description:
 * @Date: 2020/1/2 22:03
 * @Version: 1.0
 */
public class Test204 {
    /**
     * 判断质数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flags[i]) {
                for (int j = 2*i; j < n; j = j + i) {
                    flags[j] = false;
                }
            }
        }
        for (boolean flag : flags) {
            if (flag) {
                count++;
            }
        }
        return count-2;
    }

    /**
     * 优化
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        int count = 0;
        for (int i = 2; i*i < n; i++) {
            if (flags[i]) {
                for (int j = i*i; j < n; j = j + i) {
                    flags[j] = false;
                }
            }
        }
        for (boolean flag : flags) {
            if (flag) {
                count++;
            }
        }
        return count-2;
    }

    /**
     * 快乐数
     * 双指针法
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = getNumber(slow);
            fast = getNumber(fast);
            fast = getNumber(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public Integer getNumber(int num) {
        int res = 0;
        while (num > 0) {
            int a = num % 10;
            res = res + a*a;
            num = num/10;
        }
        return res;
    }


    /**
     * 同构字符串
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) != t.indexOf(chart[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else if (map.containsValue(t.charAt(i))){
                return false;
            } else {
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
