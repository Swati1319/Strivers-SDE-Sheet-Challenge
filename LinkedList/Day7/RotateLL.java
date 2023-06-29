public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
        if(head==null || head.next==null || k==0) return head;

 

        // calculate the length of the linkedlist

        int len = 1;

        Node temp = head;

        

        while(temp.next!=null){

            len++;

            temp = temp.next;

        }

        

        // shrink "k" by using the observations and applying the formula k = (k-len)%len

        temp.next = head;

        if(k>=len) k = (k-len)%len;

        

        int flag=0;

        temp = head;

        

        // reaching to the node from where we have to rotate which we have already calculated in k :

        while(flag!=(len-k)-1){

            flag++;

            temp = temp.next;

        }

 

        head = temp.next;

        temp.next = null;

 

        return head;
    }
}
