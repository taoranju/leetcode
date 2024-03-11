import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFSCode {

    public static void main(String[] args) {
        BFSCode code = new BFSCode();
        Set<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();
        set.add(new Pair<Integer, Integer>(1,2));
        Pair cur = new Pair<Integer, Integer>(1,2);
        System.out.println(set.contains(cur));
    }

    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> deads = new HashSet<String>();
        for (String s : deadends) {
            deads.add(s);
        }
        queue.add("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                if (deads.contains(cur)) {
                    continue;
                }
                for (int j = 0; j < cur.length(); j++) {
                    addQueue(queue, visited, cur, j);
                }
            }
            step++;
        }
        return -1;
    }

    private void addQueue(Queue<String> queue, Set<String> visited, String cur, int j) {
        char[] charArray = cur.toCharArray();
        char ch = charArray[j];
        // 加
        if (ch == '9') {
            charArray[j] = '0';
        } else {
            charArray[j] = (char) (ch + 1);
        }
        String up = new String(charArray);
        if (!visited.contains(up)) {
            queue.add(up);
            visited.add(up);
        }
        // 减
        if (ch == '0') {
            charArray[j] = '9';
        } else {
            charArray[j] = (char) (ch - 1);
        }
        String down = new String(charArray);
        if (!visited.contains(down)) {
            queue.add(down);
            visited.add(down);
        }
    }

    /**
     给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
            return -1;
        }
        int step = 1;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        Set<Pair<Integer, Integer>> visited = new HashSet<Pair<Integer, Integer>>();
        queue.add(new Pair<Integer, Integer>(0 ,0));
        visited.add(new Pair<Integer, Integer>(0 ,0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> cur = queue.poll();
                Integer key = cur.getKey();
                Integer value = cur.getValue();
                if (key == n-1 && value == n-1) {
                    return step;
                }
                // 将符合条件的节点加到队列中 值为0且不在visited中
                if (key-1 >= 0) {
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(key - 1, value);
                    if (grid[key-1][value] == 0 && !visited.contains(pair)) {
                        queue.add(pair);
                        visited.add(pair);
                    }
                    if (value-1 >= 0 ) {
                        pair = new Pair<Integer, Integer>(key - 1, value - 1);
                        if (grid[key-1][value-1] == 0 && !visited.contains(pair)) {
                            queue.add(pair);
                            visited.add(pair);
                        }
                    }
                    if (value+1 <= n-1) {
                        pair = new Pair<Integer, Integer>(key - 1, value + 1);
                        if (grid[key-1][value+1] == 0 && !visited.contains(pair)) {
                            queue.add(pair);
                            visited.add(pair);
                        }
                    }
                }
                if (key+1 <= n-1) {
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(key + 1, value);
                    if (grid[key+1][value] == 0 && !visited.contains(pair)) {
                        queue.add(pair);
                        visited.add(pair);
                    }
                    if (value-1 >= 0 ) {
                        pair = new Pair<Integer, Integer>(key + 1, value - 1);
                        if (grid[key+1][value-1] == 0 && !visited.contains(pair)) {
                            queue.add(pair);
                            visited.add(pair);
                        }
                    }
                    if (value+1 <= n-1) {
                        pair = new Pair<Integer, Integer>(key + 1, value + 1);
                        if (grid[key+1][value+1] == 0 && !visited.contains(pair)) {
                            queue.add(pair);
                            visited.add(pair);
                        }
                    }
                }
                if (value-1 >= 0) {
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(key, value - 1);
                    if (grid[key][value-1] == 0 && !visited.contains(pair)) {
                        queue.add(pair);
                        visited.add(pair);
                    }
                }
                if (value+1 <= n-1) {
                    Pair<Integer, Integer> pair = new Pair<Integer, Integer>(key, value + 1);
                    if (grid[key][value+1] == 0 && !visited.contains(pair)) {
                        queue.add(pair);
                        visited.add(pair);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair<Integer, Integer>(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Pair<Integer, Integer> cur = queue.poll();
                int m = cur.getKey();
                int n = cur.getValue();
                // 上
                if (m-1 >= 0 && mat[m-1][n] == -1) {
                    mat[m-1][n] = mat[m][n] + 1;
                    queue.add(new Pair<Integer, Integer>(m-1, n));
                }
                // 下
                if (m+1 <= row-1 && mat[m+1][n] == -1) {
                    mat[m+1][n] = mat[m][n] + 1;
                    queue.add(new Pair<Integer, Integer>(m+1, n));
                }
                // 左
                if (n-1 >= 0 && mat[m][n-1] == -1) {
                    mat[m][n-1] = mat[m][n] + 1;
                    queue.add(new Pair<Integer, Integer>(m, n-1));
                }
                // 右
                if (n+1 <= col-1 && mat[m][n+1] == -1) {
                    mat[m][n+1] = mat[m][n] + 1;
                    queue.add(new Pair<Integer, Integer>(m, n+1));
                }
            }
        }
        return mat;
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                if (maze[row][col] == '.' && (row == 0 || row == m-1 || col == 0 || col == n-1)) {
                    return step;
                }
                maze[row][col] = '+';
                // 上
                if (row-1 >= 0 && maze[row-1][col] == '.') {
                    queue.add(new int[]{row-1, col});
                }
                // 下
                if (row+1 <= m-1 && maze[row+1][col] == '.') {
                    queue.add(new int[]{row+1, col});
                }
                // 左
                if (col-1 >= 0 && maze[row][col-1] == '.') {
                    queue.add(new int[]{row, col-1});
                }
                // 右
                if (col+1 <= n-1 && maze[row][col+1] == '.') {
                    queue.add(new int[]{row, col+1});
                }
            }
            step++;
        }
        return -1;
    }


}
