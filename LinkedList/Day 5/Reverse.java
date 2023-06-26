public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        // Write your code here!
		LinkedListNode<Integer> newHead = null;
		while(head != null)
		{
			LinkedListNode<Integer> next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}

		return newHead;
    }
}
