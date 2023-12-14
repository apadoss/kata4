package software.ulpgc.kata3;

import java.sql.SQLException;

public interface Histogram {
    double[] values() throws SQLException;
    int bins();
}
