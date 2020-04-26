package sort;

public class BubbleSort {
    public static void sort(int[] nums){
        int length = nums.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,45,1,2,3,54,1,2,4};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
