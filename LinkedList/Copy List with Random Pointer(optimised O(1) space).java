/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
* Here we are not using a map
 * 1. We are making a copy and storing each node adjacent to original node
 * 2. We are making the random pointers of the copy node to point to the random pointer of original node's copy
 * 3. We are now segregating both the lists
 **/

class Solution {
  public Node copyRandomList(Node head) {
    Node orgHead=head;
    Node head1 = head;
    if(head==null)
      return head;
    /** Making a copy and storing in adjacent node
     * If the original linked list is 1->2->3
     * Now, it will be 1->1->2->2->3->3
     * */
    while(orgHead!=null) {
      Node newNode=new Node(orgHead.val);
      newNode.next = orgHead.next;
      orgHead.next = newNode;
      orgHead=newNode.next;
    }
    /**
     * Now we are making the random pointers of the copy node to point to the random pointer of original node's copy
     * */
    Node copy=head;
    Node head2=copy.next;
    while(copy!=null) {
      if(copy.random!=null) {
        copy.next.random = copy.random.next;
      }
      else {
        copy.next.random=null;
      }
      copy=copy.next.next;
    }
    /**
     * Now we are segregating the lists by making two different lists of the original by restoring it and making a different
     * list for the copy node.
     * */
    copy=head;
    Node n1 = head.next;
    Node n2 = head.next;
    while(copy!=null) {
      copy.next=copy.next.next;
      if(n2.next!=null)
        n2.next = n2.next.next;
      else
        n2.next=null;
      copy=copy.next;
      n2=n2.next;
    }
    return n1;
  }
}