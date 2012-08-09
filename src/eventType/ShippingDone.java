package eventType;

/**
 * Created by IntelliJ IDEA.
 * User: monojitdey
 * Date: 8/8/12
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShippingDone extends ObjectBase {

    String shipId;

    public ShippingDone(String trancId, long ts, String shipId) {
        super(trancId, ts);
        this.shipId = shipId;
    }

    public String getShipId() { return shipId; }
    public String toString() { return "tranc id: "+trancId+" timestamp: "+timestamp+" ship id: "+shipId; }
}
