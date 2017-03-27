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
            System.out.println("This is thread 1");
            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is thread 2");
            latch_234.countDown();
        });


        t1.start();
        t2.start();

        
        System.out.println("Completed!");
    }
}
