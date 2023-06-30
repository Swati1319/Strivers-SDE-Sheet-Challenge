public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Write your code here.
		   boolean flag = false;
         LinkedListNode<Integer> root = null;
         LinkedListNode<Integer> prev = null;
        while(head!=null)
        {
            LinkedListNode<Integer> next =null;
             LinkedListNode<Integer> random =null;


           if(head.next!=null)
           {
                    next = new LinkedListNode(head.next.data);
           }
            if(head.random!=null)
            {
                    random = new LinkedListNode(head.random.data);
            }
        
            LinkedListNode<Integer> curr = new LinkedListNode(head.data);
            curr.next = next;
            curr.random = random;
            if(prev!=null)
            {
                prev.next = curr;
            }
            if(!flag)
            {
                root = curr;
                flag = true;
            }
            prev = curr;
            head = head.next;
        }


        return root;
	}
}
