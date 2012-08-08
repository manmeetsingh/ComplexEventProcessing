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
    Date timestamp;

    public ObjectBase(String ti,long ts)
    {
        this.trancId = ti;
        this.timestamp = new Date(ts);
    }

    public String getTrancId() { return trancId; }
    public Date getTimestamp() { return timestamp; }

}
