public class Queue {

    private int[] data;

    int end = 0;

 

    Queue() {

        // Implement the Constructor

        this.data = new int[5000];

    }

 

    /*----------------- Public Functions of Queue -----------------*/

 

    boolean isEmpty() {

        return end == 0;

    }

 

    void enqueue(int x) {

        data[end++] = x;

    }

 

    int dequeue() {

       if(isEmpty()){

           return -1;

       }

       int removed = data[0];

       for(int i=1; i<end; i++){

           data[i-1] = data[i];

       }

       end--; 

       return removed;

    }

 

    int front() {

        if(isEmpty()){

           return -1;

       }

        return data[0];

    }

 

}
