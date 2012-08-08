package eventProcessor;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import objects.*;
import rules.RuleA;
import listeners.*;

public class Processor {
	public static EPRuntime cepRT;
	public static void executeRules(){
    Configuration cepConfig = new Configuration();
    cepConfig.addEventType("A", A.class.getName());
    EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
    cepRT = cep.getEPRuntime();
    EPAdministrator cepAdm = cep.getEPAdministrator();
    EPStatement cepStatement = cepAdm.createEPL((new RuleA()).getRule());
    cepStatement.addListener(new AListener());
	}


}
