package events;

import com.espertech.esper.client.EPRuntime;

import eventType.OrderCreated;
import eventType.PurchaseOrderRaised;
import eventType.ShippingDone;

import java.util.Random;
import java.lang.Runnable;

import static java.lang.Thread.sleep;

/**
 * Created by IntelliJ IDEA.
 * User: monojitdey
 * Date: 8/8/12
 * Time: 3:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class SampleTransactionGenerator implements Events{

    Thread t[];

    public void invoke(EPRuntime cepRT) throws InterruptedException {

        this.t = new Thread[5];
        int i;
        for(i = 0;i<5;i++) {
            this.t[i]=new Thread(new thread(cepRT));
        }
        for(i = 0;i<5;i++) {
            this.t[i].start();
        }
        for(i = 0;i<5;i++) {
            this.t[i].join();
        }


    }

    public static class thread implements Runnable {

        private Random generator = new Random();
        EPRuntime cepRT;

        public thread(EPRuntime cepRT) {
            this.cepRT = cepRT;
        }

        public void run() {

            int i;
            for(i = 0;i<5;i++) {

                String trancId = "tranc" + generator.nextInt(1000);
                long t;

                String custId = "cust" + generator.nextInt(1000);
                t = System.currentTimeMillis();

                OrderCreated oc = new OrderCreated(trancId,t,custId);
                cepRT.sendEvent(oc);
                System.out.println(oc);

                try {
                    Thread.currentThread().sleep(generator.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                String suppId = "supp" + generator.nextInt(1000);
                t = System.currentTimeMillis();

                PurchaseOrderRaised por = new PurchaseOrderRaised(trancId,t,suppId);
                cepRT.sendEvent(por);
                System.out.println(por);

                try {
                    Thread.currentThread().sleep(generator.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                String shipId = "ship" + generator.nextInt(1000);
                t = System.currentTimeMillis();

                ShippingDone sd = new ShippingDone(trancId,t,shipId);
                cepRT.sendEvent(sd);
                System.out.println(sd);


            }



        }


    }
}
