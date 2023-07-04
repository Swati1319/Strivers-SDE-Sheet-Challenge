import java.util.* ;

import java.io.*; 

public class Stack {

    private Deque<Integer> queue1;    

 

    public Stack() {

        queue1 = new ArrayDeque<Integer>();        

    }

 

    /*----------------- Public Functions of Stack -----------------*/

 

    public int getSize() {

        return queue1.size();

    }

 

    public boolean isEmpty() {

        if(queue1.isEmpty()){

            return true;

        }

        return false;

    }

 

    public void push(int element) {

        queue1.push(element);

    }

 

    public int pop() {

        if(isEmpty()){

            return -1;

        }

        return queue1.poll();

    }

 

    public int top() {

         if(isEmpty()){

            return -1;

        }

 

        return queue1.getFirst();

    }

}
