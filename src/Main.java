


import javafx.util.Pair;

import java.util.*;

public class Main {
    /**
     * 寻找此用例的最长连续动作
     *
     * @return 返回最大值
     */
    private static int findMax() {
        int max = 0;    //记录最长次数
        Map<Pair<Integer, Integer>, Integer> pre = new HashMap<>();   //上一帧map
        Map<Pair<Integer, Integer>, Integer> now = new HashMap<>();   //此帧map
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); //帧数
        for (int i = 0; i < m; i++) {
            int actNum = sc.nextInt();//动作数
            for (int j = 0; j < actNum; j++) {
                Pair<Integer, Integer> pair = new Pair<>(sc.nextInt(), sc.nextInt());
                int value = pre.getOrDefault(pair, 0) + 1;
                now.put(pair, value);
                if (value > max) max = value;
            }
            pre = now;
            now = new HashMap<>();
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(findMax());
        }
    }
}
