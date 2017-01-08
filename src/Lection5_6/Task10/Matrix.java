package Lection5_6.Task10;

public class Matrix extends Thread{

    private int[][] matrix;
    private int[] row;
    private int[] result;
    private boolean finish;

    public Matrix(int[][] matrix, int[] row) {
        this.matrix = matrix;
        this.row = row;
    }

    @Override
    public void run() {
        result = multiplyLine(matrix,row);
        finish = true;
    }

    public static int[] multiplyLine(int[][] matr, int[] row) {
        int result[] = new int[matr.length];

        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr.length; j++) {
                result[i] += row[j] * matr[j][i];
            }
        }
        return result;
    }

    public static int[][] randomMatrix(int matrixSize, int rand) {
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = (int) (Math.random() * rand);
            }
        }

        return matrix;
    }

    public static void showMatrix(int[][] matrix, int matrixSize) {
        for (int i = 0; i < matrixSize; i++){
            for (int j = 0; j < matrixSize; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean getFinish() {
        return finish;
    }

    public int[] getResult() {
        return result;
    }
}
