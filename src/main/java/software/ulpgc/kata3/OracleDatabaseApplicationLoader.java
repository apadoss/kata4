package software.ulpgc.kata3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class OracleDatabaseApplicationLoader implements ApplicationLoader{
    private Connection connection;
    private static final String QueryAll = "SELECT * FROM applications";

    private OracleDatabaseApplicationLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Application> load() {
        try {
            return load(queryAll());
        } catch (SQLException e) {
            return emptyList();
        }
    }

    private List<Application> load(ResultSet resultSet) throws SQLException {
        List<Application> result = new ArrayList<>();
        while (resultSet.next()) result.add(toApplication(resultSet));
        return result;
    }

    public static OracleDatabaseApplicationLoader with(Connection connection) {
        return new OracleDatabaseApplicationLoader(connection);
    }

    private Application toApplication(ResultSet resultSet) throws SQLException {
        return new Application(
                resultSet.getString("application_name"),
                resultSet.getString("application_category"),
                resultSet.getDouble("rating"),
                resultSet.getInt("reviews"),
                resultSet.getString("application_size"),
                resultSet.getString("installs"),
                resultSet.getString("application_type"),
                resultSet.getString("price"),
                resultSet.getString("content_rating"),
                resultSet.getString("genres"),
                resultSet.getString("last_update"),
                resultSet.getString("current_version"),
                resultSet.getString("android_version")
        );
    }

    private ResultSet queryAll() throws SQLException {
        return connection.createStatement().executeQuery(QueryAll);
    }
}
