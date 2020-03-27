import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length==0) return false;
        int l = 0;
        int r = nums.length<k+1?nums.length-1:k;
        int[] flag = new int[10];
        for(int i=0;i<=r;i++){
            if(flag[nums[i]]>0) return true;
            flag[nums[i]]++;
        }
        while(r<nums.length-1){
            flag[nums[l]]--;
            if(flag[nums[r+1]]>0) return true;
            flag[nums[r+1]]++;
            l++;
            r++;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        boolean b = solution.containsNearbyDuplicate(nums, 3);
        int i=0;
    }
}