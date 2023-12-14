package software.ulpgc.kata3;

import java.sql.SQLException;

public interface HistogramDisplay {
    void show(Histogram histogram) throws SQLException;
}
