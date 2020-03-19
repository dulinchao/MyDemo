public class HeapSort {
    /**
     * 用于每一次构造一个大顶堆
     * @param arr 数组
     * @param length 当前大顶堆所对应长度
     */
    public void heapSort(int[] arr,int length){
        for(int i=(length-2)/2;i>=0;i--){
            heapfy(arr,i,length);
        }
    }

    /**
     * 用于将每一个节点大顶堆化
     * @param arr 数组
     * @param root 当前节点
     * @param length 当前大顶堆对应长度
     */
    private void heapfy(int[] arr, int root, int length) {
        int left = root*2 + 1;  //左子节点的下标
        int right = root*2 + 2; //右子节点的下标
        int max_index = left;    //表示左右子节点较大的那个下标，默认为left，一会儿交换的就是这个
        if(right<length){   //当存在右子节点时，取最大的
            max_index = arr[left]>arr[right]?left:right;
        }
        if(arr[root]<arr[max_index]){   //假如不符合大顶堆要求
            int temp = arr[root];
            arr[root] = arr[max_index];
            arr[max_index] = temp;  //交换两个值
            if(max_index<=(length-2)/2){    //当子节点不是叶子节点时，才需要对子节点堆化
                heapfy(arr,max_index,length);   //为防止交换后子节点不符合大顶堆了，就重新对它大顶堆化
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,1,6,4};
        HeapSort heapSort = new HeapSort();
        for(int i=arr.length-1;i>0;i--){    //i从数组后向前遍历，负责控制每次堆排序的长度
            heapSort.heapSort(arr,i+1);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;  //交换头尾元素
        }
    }
}
