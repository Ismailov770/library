import java.util.*;
import java.util.concurrent.*;

public class SchedulerService {

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    // Fake overdue data
    private List<String> overdueBooks = Arrays.asList(
            "Book: Clean Code - User: Ali",
            "Book: Java Basics - User: Laylo"
    );

    public void startChecking() {
        Runnable checkTask = () -> {
            LoggerService.log("check", "Checking for overdue books...");
            for (String record : overdueBooks) {
                LoggerService.log("overdue", record);
            }
        };
        scheduler.scheduleAtFixedRate(checkTask, 0, 10, TimeUnit.SECONDS);
    }

    public void stopChecking() {
        scheduler.shutdown();
        LoggerService.log("system", "Scheduler stopped");
    }
}
