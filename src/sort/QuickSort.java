package sort;

public class QuickSort {
    public void sort(int[] nums,int l,int r){
        if(l>=r) return;
        int left = l;
        int right = r;
        int x = nums[left];
        while(left<right){
            while(left<right){
                if(nums[right]>x){
                    nums[left] = nums[right];
                    break;
                }
                right--;
            }
            while(left<right){
                if(nums[left]<x){
                    nums[right] = nums[left];
                    break;
                }
                left++;
            }
        }
        nums[left] = x;
        sort(nums,l,left-1);
        sort(nums,left+1,r);
    }

    public static void main(String[] args) {
        int[] nums = {5,1,2,2,4,6};
        new QuickSort().sort(nums,0,nums.length-1);
        for(int n:nums){
            System.out.print(n);
        }
    }
}
