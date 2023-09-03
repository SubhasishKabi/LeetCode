class SolutionD {
    public void rotate(int[][] matrix) {
        flipDiagonally(matrix);
        flipVertically(matrix);
    }

    static void flipDiagonally(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int curr = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = curr;
            }
        }
    }

    static void flipVertically(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int curr = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = curr;
            }
        }
    }
}

public class RotateImage2 {
    public static void main(String[] args) {
        SolutionD solution = new SolutionD();

        // Test Case 1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        solution.rotate(matrix1);
        printMatrix(matrix1);

        // Test Case 2
        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        solution.rotate(matrix2);
        printMatrix(matrix2);

        // Test Case 3
        int[][] matrix3 = {
                {1}
        };
        solution.rotate(matrix3);
        printMatrix(matrix3);
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
