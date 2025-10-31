class UserTask implements Runnable {
    private final Library library;
    private final String userName;

    public UserTask(Library library, String userName) {
        this.library = library;
        this.userName = userName;
    }

    @Override
    public void run() {
        library.borrowBook(userName);
        library.makePayment(userName);
    }
}