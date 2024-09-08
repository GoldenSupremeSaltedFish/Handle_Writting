public class Producer implements  Runnable{


    private Storage<Phone> storage;
    public Producer(Storage<Phone> storage) {
        this.storage = storage;
    }
    @Override
    public void run() {
     for (int i = 0; i < 100; i++)
     {
         storage.producer(new Phone(i));
         //写入序号
         try {
             Thread.sleep(20);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }

     }
    }
}
