package Lection5_6.Task10;

public class Main {

    public static void main(String[] args) {
        int[][] matrixA = Matrix.randomMatrix(10, 2);
        int[][] matrixB = Matrix.randomMatrix(10, 2);
        int[][] matrixC = new int[matrixA.length][matrixB[0].length];
        final Matrix[] list = new Matrix[matrixA.length];

        long startTime;
        long endTime;
        long multiTime;
        long singleTime;

        //многопоточное перемножение

        startTime = System.nanoTime();
        for (int i = 0; i < list.length; i++) {
            list[i] = new Matrix(matrixB, matrixA[i]);
            list[i].start();
        }

        Thread monitor = new Thread(new Runnable() {
            boolean done = false;

            @Override
            public void run() {
                while (!done) {
                    done = true;
                    for (Matrix m : list) {
                        if (!m.getFinish()) {
                            done = false;
                        }
                    }
                }
            }
        });
        monitor.start();

        try {
            monitor.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        endTime = System.nanoTime();
        multiTime = endTime - startTime;

        // однопоточное перемножение

        startTime = System.nanoTime();
        for (int j = 0; j < matrixA.length; j++) {
            matrixC[j] = Matrix.multiplyLine(matrixB, matrixA[j]);
        }
        endTime = System.nanoTime();
        singleTime = endTime - startTime;

        System.out.println("Done!");
        System.out.println("multiTime = " + multiTime + "ns");
        System.out.println("singleTime = " + singleTime + "ns");

        System.out.println("\nMatrix A:");
        Matrix.showMatrix(matrixA, matrixA.length);

        System.out.println("\nMatrix B:");
        Matrix.showMatrix(matrixB, matrixB.length);

        System.out.println("\nMatrix C = A * B:");
        Matrix.showMatrix(matrixC, matrixC.length);
    }
}
