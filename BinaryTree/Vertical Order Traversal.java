import java.util.*;

 

// class TreeNode<T> {

//     public T data;

//     public TreeNode<T> left;

//     public TreeNode<T> right;

 

//     TreeNode(T data) {

//         this.data = data;

//         left = null;

//         right = null;

//     }

// }

class Pair {

    public int column;

    public TreeNode<Integer> node;

 

    Pair(int column, TreeNode<Integer> node) {

        this.column = column;

        this.node = node;

    }

}

public class Solution {

    

 

    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) {

        if (root == null)

            return new ArrayList<Integer>();

 

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, root));

        HashMap<Integer, ArrayList<Integer>> ans = new HashMap<>();

 

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();

            int column = pair.column;

            TreeNode<Integer> node = pair.node;

 

            if (ans.containsKey(column)) {

                ans.get(column).add(node.data);

            } else {

                ArrayList<Integer> list = new ArrayList<>();

                list.add(node.data);

                ans.put(column, list);

            }

 

            if (node.left != null)

                queue.add(new Pair(column - 1, node.left));

            if (node.right != null)

                queue.add(new Pair(column + 1, node.right));

        }

 

        return sortAndFlatten(ans);

    }

 

    public static ArrayList<Integer> sortAndFlatten(HashMap<Integer, ArrayList<Integer>> ans) {

        ArrayList<Integer> result = new ArrayList<>();

        ArrayList<Integer> sortedKeys = new ArrayList<>(ans.keySet());

        Collections.sort(sortedKeys);

 

        for (int key : sortedKeys) {

            ArrayList<Integer> list = ans.get(key);

            result.addAll(list);

        }

 

        return result;

    }

}
