import java.util.ArrayList;
import java.util.List;

public class Storage<T extends PhoneImpl> {
    private int index = 0;
    private static final int max = 100; // 消息队列的最大值
    private List<T> storage = new ArrayList<>(max);

    public synchronized void producer(T item) {
        while (index >= max) {
            System.out.println("please wait, list is full");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Lets create a new item");
        storage.add(item);
        index++;
        notify(); // 唤醒监视器
    }

    public synchronized T consumer() {
        while (index <= 0) {
            System.out.println("please wait, list is empty");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        index--;
        T item = storage.remove(index);
        String phone = item.getPhone();
        System.out.println("Lets remove item " + phone);
        notify();
        return item;
    }
}