public class Test2060 {

    public static void main(String[] args) {
        Test2060 test2060 = new Test2060();
        int[] player1 = new int[]{9,7,10,7};
        int[] player2 = new int[]{10,2,4,10};
        int res = test2060.isWinner(player1, player2);
        System.out.println(res);
    }
    /**
     * 保龄球游戏的获胜者
     * @param player1
     * @param player2
     * @return
     */
    public int isWinner(int[] player1, int[] player2) {
        int sum1 = 0;
        // 前两个值较大一个
        int pre1 = 0;
        boolean flag1 = false;
        int sum2 = 0;
        int pre2 = 0;
        boolean flag2 = false;
        for (int i = 0; i < player1.length; i++) {
             int score = player1[i];
            if (flag1) {
                sum1 += score * 2;
            } else {
                sum1 += score;
            }
            // flag放后面处理
            if (score == 10 || pre1 == 10) {
                flag1 = true;
            } else {
                flag1 = false;
            }
            pre1 = score;

        }
        for (int j = 0; j < player2.length; j++) {
            int score = player2[j];
            if (flag2) {
                sum2 += score * 2;
            } else {
                sum2 += score;
            }
            // flag放后面处理
            if (score == 10 || pre2 == 10) {
                flag2 = true;
            } else {
                flag2 = false;
            }
            pre2 = score;
        }


        if (sum1 > sum2) {
            return 1;
        } else if (sum1 < sum2) {
            return 2;
        } else {
            return 0;
        }
    }
}
