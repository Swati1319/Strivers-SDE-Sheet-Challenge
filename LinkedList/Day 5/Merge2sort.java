import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

		// Write your code here.
        if(first == null){
            return second;
        }

        if(second == null){
            return first;
        }


        LinkedListNode<Integer> head;


        if(first.data < second.data){
            head = first;
            head.next = sortTwoLists(first.next, second);
        }
        else {
            head = second;
            head.next = sortTwoLists(first, second.next);
        }
        
        return head;
	}
}
