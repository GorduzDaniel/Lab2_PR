import java.util.concurrent.CountDownLatch;
/**
 * Created by danie on 28-Mar-17.
 */
public class Main {
    public static void main (String[] args){
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch_234 = new CountDownLatch(3);
        CountDownLatch latch5 = new CountDownLatch(1);



        Thread t1 = new Thread(() -> {
            System.out.println("--This is thread 1");
            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("+++This is thread 2");
            latch_234.countDown();
        });
        Thread t3 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("+++This is thread 3");
            latch_234.countDown();
        });
        Thread t4 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("+++This is thread 4");
            latch_234.countDown();
        });

        Thread t5 = new Thread(() -> {
            try {
                latch_234.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--This is thread 5");
            latch5.countDown();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            latch5.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("!!Completed!!");
    }
}
