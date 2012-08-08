package objects;

import javax.xml.crypto.Data;
import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: monojitdey
 * Date: 8/8/12
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectBase {

    String trancId;
    long timestamp;

    public ObjectBase(String ti,long ts)
    {
        this.trancId = ti;
        this.timestamp = ts;
    }

    public String getTrancId() { return trancId; }
    public long getTimestamp() { return timestamp; }

}
