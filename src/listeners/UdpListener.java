package listeners;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;
import sun.nio.ch.SocketOpts;
import sun.org.mozilla.javascript.JavaScriptException;

import java.io.IOException;
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

        String ip = "127.0.0.1";
        /*try {
        sendDataOverUdp("TXNCEP.Order.LatencyAB", (String) newData[0].get("LatencyAB"),InetAddress.getByAddress(ip.getBytes()),1234);
        } catch (SocketException e) {
            System.out.println("socket error");
        } catch (UnknownHostException e) {
            System.out.println("socket error");
        }*/


    }

    private void sendDataOverUdp(String title,String value,InetAddress IPAddress,int port) throws SocketException{

        DatagramSocket socket = new DatagramSocket();
        String message = title+":"+value;
        byte[] data;
        data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length,IPAddress,port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.out.println("socket-send error");
        }

        socket.close();

    }
}