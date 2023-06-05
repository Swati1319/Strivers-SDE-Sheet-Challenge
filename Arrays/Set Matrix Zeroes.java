import java.io.*;
import java.util.*;

public class Solution {
    public static void setZeros(int matrix[][]) {
        int col0 = 1, row = matrix.length, col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (matrix[0][0] == 0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (col0 == 0) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
