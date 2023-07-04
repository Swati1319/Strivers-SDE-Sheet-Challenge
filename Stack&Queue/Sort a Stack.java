import java.util.*;

 

public class Solution {

    public static void insertInSort(Stack<Integer> s, int num) {

        if (s.empty() || s.peek() < num) {

            s.push(num);

            return;

        }

        int temp = s.pop();

        insertInSort(s, num);

        s.push(temp);

    }

 

    public static void sortStack(Stack<Integer> stack) {

        if (stack.empty())

            return;

        int num = stack.pop();

        sortStack(stack);

        insertInSort(stack, num);

    }

 

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        // Add elements to the stack

        

        sortStack(stack);

        System.out.println(stack);

    }

}
