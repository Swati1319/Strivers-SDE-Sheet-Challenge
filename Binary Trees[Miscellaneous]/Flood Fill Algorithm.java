import java.util.Queue;
import java.util.LinkedList;
import javafx.util.Pair;


public class Solution
{

    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {

        int oldColor = image[x][y];

        // Number of rows.
        int m = image.length;

        // Number of columns.
        int n = image[0].length;

        // Queue to hold the coordinates of the pixels.
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        Pair<Integer, Integer> temp = new Pair<Integer, Integer> (x, y);

        q.add(temp);

        while (!q.isEmpty())
        {

            Pair<Integer, Integer> currentPixel = q.remove();

            // i and j represent the row and column of the current pixel.
            int i = currentPixel.getKey();
            int j = currentPixel.getValue();
;
            // Check if the current coordinates are valid.
            if (i >= 0 && i < m && j >= 0 && j < n)
            {
                // Now, check if the current pixel has been colored or not.
                if (image[i][j] == oldColor && image[i][j] != newColor)
                {
                    // So, replace the old colour.
                    image[i][j] = newColor;

                    // Push the adjacent pixels into the queue.
                    Pair<Integer, Integer> up = new Pair<Integer, Integer> (i, j + 1);
                    Pair<Integer, Integer> down = new Pair<Integer, Integer> (i, j - 1);
                    Pair<Integer, Integer> right = new Pair<Integer, Integer> (i + 1, j);
                    Pair<Integer, Integer> left = new Pair<Integer, Integer> (i - 1, j);

                    q.add(up);
                    q.add(down);
                    q.add(right);
                    q.add(left);
                }
            }
        }

        return image;

    }
}
