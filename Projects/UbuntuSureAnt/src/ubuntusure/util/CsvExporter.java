package ubuntusure.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class CsvExporter {
    private CsvExporter() {}
    public static void write(Path path, List<String[]> rows) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (String[] row : rows) {
                for (int i = 0; i < row.length; i++) {
                    if (i > 0) writer.write(',');
                    String value = row[i] == null ? "" : row[i];
                    writer.write('"');
                    writer.write(value.replace("\"", "\"\""));
                    writer.write('"');
                }
                writer.newLine();
            }
        }
    }
}
