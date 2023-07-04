import java.util.* ;

import java.io.*; 

 

public class Stack {

    int[] st;

    int top=-1;

    int cap;

    Stack(int capacity){

        if(isFull()!=1){

        st=new int[capacity];

        this.cap=capacity;

        }

    }

    

    void push(int num) {

        top=top+1;

        st[top]=num;

        

    }

    int pop() {

        if(isEmpty()!=1){

        int x=st[top];

        top=top-1;

        return x;

        }

        else{

            return -1;

        }

    }

    int top() {

        if(isEmpty()!=1){

          return st[top];  

        }

        else{

            return -1;

        }

    }

    int isEmpty() {

        if(top==-1){

            return 1;

        }

        else{

            return 0;

        }

    }

    int isFull() {

        if(top==cap){

            return 1;

        } 

        else{

            return 0;

        }

    }

}
