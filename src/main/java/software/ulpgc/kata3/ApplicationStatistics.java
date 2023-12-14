package software.ulpgc.kata3;

import java.util.List;
import java.util.Map;

public interface ApplicationStatistics {
    Map<String, Integer> calculate(List<Application> applications);
}
