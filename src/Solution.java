import Tree.TreeNode;
import Tree.TreeUtils;

import java.util.*;

public class Solution {
    public int threeSumClosest(int[] nums,int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
            }
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution().minWindow("bbaac", "aba"));
//    }
}
