package eventType;

/**
 * Created by IntelliJ IDEA.
 * User: monojitdey
 * Date: 8/8/12
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderCreated extends ObjectBase {

    String custId;

    public OrderCreated(String trancId, long ts, String custId) {
        super(trancId, ts);
        this.custId = custId;
    }

    public String getCustId() { return custId; }
    public String toString() { return "tranc id: "+trancId+" timestamp: "+timestamp+" cust id: "+custId; }
}
