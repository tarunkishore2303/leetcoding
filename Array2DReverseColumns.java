public class Array2DReverseColumns {

    public static void reverseRows(int[][] matrix) {
        if (matrix == null || matrix.length < 2) {
            return; // Nothing to reverse
        }

        int top = 0; // Pointer for the first row
        int bottom = matrix.length - 1; // Pointer for the last row

        // Continue swapping as long as the top pointer is below the bottom pointer
        while (top < bottom) {
            // 1. Swap the entire inner array (row)
            int[] tempRow = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = tempRow;

            // 2. Move pointers inward
            top++;
            bottom--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        reverseRows(matrix);

        System.out.println("\nMatrix with Reversed Columns:");
        printMatrix(matrix);
    }

    // Utility method (same as above)
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + (i < row.length - 1 ? ", " : ""));
            }
            System.out.println("]");
        }
    }
}