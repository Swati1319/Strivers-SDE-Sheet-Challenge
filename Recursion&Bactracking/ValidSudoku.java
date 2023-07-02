public class Solution {

    public static boolean isSafe(int[][] matrix, int row, int col, int num) {

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[i][col] == num) {

                return false;

            }

        }

        for (int j = 0; j < matrix.length; j++) {

            if (matrix[row][j] == num) {

                return false;

            }

        }

        int x = (row / 3) * 3;

        int y = (col / 3) * 3;

        for (int i = x; i < x + 3; i++) {

            for (int j = y; j < y + 3; j++) {

                if (matrix[i][j] == num) {

                    return false;

                }

            }

        }

        return true;

    }

 

    public static boolean helper(int[][] matrix, int row, int col) {

        if (row == matrix.length) {

            return true;

        }

        int nrow, ncol;

        if (col == matrix.length - 1) {

            nrow = row + 1;

            ncol = 0;

        } else {

            nrow = row;

            ncol = col + 1;

        }

        if (matrix[row][col] != 0) {

            return helper(matrix, nrow, ncol);

        } else {

            for (int i = 1; i <= 9; i++) {

                if (isSafe(matrix, row, col, i)) {

                    matrix[row][col] = i;

                    if (helper(matrix, nrow, ncol)) {

                        return true;

                    } else {

                        matrix[row][col] = 0;

                    }

                }

            }

            return false;

        }

    }

 

    public static boolean isItSudoku(int[][] matrix) {

        return helper(matrix, 0, 0);

    }

}

 
