import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadDemo {
    public static void main(String[] args) {
        Library library = new Library();


        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new UserTask(library, "Ali"));
        executor.execute(new UserTask(library, "Vali"));
        executor.execute(new UserTask(library, "Laylo"));
        executor.execute(new UserTask(library, "Diyor"));

        executor.shutdown();
    }
}