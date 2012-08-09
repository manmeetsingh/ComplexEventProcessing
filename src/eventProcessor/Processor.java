package eventProcessor;

import java.util.ArrayList;
import java.util.Iterator;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import config.CEP;
import config.XMLReader;

import eventType.*;
import events.Events;
import rules.*;
import listeners.*;

public class Processor {
	public static EPRuntime cepRT;

	public static void executeRules() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//Reading Config File
		XMLReader.importXML("conf.xml");
		ArrayList<CEP> cepData = XMLReader.getCepArrayList();
		Iterator<CEP> cepIterator =cepData.iterator();
		while(cepIterator.hasNext()) {
			CEP nextCEP=cepIterator.next();
			ArrayList<String> events = nextCEP.getEvents();
			ArrayList<CEP.Rules> rules = nextCEP.getRules();
			Configuration cepConfig = new Configuration();
			//Reading Events
			Iterator<String> eventIterator = events.iterator();
			while (eventIterator.hasNext()) {
				String className = eventIterator.next();
				cepConfig.addEventType(className, className);
			}

			EPServiceProvider cep = EPServiceProviderManager.getProvider(
					"myCEPEngine", cepConfig);
			cepRT = cep.getEPRuntime();
			EPAdministrator cepAdm = cep.getEPAdministrator();
			//Reading Rules			
			Iterator<CEP.Rules> ruleIterator=rules.iterator();
			while(ruleIterator.hasNext()){
				CEP.Rules nextRuleObject=ruleIterator.next();
				Rules nextRule=(Rules)Class.forName(nextRuleObject.getRName()).newInstance();
				EPStatement cepStatement = cepAdm.createEPL(nextRule
					.getRule());
				//Reading Listeners
				Iterator<String> listenerIterator=nextRuleObject.getListeners().iterator();
				while(listenerIterator.hasNext()){
					UpdateListener listener=(UpdateListener)Class.forName(listenerIterator.next()).newInstance();
					cepStatement.addListener(listener);
				}
			}
		}

	}

}
