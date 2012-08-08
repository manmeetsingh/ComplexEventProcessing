package events;

import com.espertech.esper.client.EPRuntime;

public interface Events {
	public void invoke(EPRuntime cepRT) throws InterruptedException;
}
