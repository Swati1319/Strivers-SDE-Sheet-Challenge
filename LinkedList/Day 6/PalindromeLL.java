public class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		// Write your code here!
		 LinkedListNode<Integer> slow = head;

        LinkedListNode<Integer> fast = head;

 

        // Find the middle of the linked list

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

        }

 

        // Reverse the second half of the linked list

        LinkedListNode<Integer> prev = null;

        LinkedListNode<Integer> curr = slow;

        while (curr != null) {

            LinkedListNode<Integer> next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;

        }

 

        // Compare the first half and second half of the linked list

        LinkedListNode<Integer> p1 = head;

        LinkedListNode<Integer> p2 = prev;

        while (p2 != null) {

            if (!p1.data.equals(p2.data)) {

                return false;

            }

            p1 = p1.next;

            p2 = p2.next;

        }

 

        return true;
	}
}
