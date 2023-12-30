package software.ulpgc.kata3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvFileApplicationLoader implements ApplicationLoader{
    private final File file;

    private CsvFileApplicationLoader(File file) {
        this.file = file;
    }

    public static ApplicationLoader with(File file) {
        return new CsvFileApplicationLoader(file);
    }

    @Override
    public List<Application> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return load(reader);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private List<Application> load(BufferedReader reader) throws IOException {
        List<Application> result = new ArrayList<>();
        reader.readLine();
        while (true) {
            String line = reader.readLine();
            if (line == null) return result;
            result.add(toApplication(line));
        }
    }

    private Application toApplication(String line) {
        return toApplication(line.split(","));
    }

    private Application toApplication(String[] fields) {
        return new Application(
                fields[0],
                fields[1],
                Double.parseDouble(fields[2]),
                Integer.parseInt(fields[3]),
                fields[4],
                fields[5],
                fields[6],
                fields[7],
                fields[8],
                fields[9],
                fields[10],
                fields[11],
                fields[12]
        );
    }
}
