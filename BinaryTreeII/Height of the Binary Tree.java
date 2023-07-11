//Height of the Binary Tree From Inorder and Level Order Traversal

import java.util.LinkedList;
import java.util.Queue;

class Node {

    // Height stores the height of the current subtree.
    int height;
    int leftIndex;
    int rightIndex;
}

public class Solution {
    public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N) {
        Queue<Node> q = new LinkedList<>();

        Node init = new Node();

        init.height = 0;
        init.leftIndex = 0;
        init.rightIndex = N - 1;

        q.add(init);

        int [] pos= new int[N+1];
        for(int i=0;i<N;i++){
            pos[inorder[i]] = i;
        }

        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            int curr = levelOrder[i];

            Node now = q.poll();
            int currPos =  pos[levelOrder[i]];

            // There is a left child present.
            if (currPos > now.leftIndex) {
                Node newNode = new Node();

                // Height will increase by 1, as we are descending 1 level downwards in the tree.
                newNode.height = now.height + 1;

                maxHeight = Math.max(maxHeight, newNode.height);

                // New borders of the left subtree in the inorder array.
                newNode.leftIndex = now.leftIndex;
                newNode.rightIndex = currPos - 1;

                q.add(newNode);
            }

            // There is a right child present.
            if (currPos < now.rightIndex) {
                Node newNode = new Node();

                newNode.height = now.height + 1;

                maxHeight = Math.max(maxHeight, newNode.height);

                // New borders of the right subtree in the inorder array.
                newNode.leftIndex = currPos + 1;
                newNode.rightIndex = now.rightIndex;

                q.add(newNode);
            }

        }

        return maxHeight;
    }
}
