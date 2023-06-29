public class Solution {
    public static Node firstNode(Node head) {
        // Write your code here.
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        Node ans = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                while(ans != slow){
                    ans = ans.next;
                    slow = slow.next;
                }
                return ans;
            }
        }
        return null;
    }
}
