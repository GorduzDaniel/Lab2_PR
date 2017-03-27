import java.util.concurrent.CountDownLatch;
/**
 * Created by danie on 28-Mar-17.
 */
public class Main {
    public static void main (String[] args){
        CountDownLatch latch = new CountDownLatch(1);
        CountDownLatch latch_234 = new CountDownLatch(3);
        CountDownLatch latch5 = new CountDownLatch(1);

        
        System.out.println("Completed!");
    }
}
