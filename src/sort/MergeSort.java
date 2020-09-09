package sort;

/**
 * 归并排序
 */
public class MergeSort {
    /**
     * 自顶向下的归并排序，用到的是递归
     * @param nums
     */
    public void mergeSortT2B(int[] nums,int left,int right){
        if(left==right) return;
        int mid = (left+right)/2;
        mergeSortT2B(nums,left,mid);    //先把左半边排好序
        mergeSortT2B(nums,mid+1,right); //再把右半边排好序
        merge(nums,left,mid,right); //左右合并
    }

    /**
     * 合并两个排序数组部分（left-mid)(mid+1,right)
     * @param nums
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] nums,int left,int mid,int right){
        int length = right-left+1;
        int[] temp = new int[length];   //一个用来暂存排序数组的数组
        int cur = 0;    //排序数组指针
        int lcur = left;    //左边数组指针
        int rcur = mid+1;   //右边数组指针
        while(lcur<=mid && rcur<=right){
            if(nums[lcur]<nums[rcur]){
                temp[cur] = nums[lcur];
                lcur++;
            }else {
                temp[cur] = nums[rcur];
                rcur++;
            }
            cur++;
        }
        while(lcur<=mid){
            temp[cur] = nums[lcur];
            cur++;
            lcur++;
        }
        while(rcur<=right){
            temp[cur] = nums[rcur];
            cur++;
            rcur++;
        }
        if (length >= 0) System.arraycopy(temp, 0, nums, left, length);
    }

    /**
     * 自底向上的归并排序
     * @param nums
     */
    public void mergeSortB2T(int[] nums){
        int length = nums.length;
        for (int x=1;x<length;x+=x){    //每一次归并的数组大小x，从1开始
            for (int y = 0; y < length-x; y+=2*x) { //每两个数组的起始元素下标y
                merge(nums,y,y+x-1,Math.min(y+2*x-1, length-1));
            }
        }
    }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums1 = ArrayUtils.getRandomArray(1000000);
        int[] nums2 = ArrayUtils.getRandomArray(1000000);
        long start = System.currentTimeMillis();
        mergeSort.mergeSortT2B(nums1,0,nums1.length-1);
        long end = System.currentTimeMillis();
        System.out.println("自顶向下耗时："+(end-start)+"ms");
        System.out.println();
        start = System.currentTimeMillis();
        mergeSort.mergeSortB2T(nums2);
        end = System.currentTimeMillis();
        System.out.println("自底向上耗时："+(end-start)+"ms");
    }
}
