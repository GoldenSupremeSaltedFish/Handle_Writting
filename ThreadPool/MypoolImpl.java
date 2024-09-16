public interface MypoolImpl<Job extends Runnable> {
    void addJob(Job job);
    void execute(Job job);
    void shutdown();
    int getListSize();
}
