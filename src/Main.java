public class Main {
    public static void main(String[] args) {
        SchedulerService scheduler = new SchedulerService();
        scheduler.startChecking();

        try {
            Thread.sleep(30000); // 30 soniya ishlasin
        } catch (InterruptedException e) {
            LoggerService.logError(e.getMessage());
        }

        scheduler.stopChecking();
    }
}
