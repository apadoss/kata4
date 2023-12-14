package software.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;

import javax.swing.*;
import java.sql.SQLException;

public class JFreeChartRatingsHistogramDisplay extends JPanel implements HistogramDisplay {
    @Override
    public void show(Histogram histogram) throws SQLException {
        JFreeChart ratingsHistogram = ChartFactory.createHistogram(
                "Ratings Histogram",
                "Ratings",
                "Count",
                datasetWith(histogram),
                PlotOrientation.VERTICAL,
                false, false, false
        );
        add(new ChartPanel(ratingsHistogram));
    }

    private HistogramDataset datasetWith(Histogram histogram) throws SQLException {
        HistogramDataset dataset = new HistogramDataset();
        dataset.addSeries("s", histogram.values(), histogram.bins());
        return dataset;
    }
}
