package software.ulpgc.kata3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryApplicationStatistics implements ApplicationStatistics{
    @Override
    public Map<String, Integer> calculate(List<Application> applications) {
        Map<String, Integer> result = new HashMap<>();
        for (Application application : applications) {
            String key = application.category();
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }
}
