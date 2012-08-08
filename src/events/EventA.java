package events;

import java.util.Random;

import objects.A;

import com.espertech.esper.client.EPRuntime;

public class EventA implements Events {
	   private static Random generator = new Random();
	public void  invoke(EPRuntime cepRT){
		 A a=new A(5,generator.nextInt(10));
	        System.out.println("Sending tick:" + a);
	        cepRT.sendEvent(a);

	}
}
