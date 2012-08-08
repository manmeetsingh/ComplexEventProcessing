package objects;

/**
 * Created by IntelliJ IDEA.
 * User: monojitdey
 * Date: 8/8/12
 * Time: 3:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseOrderRaised extends ObjectBase {

    String suppId;

    public PurchaseOrderRaised(String trancId, long ts, String suppId) {
        super(trancId, ts);
        this.suppId = suppId;
    }

    public String getSuppId() { return suppId; }
    public String toString() { return "tranc id: "+trancId+" timestamp: "+timestamp+" supp id: "+suppId; }
}
