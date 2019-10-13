/**
 * @ProjectName: leetcode01
 * @Package: PACKAGE_NAME
 * @ClassName: Test48
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/13 22:16
 * @Version: 1.0
 */

/**
 * 给定一个 n × n 的二维矩阵表示一个图像
 * 将图像顺时针旋转 90 度
 */
public class Test48 {
    /**
     * 先转置矩阵，在反转每一行
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //转置，延对角巷交换元素
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //反转
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = tmp;
            }
        }

    }
}
