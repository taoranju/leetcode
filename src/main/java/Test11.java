/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test11
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/16 22:41
 * @Version: 1.0
 */

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
*/
public class Test11 {
    /**
     * 1、暴力破解法
     * 2、双指针法，选取距离远，边长的
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int l = height[i] > height[j] ? height[j] : height[i];
                int h = j - i;
                if (res < l * h) {
                    res = l * h;
                }
            }
        }
        return res;
    }

    public int maxArea1(int[] height) {
        int num;
        int res1 = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] > height[right]) {
                num = height[right]*(right - left);
                right--;
            } else {
                num = height[left]*(right - left);
                left++;
            }
            res1 = res1 > num ? res1 : num;
        }
        return res1;
    }
}
