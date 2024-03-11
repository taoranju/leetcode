import java.util.HashMap;
import java.util.Map;

public class WindowCode {

    public static void main(String[] args) {
        WindowCode windowCode = new WindowCode();

    }

    /**
     * 最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        //初始化need
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 指针
        int left = 0;
        int right = 0;
        // 初始化
        int start = 0;
        int len = Integer.MAX_VALUE;
        int valid = 0;
        // 开始滑动，右侧指针
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (need.get(cur) != null) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (need.get(cur).equals(window.get(cur))) {
                    valid++;
                }
            }
            right++;
            // 窗口中的元素符合要求，开始滑左侧指针
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char ch = s.charAt(left);
                if (need.containsKey(ch)) {
                    if (window.get(ch).equals(need.get(ch))) {
                        valid--;
                    }
                    window.put(ch, window.get(ch) - 1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        //初始化need
        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 指针
        int left = 0;
        int right = 0;
        // 初始化
        int valid = 0;
        // 开始滑动，右侧指针
        while (right < s2.length()) {
            char cur = s2.charAt(right);
            if (need.get(cur) != null) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (need.get(cur).equals(window.get(cur))) {
                    valid++;
                }
            }
            right++;
            // 每当right-left=s1.length()时，做判断
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char ch = s2.charAt(left);
                if (need.containsKey(ch)) {
                    if (need.get(ch).equals(window.get(ch))) {
                        valid--;
                    }
                    window.put(ch, window.get(ch) - 1);
                }
                left++;
            }
        }
        return false;
    }

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            while (window.get(cur) > 1) {
                char ch = s.charAt(left);
                left++;
                window.put(ch, window.get(ch) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
