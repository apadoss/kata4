package software.ulpgc.kata3;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private HistogramDisplay histogramDisplay;

    public MainFrame() {
        this.setTitle("Histogram viewer");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(createHistogramDisplay());
    }

    private Component createHistogramDisplay() {
        JFreeChartRatingsHistogramDisplay display = new JFreeChartRatingsHistogramDisplay();
        this.histogramDisplay = display;
        return display;
    }

    public HistogramDisplay histogramDisplay() {
        return histogramDisplay;
    }
}
