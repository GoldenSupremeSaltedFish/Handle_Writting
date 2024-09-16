

public class Runex {
    public static void main(String[] args) {
        MyPool myPool=new MyPool<>(5,10);
        class test implements Runnable{
            int num;
            public test(int num)
            {
                this.num=num;
            }
            @Override
            public void run() {
                System.out.println(num);
            }
        }
        for(int i=0;i<10;i++)
        {
            test test1=new test(i);
            myPool.execute(test1);
        }
        myPool.shutdown();

    }
}
