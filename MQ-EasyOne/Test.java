public class Test {
    public static void main(String[] args) {
        Storage<Phone>storage = new Storage<>();
        new Thread(new Producer(storage)).run();
        new Thread(new Consumer(storage)).run();
    }
}
