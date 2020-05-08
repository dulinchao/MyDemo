import Tree.TreeNode;
import Tree.TreeUtils;

import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            dp[i] = 1;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<i;j++){
                if(nums[i-1]>nums[j-1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for(int i=0;i<n+1;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {1,3,6,7,9,4,10,5,6};
        int bag = new Solution().lengthOfLIS(coins);
        System.out.println(bag);
    }
}
