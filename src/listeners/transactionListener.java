package listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class transactionListener implements UpdateListener{

	public void update(EventBean[] newData, EventBean[] oldData) {
		/*System.out.println("New data" + newData.length);
		for (int i = 0; i < newData.length; i ++)
		{
			System.out.println(newData[i]);
		}
		System.out.println("Old data" + oldData.length);*/
	     System.out.println("For Transaction Id="+newData[0].get("tid")+": Latency Between Order Creation and Purchase Order=" + newData[0].get("LatencyAB")+
         		" And Latency between Purchase Order and Shipping="+newData[0].get("LatencyBC"));
     }

}
