
import java.util.*;
import java.io.*;

public class Solution {

    public static List < Integer > getPreOrderTraversal(TreeNode root) {

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

            if (current.left == null) {

                // Add current node data to answer.
                answer.add(current.data);

                // Move to right child of current.
                current = current.right;
            }

            else {

                // Find predecessor of current node.
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                
                 /*
                    If the right child of predecessor already points to
                    current node then set right child as NULL and
                    move to right subtree of current.
                */
                if (predecessor.right == current) {
                    predecessor.right = null;
                    current = current.right;
                }

                else {
                    // Add data of currrent node to answer.
                    answer.add(current.data);

                    // Set right subtree of predecessor as 'CURRENT'.
                    predecessor.right = current;

                    // Move to left subtree of 'CURRENT'.
                    current = current.left;
                }
            }
        }

        // Return answer.
        return answer;
    }
}
