package listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.PropertyAccessException;
import com.espertech.esper.client.UpdateListener;
//import sun.nio.ch.SocketOpts;
//import sun.org.mozilla.javascript.JavaScriptException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.*;

/**
 * Created by IntelliJ IDEA.
 * User: monojitdey
 * Date: 8/8/12
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class UdpListener implements UpdateListener{
    public void update(EventBean[] newData, EventBean[] oldData) {

	    System.out.println("Transaction Id="+newData[0].get("tid")+": Latency Between Order Creation and Purchase Order=" + newData[0].get("LatencyAB")+
                            " And Latency between Purchase Order and Shipping="+newData[0].get("LatencyBC"));

        String ip = "172.17.76.74";
        
        
        try {
        	System.out.println("1--->Sending data...");
        	System.out.println(InetAddress.getByName(ip));
        	//UdpListener.sendDataOverUdp("TXNCEP.Order.LatencyAB", newData[0].get("LatencyAB").toString(),InetAddress.getByName(ip),2003);
        	UdpListener.sendDataOverUdp(/*"carbon.txncep.order.latencyab"*/
        			"carbon.installation.TXNCEP", newData[0].get("LatencyAB").toString(),InetAddress.getByName(ip),2003);
        	System.out.println("Sending data...");
        } catch (SocketException e) {
            System.out.println("socket error - Socket Exception" + e.getMessage());
            System.out.println();
        } catch (UnknownHostException e) {
            System.out.println("socket error - UnknownHost" + e.getMessage());
        } catch (PropertyAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }

    public static void sendDataOverUdp(String title,String value,InetAddress IPAddress,int port) throws IOException{
        
   //     DatagramSocket socket = new DatagramSocket();
        String message = title+ " " +value + " " + System.currentTimeMillis()/1000+"\n";
      /*  System.out.println("Message is " + message);
        byte[] data;
        data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,IPAddress,port);
        try {	
        	System.out.println("Sending packets...");
        	socket.send(packet);
        } catch (IOException e) {
            System.out.println("socket-send error");
        }

        socket.close();
*/  Socket socket = new Socket(IPAddress,port);
try {
	   Writer writer = new OutputStreamWriter(socket.getOutputStream());
	   writer.write(message);
	   writer.flush();
	   writer.close();
	  } finally {
	   socket.close();
	  } 	System.out.println("packets sent...");
      
    }
}