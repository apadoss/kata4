package software.ulpgc.kata3;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.histogramDisplay().show(histogram());
        mainFrame.setVisible(true);
    }

    private static Histogram histogram() {
        return new Histogram() {
            @Override
            public double[] values() throws SQLException {
                try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.1:1521:orcl", "alumno", "orcl")){
                    List<Application> applications = OracleDatabaseApplicationLoader.with(connection).load();

                    return applications
                            .stream()
                            .mapToDouble(Application::rating)
                            .toArray();
                }
            }

            @Override
            public int bins() {
                return 5;
            }
        };
    }
}
