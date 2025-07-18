import java.util.Scanner;

public class AdvancedMatrixOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input matrix size
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Matrix input
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();

        // Menu
        int choice;
        do {
            System.out.println("\n===== MATRIX OPERATIONS MENU =====");
            System.out.println("1. Spiral Print");
            System.out.println("2. Rotate 90° Clockwise (only for square matrix)");
            System.out.println("3. Check Symmetric (only for square matrix)");
            System.out.println("4. Zigzag Traversal");
            System.out.println("5. Find Saddle Point");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    spiralPrint(matrix);
                    break;
                case 2:
                    if (rows == cols)
                        rotate90Clockwise(matrix);
                    else
                        System.out.println("Matrix must be square to rotate.");
                    break;
                case 3:
                    if (rows == cols)
                        System.out.println(isSymmetric(matrix) ? "Matrix is Symmetric." : "Matrix is NOT Symmetric.");
                    else
                        System.out.println("Matrix must be square to check symmetry.");
                    break;
                case 4:
                    zigzagTraversal(matrix);
                    break;
                case 5:
                    findSaddlePoint(matrix);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }

    // 1. Spiral Print
    public static void spiralPrint(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        System.out.println("Spiral Order:");
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");
            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
        }
        System.out.println();
    }

    // 2. Rotate 90° Clockwise
    public static void rotate90Clockwise(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        // Reverse rows
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }

        System.out.println("Matrix after 90° Clockwise Rotation:");
        printMatrix(matrix);
    }

    // 3. Check Symmetric
    public static boolean isSymmetric(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] != matrix[j][i])
                    return false;
        return true;
    }

    // 4. Zigzag Traversal
    public static void zigzagTraversal(int[][] matrix) {
        System.out.println("Zigzag Traversal:");
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) { // left to right
                for (int j = 0; j < matrix[i].length; j++)
                    System.out.print(matrix[i][j] + " ");
            } else { // right to left
                for (int j = matrix[i].length - 1; j >= 0; j--)
                    System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println();
    }

    // 5. Saddle Point
    public static void findSaddlePoint(int[][] matrix) {
        boolean found = false;

        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            int colIndex = 0;

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddle = true;
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][colIndex] > min) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println("Saddle Point Found: " + min + " at [" + i + "][" + colIndex + "]");
                found = true;
            }
        }

        if (!found)
            System.out.println("No Saddle Point Found.");
    }

    // Utility function to print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row)
                System.out.print(value + "\t");
            System.out.println();
        }
    }
}
