package events;

import java.util.Random;

import objects.A;

import com.espertech.esper.client.EPRuntime;

public class EventA {
	   private static Random generator = new Random();
	public static void eventA(EPRuntime cepRT){
		 A a=new A(5,generator.nextInt(10));
	        System.out.println("Sending tick:" + a);
	        cepRT.sendEvent(a);

	}
}
