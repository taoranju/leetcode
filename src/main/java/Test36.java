import java.util.HashMap;

/**
 * @ProjectName: leetcode
 * @Package: PACKAGE_NAME
 * @ClassName: Test36
 * @Author: 陶然居
 * @Description:
 * @Date: 2019/10/23 23:34
 * @Version: 1.0
 */
public class Test36 {
    /**
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * @param args
     * @return
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        boolean b = isValidSudoku(board);
        System.out.println(b);
    }
    public static boolean isValidSudoku(char[][] board) {
       //用3个hashMap数组来存储行列和小矩形的值
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        //初始化数组
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>(9);
            columns[i] = new HashMap<Integer, Integer>(9);
            boxes[i] = new HashMap<Integer, Integer>(9);

        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = (int)board[i][j];
                    System.out.println(num);
                    int index = (i/3)*3 + j/3;
                    if (rows[i].containsValue(num)) {
                        return false;
                    } else {
                        rows[i].put(num, num);
                    }

                    if (columns[j].containsValue(num)) {
                        return false;
                    } else {
                        columns[j].put(num, num);
                    }

                    if (boxes[index].containsValue(num)) {
                        return false;
                    } else {
                        boxes[index].put(num, num);
                    }
                }
            }
        }
        return true;
    }
}
