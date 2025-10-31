import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Library {
    private int availableBooks = 3;
    private final Lock lock = new ReentrantLock();

    // Kitob olish jarayoni
    public void borrowBook(String user) {
        lock.lock();
        try {
            System.out.println(user + " kitob olishga harakat qilmoqda...");
            if (availableBooks > 0) {
                availableBooks--;
                System.out.println(user + " kitob oldi. Qolgan kitoblar: " + availableBooks);
            } else {
                System.out.println(user + " uchun kitob qolmadi!");
            }
        } finally {
            lock.unlock();
        }
    }

    // To'lov jarayoni (synchronized yordamida xavfsiz)
    public synchronized void makePayment(String user) {
        System.out.println(user + " to‘lov qilmoqda...");
        try {
            Thread.sleep(500); // vaqtni simulyatsiya qilish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(user + " to‘lovni yakunladi.");
    }
}
