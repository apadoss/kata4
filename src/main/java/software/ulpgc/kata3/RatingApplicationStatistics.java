package software.ulpgc.kata3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingApplicationStatistics implements ApplicationStatistics{
    @Override
    public Map<String, Integer> calculate(List<Application> applications) {
        Map<String, Integer> result = new HashMap<>();
        for (Application application : applications) {
            String key = toInterval(application.rating());
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    private String toInterval(double rating) {
        if (rating < 1) return "0 - 0.9";
        if (rating < 2) return "1 - 1.9";
        if (rating < 3) return "2 - 2.9";
        if (rating < 4) return "3 - 3.9";
        return "4 - 5";
    }
}
