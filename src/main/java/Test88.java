/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test88
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/1 22:34
 * @Version: 1.0
 */
public class Test88 {
    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 方法1：先和并，在排序
         * 方法2：双指针，从前往后
         * 方法3：双指针，从后向前
         */
        int i = 0;
        int j = 0;
        int k;
        while(i < m+n && j < n) {
            if(nums1[i] > nums2[j]) {
                for(k = m+j;k > i;k--) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
                i++;
            } else {
                i++;
            }
        }
        if(j != n) {
            for(k = m+j;k < m+n;k++) {
                nums1[k] = nums2[j++];
            }
        }
    }
}
