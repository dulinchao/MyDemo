import java.util.*;

class Solution {
    int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};   //右下左上
    int[][] flags;  //标志是否被访问，0为未被访问，1为被访问
    List<Integer> res;
    public List<Integer> spiralOrder(int[][] nums) {
        res = new ArrayList<Integer>();
        int nr = nums.length;
        if(nr==0) return res;
        int nc = nums[0].length;
        flags = new int[nr][nc];

        flags[0][0] = 1;
        res.add(nums[0][0]);
        findNext(nums,0,0,0);

        return res;
    }
    private void findNext(int[][] nums, int r, int c,int index) {
        int i=index;
        for(int j=0;j<3;j++){
            int nr = r + direct[i][0];
            int nc = c + direct[i][1];
            if(inArea(nums, nr, nc) && flags[nr][nc]==0){
                flags[nr][nc] = 1;
                res.add(nums[nr][nc]);
                findNext(nums, nr, nc,i);
            }
            i = (i+1)%4;
        }
    }
    private boolean inArea(int[][] nums, int r, int c){
        if(r>=0 && c>=0 && r<nums.length && c<nums[0].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = solution.spiralOrder(nums);
        int i=0;
    }
}