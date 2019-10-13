import org.junit.Test;

import java.util.Stack;

/**
 * @ProjectName: leetcode
 * @Package: cn.ustc
 * @ClassName: Test20
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/9/23 20:56
 * @Version: 1.0
 */
public class Test20 {

    @Test
    public void test() {

    }
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        if(s.isEmpty()) {
            return true;
        }
        for(int i = 0;i < len; i++) {
            char ch = s.charAt(i);
            if(stack.empty() && (ch != '(' && ch != '[' && ch != '{')) {
                return false;
            }
            switch (ch) {
                case '(' :
                case '{' :
                case '[' :
                    stack.push(ch);
                    break;
                case ')' :
                    if(stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']' :
                    if(stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}' :
                    if(stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }

        }
        if(!stack.empty()) {
            return false;
        }
        return true;
    }
}
