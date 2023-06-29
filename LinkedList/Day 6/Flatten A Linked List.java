public class Solution {
     public static Node flattenLinkedList(Node head) {
         if(head == null || head.next == null) return head;
         Node left = head;
         Node right = head.next;
         head.next = null;
         right = flattenLinkedList(right);
         return merge(left, right); 
         }
        public static Node merge(Node left, Node right){
            if(left == null){
                return right;
                }
                if(right == null)
                 return left;
                Node ans = new Node(-1);
                Node tail = ans;
                Node l = left;
                Node r = right;
                while(l != null && r != null){
                    if(l.data < r.data){
                        tail.child = l;
                        tail = l;
                        l = l.child;
                        }
                    else{
                        tail.child = r;
                        tail = r;
                        r = r.child;
                        }
                }
                while(l != null){
                    tail.child = l;
                    tail = l;
                    l = l.child;
                    }
                while(r != null){
                    tail.child = r;
                    tail = r;
                    r = r.child;
                    }
                return ans.child;
                } 
                
                }
