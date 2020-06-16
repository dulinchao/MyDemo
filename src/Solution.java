import Tree.TreeNode;
import Tree.TreeUtils;
import com.sun.org.apache.bcel.internal.generic.LUSHR;

import java.util.*;
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur.next.next = null;
            cur = cur.next;
        }
        if(l1!=null) cur.next = l1;
        if(l2!=null) cur.next = l2;
        return dummyHead.next;
    }
}