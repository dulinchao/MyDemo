import Tree.TreeNode;
import Tree.TreeUtils;

import java.util.*;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[m+1];
        dp[1] = 1;
        for(int i=0;i<n;i++){
            for(int j=2;j<m+1;j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int fib = new Solution().uniquePaths(7,3);
        System.out.println(fib);
    }
}
