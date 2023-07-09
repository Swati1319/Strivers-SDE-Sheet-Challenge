import java.util.*;
import java.io.*;

public class Solution {

    public static List < Integer > getPostOrderTraversal(TreeNode root) {

        // Create answer array to store traversal.
        List < Integer > answer = new ArrayList < Integer > ();

        // Base case.
        if (root == null) {
            return answer;
        }

        // 'PREDECESSOR' and 'CURRENT' will store predecessor and current nodes, respectively.
        TreeNode current, predecessor;

        // Initialize current node as 'ROOT'.
        current = root;

        // Run a loop until 'CURRENT' != NULL.
        while (current != null) {

            // Check if right subtree of node is NULL instead of left.
            if (current.right == null) {
                // Add current node data to 'ANSWER'.
                answer.add(current.data);

                // Move to left child of current.
                current = current.left;
            }

            else {
                // Find predecessor.
                predecessor = current.right;
                while (predecessor.left != null && predecessor.left != current) {
                    predecessor = predecessor.left;
                }
                /*
                    If the left child of predecessor already points to
                    current node then set left child as NULL and
                    move to left subtree of current.
                */
                if (predecessor.left == current) {
                    predecessor.left = null;
                    current = current.left;
                }

                else {
                    // Add data of currrent node to answer.
                    answer.add(current.data);

                    // Set right subtree of predecessor as current.
                    predecessor.left = current;

                    // Move to right subtree of current.
                    current = current.right;
                }
            }
        }

        // Reverse all elements of 'ANSWER' array.
        Collections.reverse(answer);

        // Return answer.
        return answer;
    }
}
