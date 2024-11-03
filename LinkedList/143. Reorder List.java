/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 *
 * Approach: Find the middle of the linked list and reverse it, and then merge both the links together.
 * */
class Solution {

    /** Reversing a node*/
    public ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null) {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    /**Getting middle node*/
    public ListNode getMiddleNode(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode ans = slow.next;
        slow.next=null;
        return ans;
    }

    /** merging two lists with head first and second respectively
     * first is the head of first half of linked list and
     * second is the head of the second half of the reverse linked list
     * below is the merging function for both.*/
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        ListNode mid = getMiddleNode(head);
        ListNode second = reverse(mid);
        ListNode first = head;
        while(second!=null) {
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;
            first=temp1;
            second=temp2;
        }
    }
}