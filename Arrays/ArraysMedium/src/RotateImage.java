class SolutionC {
    public void rotate(int[][] matrix) {
        flipDiagonally(matrix);
        flipVertically(matrix);
    }

    static void flipDiagonally(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int curr = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = curr;
            }
        }
    }

    static void flipVertically(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int curr = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = curr;
            }
        }
    }
}

public class RotateImage {
    public static void main(String[] args) {
        SolutionC solution = new SolutionC();

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
