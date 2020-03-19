public class Spiral {
    int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
    int[][] flags;  //标志是否被访问，0为未被访问，1为被访问
    public void spiralPrint(int[][] nums){
        int nr = nums.length;
        if(nr==0) return;
        int nc = nums[0].length;
        flags = new int[nr][nc];

        flags[0][0] = 1;
        System.out.print(nums[0][0]);
        findNext(nums,0,0);
    }

    private void findNext(int[][] nums, int r, int c) {
        for(int[] d:direct){
            if(r+d[0]>=0 && c+d[1]>=0 && r+d[0]<nums.length && c+d[1]<nums[0].length && flags[r+d[0]][c+d[1]]==0){
                flags[r+d[0]][c+d[1]] = 1;
                System.out.print(nums[r+d[0]][c+d[1]]);
                findNext(nums,r+d[0],c+d[1]);
            }
        }
    }

    public static void main(String[] args) {
        Spiral spiral = new Spiral();
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        spiral.spiralPrint(nums);
    }
}
