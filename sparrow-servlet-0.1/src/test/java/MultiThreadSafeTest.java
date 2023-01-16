import java.util.concurrent.CountDownLatch;

public class MultiThreadSafeTest {
    private int i = 0;
    public void add(Integer a) {
        this.i++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100000];
        MultiThreadSafeTest threadSafeTest = new MultiThreadSafeTest();
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override public void run() {
                    threadSafeTest.add(1);
                    latch.countDown();
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        latch.await();
        System.out.println(threadSafeTest.i);
    }
}
