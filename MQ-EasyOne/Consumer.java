public class Consumer implements Runnable {

    private Storage<Phone> storage;//消费者
    public Consumer(Storage<Phone> storage) {
        this.storage = storage;
    }
    @Override
    public void run() {
        for (int i = 0; i < 110; i++) {
            storage.consumer();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
