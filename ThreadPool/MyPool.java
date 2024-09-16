import java.util.ArrayList;
import java.util.LinkedList;

public class MyPool<Job extends Runnable>implements MypoolImpl<Job> {
    private static  int CoreSize;
    private static  int ListSize;
    private ArrayList<Worker> workers; // 存储线程的工作列表
    private volatile boolean isShutdown = false;
    private LinkedList<Job> Joblist;
    public MyPool(int CoreSize, int ListSize) {
        MyPool.CoreSize = CoreSize;
        MyPool.ListSize = ListSize;
        Joblist = new LinkedList<>();
        workers = new ArrayList<>();
        for (int i = 0; i < CoreSize; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker).start();
        }
    }

    @Override
    public void addJob(Job job) {
//        synchronized (Joblist) {
//            if (Joblist.size() < ListSize) {
//                Joblist.addLast(job);
//                Joblist.notify(); // 唤醒等待的工作线程
//            } else {
//                // 在这里是拒绝策略
//                System.out.println("任务队列已满，丢弃任务: " + job);
//            }
//        }

    }

    @Override
    public void execute(Job job) {
        if (job != null) {
            synchronized (Joblist) {
                Joblist.addLast(job);
                Joblist.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        isShutdown = true; // 置为关闭状态
        for (Worker worker : workers) {
            worker.shutdown(); // 让所有的 Worker 停止运行
        }

    }


    @Override
    public int getListSize() {
        return Joblist.size();
    }

    //内部类
    public class Worker implements Runnable {
        public boolean running = true;
        @Override
        public void run() {
            while (running || !Joblist.isEmpty())
            {
                Job job = null;
                synchronized (Joblist)
                {
                    while (Joblist.isEmpty() && running)
                    {
                        try {
                            Joblist.wait(); // 确保在持有锁的情况下调用 wait
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (!Joblist.isEmpty()) {
                        job = Joblist.removeFirst();
                    }
                }
                if (job != null) {
                    job.run();
                }

            }

        }
        public void shutdown()
        {
            running=false;
        }
    }
}
