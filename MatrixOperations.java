import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i, j, k;

        // Input for Matrix A
        System.out.print("Enter rows of matrix A: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns of matrix A: ");
        int c1 = sc.nextInt();

        int[][] A = new int[r1][c1];
        System.out.println("Enter elements of matrix A:");
        for (i = 0; i < r1; i++) {
            for (j = 0; j < c1; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Input for Matrix B
        System.out.print("Enter rows of matrix B: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns of matrix B: ");
        int c2 = sc.nextInt();

        int[][] B = new int[r2][c2];
        System.out.println("Enter elements of matrix B:");
        for (i = 0; i < r2; i++) {
            for (j = 0; j < c2; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Matrix Addition
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nAddition:");
            int[][] add = new int[r1][c1];
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    add[i][j] = A[i][j] + B[i][j];
                    System.out.print(add[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nAddition not possible");
        }

        // Matrix Subtraction
        if (r1 == r2 && c1 == c2) {
            System.out.println("\nSubtraction:");
            int[][] sub = new int[r1][c1];
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    sub[i][j] = A[i][j] - B[i][j];
                    System.out.print(sub[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nSubtraction not possible");
        }

        // Matrix Multiplication
        if (c1 == r2) {
            System.out.println("\nMultiplication:");
            int[][] mul = new int[r1][c2];

            for (i = 0; i < r1; i++) {
                for (j = 0; j < c2; j++) {
                    mul[i][j] = 0;
                    for (k = 0; k < c1; k++) {
                        mul[i][j] += A[i][k] * B[k][j];
                    }
                    System.out.print(mul[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nMultiplication not possible");
        }

        // Transpose of Matrix A
        System.out.println("\nTranspose of Matrix A:");
        for (i = 0; i < c1; i++) {
            for (j = 0; j < r1; j++) {
                System.out.print(A[j][i] + " ");
            }
            System.out.println();
        }

        // Check Square Matrix
        if (r1 == c1) {
            System.out.println("\nMatrix A is a Square Matrix");

            // Check Diagonal Matrix
            boolean diagonal = true;
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    if (i != j && A[i][j] != 0) {
                        diagonal = false;
                        break;
                    }
                }
            }

            if (diagonal)
                System.out.println("Matrix A is a Diagonal Matrix");
            else
                System.out.println("Matrix A is NOT a Diagonal Matrix");

            // Check Identity Matrix
            boolean identity = true;
            for (i = 0; i < r1; i++) {
                for (j = 0; j < c1; j++) {
                    if (i == j && A[i][j] != 1)
                        identity = false;
                    if (i != j && A[i][j] != 0)
                        identity = false;
                }
            }

            if (identity)
                System.out.println("Matrix A is an Identity Matrix");
            else
                System.out.println("Matrix A is NOT an Identity Matrix");

        } else {
            System.out.println("\nMatrix A is NOT a Square Matrix");
        }

        sc.close();
    }
}
