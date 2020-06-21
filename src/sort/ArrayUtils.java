package sort;

import java.util.ArrayList;

public class ArrayUtils {
    /**
     * 获取一个大小为num的随机数组
     * @param num
     * @return
     */
    public static int[] getRandomArray(int num){
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            int v = (int) (Math.random() * Integer.MAX_VALUE);
            nums[i] = v;
        }
        return nums;
    }
}
