import java.util.Stack;

public class Queue {

    private Stack<Integer> st1;    

    private Stack<Integer> st2;

 

    Queue() {

        st1 = new Stack<Integer>();        

        st2 = new Stack<Integer>();

    }

 

    void enQueue(int val) {

        st1.push(val);

    }

 

    int deQueue() {

        if(isEmpty()){

            return -1;

        }

        while(!st1.isEmpty()){

            st2.push(st1.pop());

        }

        int removed = st2.pop();

        while(!st2.isEmpty()){

            st1.push(st2.pop());

        }

        return removed;

    }

 

    int peek() {

        if(isEmpty()){

            return -1;

        }

        while(!st1.isEmpty()){

            st2.push(st1.pop());

        }

        int peeked = st2.peek();

        while(!st2.isEmpty()){

            st1.push(st2.pop());

        }

        return peeked;

    }

 

    boolean isEmpty() {

        if(st1.isEmpty()){

            return true;

        }

        return false;

    }

}
