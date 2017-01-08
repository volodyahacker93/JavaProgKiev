package Lection5_6.Task6;

public class Progress implements IProgress {
    private int progress;
    private double prs;

    @Override
    public void update(double percent) {
        prs += percent;
        if ((int) prs > progress) {
            progress = (int) Math.round(prs);
            System.out.println("Progress " + progress + "%");
            if (progress >= 100) {
                System.out.println("Copying is completed!");
            }
        }
    }

    @Override
    public int getProgress() {
        return progress;
    }
}