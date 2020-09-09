package list;

public class ListUtils {
    public static ListNode getList(int[] nums){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for (Integer num : nums) {
            ListNode temp = new ListNode(num);
            cur.next = temp;
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
