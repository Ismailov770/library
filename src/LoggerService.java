import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerService {

    private static final String LOG_FILE = "logs.txt";
    private static final String ERROR_FILE = "error.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String action, String detail) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String time = LocalDateTime.now().format(FORMATTER);
            writer.write("[" + time + "] " + action.toUpperCase() + " - " + detail + "\n");
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

    public static void logError(String message) {
        try (FileWriter writer = new FileWriter(ERROR_FILE, true)) {
            String time = LocalDateTime.now().format(FORMATTER);
            writer.write("[" + time + "] ERROR - " + message + "\n");
        } catch (IOException ignored) {}
    }
}
