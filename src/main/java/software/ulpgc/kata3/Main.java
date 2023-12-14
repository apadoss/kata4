package software.ulpgc.kata3;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(histogram());
        mainFrame.setVisible(true);
    }

    private static Histogram histogram() {
        return new Histogram() {
            @Override
            public double[] values() {
                List<Application> applications = CsvFileApplicationLoader
                        .with(new File("googleplaystore.csv"))
                        .load();

                return applications
                        .stream()
                        .mapToDouble(Application::rating)
                        .toArray();
            }

            @Override
            public int bins() {
                return 5;
            }
        };
    }
}
